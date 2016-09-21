<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url value="/resources/css/bootstrap.min.css" var="css"/>
	<spring:url value="/resources/css/site.css" var="site"/>
	<spring:url value="/resources/js/bootstrap.min.js" var="js"/>
	<spring:url value="/resources/js/jquery-3.1.0.min.js" var="jquery"/>
	<spring:url value="/resources/jquery.bootgrid-1.3.1/jquery.bootgrid.js" var="grid"/>
	<link href="${css}" rel="stylesheet" />
	<link href="${site}" rel="stylesheet" />

</head>
<body>
	<div class="container" id="addDriverForm">
		<form class="form">
			<h2 class="form-heading">Please add driver</h2>
			<a href="/">go to home</a>
			<label for="firstName" class="sr-only">First Name</label>
			<input type="text" id="firstName" class="form-control" placeholder="First Name" required autofocus>
			<label for="lastName" class="sr-only">Last Name</label>
			<input type="text" id="lastName" class="form-control" placeholder="Last Name" required>
			<button id="btnSubmit" class="btn btn-lg btn-primary btn-block bigButton" type="button">Add Driver</button>
		</form>
		<table id="grid-data" class="table table-condensed table-hover table-striped">
			<thead>
			<tr>
				<th data-column-id="driverId" data-type="numeric">ID</th>
				<th data-column-id="firstName">First Name</th>
				<th data-column-id="lastName">Last Name</th>
				<th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
			</tr>
			</thead>
		</table>
		<div id="updateAlert"  class="well well-lg updateAlert">
			<label for="firstNameUpdate" class="sr-only">Email address</label>
			<input type="text" id="firstNameUpdate" class="form-control" placeholder="First Name" required autofocus>
			<label for="lastNameUpdate" class="sr-only">Password</label>
			<input type="text" id="lastNameUpdate" class="form-control" placeholder="Last Name" required>
			<button id="btnSubmitUpdate" class="btn btn-lg btn-primary btn-block bigButton" type="button">Update Driver</button>
			<button id="btnCancelUpdate" class="btn btn-lg btn-primary btn-block bigButton" type="button">Cancel</button>
		</div>
	</div> <!-- /container -->
	<script src="${jquery}"></script>
	<script src="${js}"></script>
	<script src="${grid}"></script>
	<script>
		$(document).ready(function () {
					var targetId;

					$("#btnSubmit").click(function (event) {
						event.preventDefault();

						var data = {};
                        data["firstName"] = $("#firstName").val();
                        data["lastName"] = $("#lastName").val();

                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
							headers: {
								'Accept': 'application/json',
								'Content-Type': 'application/json'
							},
                            url: "/driver/save",
                            data: JSON.stringify(data),
                            dataType: 'json',
                            timeout: 600000,
                            success: function (data) {
								$("#firstName").val("");
								$("#lastName").val("");
								$("#grid-data").bootgrid("reload");
                            },
                            error: function (e) {
								alert("An error occurred");
                            }
                        });
					});

					//set up alert
					$("#btnSubmitUpdate").click(function (event) {
						event.preventDefault();
						var data = {};
						data.driverId = targetId;
						data["firstName"] = $("#firstNameUpdate").val();
						data["lastName"] = $("#lastNameUpdate").val();
						$.ajax({
							type: "POST",
							contentType: "application/json",
							headers: {
								'Accept': 'application/json',
								'Content-Type': 'application/json'
							},
							url: "/driver/update",
							data: JSON.stringify(data),
							dataType: 'json',
							timeout: 600000,
							success: function (data) {
								$("#firstNameUpdate").val("");
								$("#lastNameUpdate").val("");
								$("#updateAlert").css("visibility", "hidden");
								$("#grid-data").bootgrid("reload");
							},
							error: function (e) {
								alert("An error occurred");
							}
						});
					});
					$("#btnCancelUpdate").click(function (event) {
						event.preventDefault();
						$("#updateAlert").css("visibility", "hidden");
						$("#firstNameUpdate").val("");
						$("#lastNameUpdate").val("");
					});

					//set up grid
					var grid = $("#grid-data").bootgrid({
						ajax: true,
						url: "/driver/list",
						navigation:0,
						selection:true,
						sorting:false,
						formatters: {
							"commands": function (column, row) {
								return "<button fName=\""+row.firstName+"\" lName=\""+row.lastName+"\" type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.driverId + "\"><span class=\"glyphicon glyphicon-pencil\"></span></button> " +
										"<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.driverId + "\"><span class=\"glyphicon glyphicon-trash\"></span></button>";
							}
						}
					}).on("loaded.rs.jquery.bootgrid", function()
					{
						/* Executes after data is loaded and rendered */
						grid.find(".command-edit").on("click", function(e)
						{
							targetId = $(this).data("row-id");
							$("#firstNameUpdate").val($(this).attr("fName"));
							$("#lastNameUpdate").val($(this).attr("lName"));
							$("#updateAlert").css("visibility", "visible");
						}).end().find(".command-delete").on("click", function(e)
						{
							var bool = confirm("Are you sure?");
							if(bool){
								$.ajax({
									type: "GET",
									url: "/driver/delete/"+$(this).data("row-id"),
									dataType: 'text',
									timeout: 600000,
									success: function (data) {
										$("#grid-data").bootgrid("reload");
									},
									error: function (e) {
										alert("An error occurred");
									}
								});
							}
						});
					});


				});

	</script>
</body>
</html>