<%--
  Created by IntelliJ IDEA.
  User: shawnkelly
  Date: 9/22/16
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
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
<div class="container" id="addStudentForm">
    <form class="form">
        <h2 class="form-heading">Please add Student</h2>
        <a href="/">go to home</a>
        <label for="firstName" class="sr-only">First Name</label>
        <input type="text" id="firstName" class="form-control" placeholder="First Name" required autofocus>
        <label for="lastName" class="sr-only">Last Name</label>
        <input type="text" id="lastName" class="form-control" placeholder="Last Name" required>
        <label for="email" class="sr-only">Email</label>
        <input type="text" id="email" class="form-control"
               placeholder="Email" required>
        <%--<label for="driver" class="sr-only">Driver</label>--%>
        <input type="checkbox" name="Driver" value="Driver"> Driver
        <%--input type="text" id="driver" class="form-control"
               placeholder="Driver" required--%>
       <%--<label for="rider" class="sr-only">Rider</label>--%>
        <input type="checkbox" name="Rider" value="Rider"> Rider
        <%--input type="text" id="rider" class="form-control"
               placeholder="Rider?" required--%>

        <button id="btnSubmit"
                class="btn btn-lg btn-primary btn-block bigButton"
                type="button">Add Student</button>
    </form>
    <table id="grid-data" class="table table-condensed table-hover table-striped">
        <thead>
        <tr>
            <th data-column-id="idStudent" data-type="numeric">ID</th>
            <th data-column-id="firstName">First Name</th>
            <th data-column-id="lastName">Last Name</th>
            <th data-column-id="email">Email</th>
            <th data-column-id="driver">Driver</th>
            <th data-column-id="rider">Rider</th>
            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
        </tr>
        </thead>
    </table>
    <div id="updateAlert"  class="well well-lg updateAlert">
        <label for="firstNameUpdate" class="sr-only">FirstName</label>
        <input type="text" id="firstNameUpdate" class="form-control" placeholder="First Name" required autofocus>
        <label for="lastNameUpdate" class="sr-only">LastName</label>
        <input type="text" id="lastNameUpdate" class="form-control" placeholder="Last Name" required>
        <label for="emailUpdate" class="sr-only">Email</label>
        <input type="text" id="emailUpdate" class="form-control"
               placeholder="Email" required>

        <%--<label for="driver" class="sr-only">Driver</label>--%>
        <input type="checkbox" name="Driver" value="Driver"> Driver
        <%--input type="text" id="driver" class="form-control"
               placeholder="Driver" required--%>
        <%--<label for="rider" class="sr-only">Rider</label>--%>
        <input type="checkbox" name="Rider" value="Rider"> Rider
        <%--input type="text" id="rider" class="form-control"
               placeholder="Rider?" required--%>

        <button id="btnSubmitUpdate"
                class="btn btn-lg btn-primary btn-block bigButton"
                type="button">Update Student</button>

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
            data["email"] = $("#email").val();

            data["driver"] = $("#driver").val();
            data["rider"] = $("#rider").val();
            <%--data["driver"] = $(".driver").attr('checked', true);
            data["rider"] = $(".rider").attr('checked', true); --%>

            $.ajax({
                type: "POST",
                contentType: "application/json",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "/student/save",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                    $("#firstName").val("");
                    $("#lastName").val("");
                    $("#email").val("");
                    $("#driver").val("");
                    $("#rider").val("");

                    <%--$(".driver").attr('checked', true);
                    $(".rider").attr('checked', true); --%>

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
            data.idStudent = targetId;
            data["firstName"] = $("#firstNameUpdate").val("");
            data["lastName"] = $("#lastNameUpdate").val("");
            data["email"] = $("#emailUpdate").val("");
            data["driver"] = $("#driverUpdate").val("");
            data["rider"] = $("#riderUpdate").val("");
            //data{"driver"} = document.getElementById("checkbox").checked;
            //data["rider"] = document.getElementById("checkbox").checked;

            <%--data["driver"] = $(".driverUpdate").attr('checked', true);
            data["rider"] = $(".riderUpdate").attr('checked', true); --%>

            $.ajax({
                type: "POST",
                contentType: "application/json",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "/student/update",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                    $("#firstNameUpdate").val("");
                    $("#lastNameUpdate").val("");
                    $("#emailUpdate").val("");
                    $("#driverUpdate").val("");
                    $("#riderUpdate").val("");


                    <%--$(".driverUpdate").attr('checked', true);
                    $(".riderUpdate").attr('checked', true); --%>

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
            $("#emailUpdate").val("");
            $("#driverUpdate").val("");
            $("#riderUpdate").val("");

            <%-- $(".Driver?update").attr('checked', true);
            $(".Rider?update").attr('checked', true); --%>
        });

        //set up grid
        var grid = $("#grid-data").bootgrid({
            ajax: true,
            url: "/student/list",
            navigation: 0,
            selection: true,
            sorting: false,
            formatters: {
                "commands": function (column, row) {
                    return"<button fName=\"" + row.firstName + "\"  lName=\"" + row.lastName + "\" eMail=\"" + row.email + "\" driver=\"" + row.driver + "\" rider=\"" + row.rider + "\" type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.idStudent + "\"><span class=\"glyphicon glyphicon-pencil\"></span></button> " +
                    "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.idStudent + "\"><span class=\"glyphicon glyphicon-trash\"></span></button>";
                }
            }
        }).on("loaded.rs.jquery.bootgrid", function () {

            /* Executes after data is loaded and rendered */
            grid.find(".command-edit").on("click", function (e) {
                targetId = $(this).data("row-id");
                $("#firstNameUpdate").val($(this).attr("fName"));
                $("#lastNameUpdate").val($(this).attr("lName"));
                $("#emailUpdate").val($(this).attr("eMail"));
                $("#driverUpdate").val($(this).attr("rider"));
                $("#riderUpdate").val($(this).attr("driver"));

                $("#updateAlert").css("visibility", "visible");
            }).end().find(".command-delete").on("click", function (e) {
                var bool = confirm("Are you sure?");
                if (bool) {
                    $.ajax({
                        type: "GET",
                        url: "/student/delete/" + $(this).data("row-id"),
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