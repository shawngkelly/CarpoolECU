<%--
  Created by IntelliJ IDEA.
  User: shawnkelly
  Date: 11/24/16
  Time: 4:09 PM
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
        <spring:url value="/resources/css/styles.css" var="styles"/>
    <link href="${css}" rel="stylesheet" />
    <link href="${site}" rel="stylesheet" />
    <link href="${ecu}" rel="stylesheet"/>
    <link href="${styles}" rel="stylesheet" />
<body>
    <div class="container" id="matchedTrips">
        <form class="form">
            <h2 class="form-heading">TRIPS TO APPROVE</h2>
            <a href="/">Go Home</a>
            <a href="/student">Students</a>
            <a href="/report">View Reports</a>
        </form>
    </div>

</body>
</html>
