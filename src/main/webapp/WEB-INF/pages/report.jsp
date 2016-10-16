<%--
  Created by IntelliJ IDEA.
  User: shawnkelly
  Date: 10/10/16
  Time: 1:08 PM
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
    <div class="container" id="reports">
        <h2 class="form-heading">Trip Reports</h2>
        <a href="/" id="button1" class="btn btn-info" role="button">Go
        to Home</a>
        <a href="/student" id="button2" class="btn btn-info"
           role="button">Update Students</a>
        <a href="/riderTrip" id="button3" class="btn btn-info"
           role="button">Update Rider Trip</a>

        <button id="btnSubmitRiderTrip" class="btn btn-sm btn-info ridertrip"
                type="button">Rider W/ Trips</button>
        <button id="btnSubmitRiderNoTrip"
                class="btn btn-sm btn-info ridertrip"
                type="button">Rider No Trips</button>

        <table id ="grid-data"
               class ="table table-condensed table-hover table-striped">
            <thead>
            <tr>
                <th id="col1" data-column-id="col1" data-type="txt">col1</th>
                <th id="col2" data-column-id="col2" data-type="txt">col2</th>
                <th id="col3" data-column-id="col3" data-type="txt">col3</th>
                <th id="col4" data-column-id="col4" data-type="txt">col4</th>
                <th id="col5" data-column-id="col5" data-type="txt">col5</th>
                <th id="col6" data-column-id="col6" data-type="txt">col6</th>
                <th id="col7" data-column-id="col7" data-type="txt">col7</th>
            </tr>
            </thead>
        </table>
    </div>
<script src="${jquery}"></script>
<script src="${js}"></script>
<script src="${grid}"></script>
<script>
    var reportid = "";
    function getUrl(){
        return "/report/list/"+reportid;
    }
    $(document).ready(function(){

        $(".ridertrip").click(function(event){
            event.preventDefault();

            var buttonid = event.currentTarget.id;



            if (buttonid == "btnSubmitRiderTrip") {

                reportid = "1";
                $("#col1").text("ID");
                $("#grid-data").bootgrid("reload");
            }
        })

        //set up grid
        var grid = $("#grid-data").bootgrid({
            ajax: true,
            ajaxSettings: {
                method: "GET",
                cache: false
            },
            url: getUrl,
            navigation: 0,
            selection:true,
            sorting:false




        })
    })





</script>

</body>
</html>
