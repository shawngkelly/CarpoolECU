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
             <label for="StudentID" class="sr-only">Student ID</label>
             <input type="number" id="StudentID" class="form-control"
                    placeholder="Student ID" required autofocus>
             <label for="DepartDate" class="sr-only">Depart Date</label>
             <input type="date" id="DepartDate" class="form-control"
                    placeholder="Depart Date" required>
             <label for="ReturnDate" class="sr-only">Return Date</label>
             <input type="date" id="ReturnDate" class="form-control"
                    placeholder="Return Date" required>
             <label for="City" class="sr-only">City</label>
             <input type="text" id="City" class="form-control"
                    placeholder="City" required>
              <button id="btnSubmit"
                      class="btn btn-lg btn-primary btn-block bigButton"
                      type="button">ADD TRIP</button>
             </form>
             <table id="grid-data"
                    class="table table-condensed table-hover table-striped">
                 <thread>
                     <tr>
                         <th data-column-id="riderTripID"
                             data-type="numeric">Trip ID</th>
                         <th data-column-id="student ID"
                             data-type="numeric">Student ID</th>
                         <th data-column-id="departDate"
                             data-type="date">Depart Date</th>
                         <th data-column-id="Return Date"
                             data-type="date">Return Date</th>
                         <th data-column-id="city" data-type="text">City</th>
                         <th data-column-id="commands"
                             data-formatter="commands"
                             data-sortable="false">Commands</th>

                     </tr>
                 </thread>
             </table>
             <div id="updateAlert" class="well well-lg updateAlert">
                <label for="updateStudentID" class="sr-only">ID</label>
                <input type="numeric" id="updateStudentID" class="form-control"
                       placeholder="Student ID" required autofocus>
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
    $(document).ready(function () {
        var targetId;

        $("#btnSubmit").click(function (event) {
            event.preventDefault();

            var data = {};
            data["studentID"] = $("#studentID").val();
            data["departDate"] = $("#departDate").val();
            data["returnDate"] = $("#returnData").val();
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
                    $("studentID").val("");
                    $("departDate").val("");
                    $("returnDate").val("");
                    $("city").val("");
                    $("#grid-data").bootgrid("reload");

                },
                error: function(e) {
                    alert("An error has occured");
                }
            });
        });

        //set up alert
        $("btnSubmitUpdate").click(function (event) {
            event.preventDefault();
            var data = {};
            data.riderTripID = targetId;
            data["studentID"] = $("#studentIDUpdate").val("");
            data["departDate"] = $("#departDateUpdate").val("");
            data["returnDate"] = $("#returnDateUpdate").val("");
            data["city"] = $("#cityUpdate").val("");

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
                    $("#studentIDUpdate").val("");
                    $("#departDateUpdate").val("");
                    $("#returnDateUpdate").val("");
                    $("#cityUpdate").val("");
                    $("#updateAlert").css("visibility", "hidden");
                    $("#grid-data").bootgrid("reload");
                },
                error: function (e) {
                    alert("An error has occurred");
                }
            });
        });

        $("#btnCancelUpdate").click(function (event) {
            // LINE 180
        })

    })
</script>