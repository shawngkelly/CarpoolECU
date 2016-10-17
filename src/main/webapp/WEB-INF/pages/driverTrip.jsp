<%--
  Created by IntelliJ IDEA.
  User: shawnkelly
  Date: 10/16/16
  Time: 10:48 PM
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
    <div class="container" id="addDriverTripForm">
        <form class="form">
            <h2 class="form-heading">Add Driver Trip</h2>
            <a href="/">Go to Home Page</a>
            <a href="/student">Update Student</a>
            <a href="/report">View Reports</a>
            <label for="driverID" class="sr-only">Driver ID</label>
            <input type="number" id="driverID" class="form-control"
                   placeholder="Driver ID" required autofocus>
            <label for="departDate" class="sr-only">Depart Date</label>
            <input type="date" id="departDate" class="form-control"
                   placeholder="Depart Date" required >
            <label for="returnDate" class="sr-only">Return Date</label>
            <input type="date" id="returnDate" class="form-control"
                   placeholder="Return Date" required >
            <label for="city1" class="sr-only">City 1</label>
            <input type="text" id="city1" class="form-control"
                   placeholder="City 1" required >
            <label for="city2" class="sr-only">City 2</label>
            <input type="text" id="city2" class="form-control"
                   placeholder="City 2" required >
            <label for="city3" class="sr-only">City 3</label>
            <input type="text" id="city3" class="form-control"
                   placeholder="City 3" required >
            <label for="seats" class="sr-only">Seats</label>
            <input type="number" id="seats" class="form-control"
                   placeholder="Seats" required >
            <button id="btnSubmit" class="btn btn-lg btn-primary btn-block bigButton"
                    type="button">ADD TRIP</button>
        </form>
        <table id="grid-data"
               class="table table-condensed table-hover table-striped">
            <thead>
                <tr>
                    <th data-column-id="tripID"
                        data-type="numeric">Trip ID</th>
                    <th data-column-id="driverID"
                        data-type="numeric">Driver ID</th>
                    <th data-column-id="city1"
                        data-type="text">City 1</th>
                    <th data-column-id="city2"
                        data-type="text">City 2</th>
                    <th data-column-id="city3"
                        data-type="text">City 3</th>
                    <th data-column-id="seats"
                        data-type="numeric">Seats</th>
                    <th data-column-id="commands" data-formatter="commands"
                        data-sortable="false">Commands</th>
                </tr>
            </thead>
        </table>
        <div id="updateAlert" class="well well-lg updateAlert">
            <label for="updateDriverID" class="sr-only">ID</label>
            <input type="numeric" id="updateDriverID" class="form-control"
                   placeholder="Driver ID" required autofocus>
            <label for="updateDepartDate" class="sr-only">Depart Date</label>
            <input type="date" id="updateDepartDate" class="form-control"
                   placeholder="Depart Date" required>
            <label for="updateReturnDate" class="sr-only">Return Date</label>
            <input type="date" id="updateReturnDate" class="form-control"
                   placeholder="Return Date" required>
            <label for="updateCity1" class="sr-only">City 1</label>
            <input type="text" id="updateCity1" class="form-control"
                   placeholder="City 1" required>
            <label for="updateCity2" class="sr-only">City 2</label>
            <input type="text" id="updateCity2" class="form-control"
                   placeholder="City 2" required>
            <label for="updateCity3" class="sr-only">City 3</label>
            <input type="text" id="updateCity3" class="form-control"
                   placeholder="City 3" required>
            <label for="updateSeats" class="sr-only">Seats</label>
            <input type="number" id="updateSeats" class="form-control"
                   placeholder="Seats" required>
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
                data["driverID"] = $("#driverID").val();
                data["departDate"] = splitDate($("#departDate").val());
                data["returnDate"] = splitDate($("#returnDate").val());
                data["city1"] = $("#city1").val();
                data["city2"] = $("#city2").val();
                data["city3"] = $("#city3").val();
                data["seats"] = $("#seats").val();

                $.ajax({
                    type: "POST",
                    contentType: "/application/json",
                    headers: {
                        'ACCEPT': 'application/json',
                        'Content-Type': 'application/json',
                    },
                    url: "/driverTrip/save",
                    data: JSON.stringify(data),
                    dataType: 'json',
                    timeout: 600000,
                    success: function (data) {
                        if (data ==0 ) {
                            alert("Student is not a driver");
                        }
                        $("driverID").val("");
                        $("departDate").val("");
                        $("returnDate").val("");
                        $("city1").val("");
                        $("city2").val("");
                        $("city3").val("");
                        $("seats").val("");
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
                data.driverTripID = targetId;
                data["driverID"] = $("#updateDriverID").val();
                data["departDate"] = splitDate($("#updateDepartDate").val());
                data["returnDate"] = splitDate($("#updateReturnDate").val());
                data["city1"] = $("#updateCity1").val();
                data["city2"] = $("#updateCity2").val();
                data["city3"] = $("#updateCity3").val();
                data["seats"] = $("#updateSeats").val();

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type' : 'application/json',
                    },
                    url:"/driverTrip/update",
                    data: JSON.stringify(data),
                    dataType: 'json',
                    timeout: 600000,
                    success: function (data) {
                        $("#updateDriverID").val("");
                        $("#updateDepartDate").val("");
                        $("#updateReturnDate").val("");
                        $("#updateCity1").val("");
                        $("#updateCity2").val("");
                        $("#updateCity3").val("");
                        $("#updateSeats").val("");
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
                $("#updateCity1").val("");
                $("#updateCity2").val("");
                $("#updateCity3").val("");
                $("#updateSeats").val("");
            });

            //set up grid
            var grid = $("#grid-data").bootgrid({
                ajax: true,
                url: "/driverTrip/list",
                navigation: 0,
                selection: true,
                sorting: false,
                formatters: {
                    "commands": function (column, row) {
                        var str =
                                '<button driverID="'+row.driverID+'"'
                                + ' departDate="'+row.departDate+'"'
                                + ' returnDate="'+row.returnDate+'"'
                                + ' returnDate="'+row.returnDate+'"'
                                + ' city1="'+row.city1+'"'
                                + ' city2="'+row.city2+'"'
                                + ' city3="'+row.city3+'"'
                                + ' seats="'+row.seats+'"'
                                + ' data-row-id="'+row.driverTripID+'"'
                                +
                                ' type="button" class="btn btn-xs btn-default command-edit">'
                                + ' <span class="glyphicon glyphicon-pencil"></span> </button> '
                                +
                                ' <button type="button" class="btn btn-xs btn-default command-delete" data-row-id="' + row.driverTripID + '"> '
                                + ' <span class="glyphicon glyphicon-trash"></span></button>';

                        return str;
                    }
                }
            }).on("loaded.rs.jquery.bootgrid", function() {

                grid.find(".command-edit").on("click", function (e) {
                    targetId = $(this).data("row-id");
                    $("#updateDriverID").val($(this).attr("driverID"));
                    $("#updateDepartDate").val($(this).attr("departDate"));
                    $("#updateReturnDate").val($(this).attr("returnDate"));
                    $("#updateCity1").val($(this).attr("city1"));
                    $("#updateCity2").val($(this).attr("city2"));
                    $("#updateCity3").val($(this).attr("city3"));
                    $("#updateSeats").val($(this).attr("seats"));
                    $("#updateAlert").css("visibility", "visible");

                }).end().find(".command-delete").on("click", function (e) {
                    var bool =confirm("Are you sure?");
                    if (bool) {
                        $.ajax({
                            type: "GET",
                            url: "/driverTrip/delete/" + $(this).data("row-id"),
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

