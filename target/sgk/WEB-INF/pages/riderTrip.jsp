<%--
  Created by IntelliJ IDEA.
  User: shawnkelly
  Date: 10/6/16
  Time: 12:06 PM
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
    <spring:url value="/resources/css/ecucarpoolthemes.css" var="ecu" />
    <link href="${css}" rel="stylesheet" />
    <link href="${site}" rel="stylesheet" />
    <link href="${ecu}" rel="stylesheet"/>
</head>
<body>
     <div class="container" id="addRiderTripForm">
         <form class="form">
             <h2 class="form-heading">Add Rider Trip</h2>
             <a href="/">Go to Home Page</a>
             <a href="/student">Update Student</a>
             <label for="riderID" class="sr-only">Rider ID</label>
             <input type="number" id="riderID" class="form-control"
                    placeholder="Rider ID" required autofocus>
             <label for="departDate" class="sr-only">Depart Date</label>
             <input type="date" id="departDate" class="form-control"
                    placeholder="Depart Date" required>
             <label for="returnDate" class="sr-only">Return Date</label>
             <input type="date" id="returnDate" class="form-control"
                    placeholder="Return Date" required>
             <label for="city" class="sr-only">City</label>
             <input type="text" id="city" class="form-control"
                    placeholder="City" required>
              <button id="btnSubmit"
                      class="btn btn-lg btn-primary btn-block bigButton"
                      type="button">ADD TRIP</button>
             </form>
             <table id="grid-data"
                    class="table table-condensed table-hover table-striped">
                 <thead>
                     <tr>
                         <th data-column-id="riderTripID"
                             data-type="numeric">Trip ID</th>
                         <th data-column-id="riderID"
                             data-type="numeric">Rider ID</th>
                         <th data-column-id="departDate"
                             data-type="date">Depart Date</th>
                         <th data-column-id="returnDate"
                             data-type="date">Return Date</th>
                         <th data-column-id="city" data-type="text">City</th>
                         <th data-column-id="commands"
                             data-formatter="commands"
                             data-sortable="false">Commands</th>

                     </tr>
                 </thead>
             </table>
             <div id="updateAlert" class="well well-lg updateAlert">
                <label for="updateRiderID" class="sr-only">ID</label>
                <input type="numeric" id="updateRiderID" class="form-control"
                       placeholder="Rider ID" required autofocus>
                 <label for="updateDepartDate" class="sr-only">Depart
                     Date</label>
                 <input type="date" id="updateDepartDate" class="form-control"
                        placeholder="Depart Date" required>
                 <label for="updateReturnDate" class="form-control">Return Date
                 </label>
                 <input type="date" id="updateReturnDate"
                        class="form-control" placeholder="Return Date" required>
                 <label for="updateCity" class="form-control">City</label>
                 <input type="text" id="updateCity" class="form-control"
                        placeholder="City" required>
                 <button id="btnSubmitUpdate"
                         class="btn btn-lg btn-primary btn-block bigButton"
                         type="button">Update Trip</button>
                 <button id="btnCancelUpdate"
                         class="btn btn-lg btn-primary btn-block bigButton"
                         type="button">Cancel</button>
             </div>
</div> <!--container-->
<script src="${jquery}"></script>
<script src="${js}"></script>
<script src="${grid}"></script>
<script>

    <%-- Used to convert date to proper format for SQL ---%>

    function splitDate(dateIn){
        var arr = dateIn.split("-");
        return new Date(arr[0],arr[1]-1,arr[2]);
    }
    $(document).ready(function () {
        var targetId;

        $("#btnSubmit").click(function (event) {
            event.preventDefault();

            var data = {};
            data["riderID"] = $("#riderID").val();
            data["departDate"] = splitDate($("#departDate").val());
            data["returnDate"] = splitDate($("#returnDate").val());
            data["city"] = $("#city").val();

            $.ajax({
                type: "POST",
                contentType: "/application/json",
                headers: {
                    'ACCEPT': 'application/json',
                    'Content-Type': 'application/json',
                },
                url: "/riderTrip/save",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                    if (data ==0 ) {
                        alert("Student is not a rider");
                    }
                    $("riderID").val("");
                    $("departDate").val("");
                    $("returnDate").val("");
                    $("city").val("");
                    $("#grid-data").bootgrid("reload");

                },
                error: function(e) {
                    alert("An error has occurred");
                }
            });
        });

        //set up alert
        $("#btnSubmitUpdate").click(function (event) {
            event.preventDefault();
            var data = {};
            data.riderTripID = targetId;
            data["riderID"] = $("#updateRiderID").val();
            data["departDate"] = splitDate($("#updateDepartDate").val());
            data["returnDate"] = splitDate($("#updateReturnDate").val());
            data["city"] = $("#updateCity").val();

            $.ajax({
                type: "POST",
                contentType: "application/json",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type' : 'application/json',
                },
                url:"/riderTrip/update",
                data: JSON.stringify(data),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                    $("#updateRiderID").val("");
                    $("#updateDepartDate").val("");
                    $("#updateReturnDate").val("");
                    $("#updateCity").val("");
                    $("#updateAlert").css("visibility", "hidden");
                    $("#grid-data").bootgrid("reload");
                },
                error: function (e) {
                    alert("An error has occurred");
                }
            });
        });

        $("#btnCancelUpdate").click(function (event) {
            event.preventDefault();
            $("#updateAlert").css("visibility","hidden");
            $("#updateStudentID").val("");
            $("#updateDepartDate").val("");
            $("#updateReturnDate").val("");
            $("#updateCity").val("");
        });

        //set up grid
        var grid = $("#grid-data").bootgrid({
            ajax: true,
            url: "/riderTrip/list",
            navigation: 0,
            selection: true,
            sorting: false,
            formatters: {
               "commands": function (column, row) {
                   var str =
                    '<button riderID="'+row.riderID+'"'
                           + ' departDate="'+row.departDate+'"'
                           + ' returnDate="'+row.returnDate+'"'
                           + ' returnDate="'+row.returnDate+'"'
                           + ' city="'+row.city+'"'
                           + ' data-row-id="'+row.riderTripID+'"'
                           +
                           ' type="button" class="btn btn-xs btn-default command-edit">'
                           + ' <span class="glyphicon glyphicon-pencil"></span> </button> '
                           + ' <button type="button" class="btn btn-xs btn-default command-delete" data-row-id="' + row.riderTripID + '"> '
                           + ' <span class="glyphicon glyphicon-trash"></span></button>';

                   return str;
               }
            }
        }).on("loaded.rs.jquery.bootgrid", function() {

            grid.find(".command-edit").on("click", function (e) {
                targetId = $(this).data("row-id");
                $("#updateRiderID").val($(this).attr("riderID"))
                $("#updateDepartDate").val($(this).attr("departDate"));
                $("#updateReturnDate").val($(this).attr("returnDate"));
                $("#updateCity").val($(this).attr("city"));
                $("#updateAlert").css("visibility", "visible");

            }).end().find(".command-delete").on("click", function (e) {
                var bool =confirm("Are you sure?");
                if (bool) {
                    $.ajax({
                        type: "GET",
                        url: "/riderTrip/delete/" + $(this).data("row-id"),
                        dataType: 'text',
                        timeout: 600000,
                        success: function (data) {
                            $("#grid-data").bootgrid("reload");
                        },
                        error: function (e) {
                            alert("A Tribute has Fallen");
                        }
                    });
                }
            });
        });

    });
</script>
</body>
</html>