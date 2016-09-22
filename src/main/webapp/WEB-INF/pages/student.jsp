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
        <label for="Driver?" class="sr-only">Driver?</label>
        <input type="checkbox" id="Driver?" class="from-control"
               placeholder="Driver?" required>
        <label for="Rider?" class="sr-only">Rider?</label>
        <input type="checkbox" id="Rider?" required>

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
            <th data-column-id="Driver?">Driver?</th>
            <th data-column-id="Rider?">Rider?</th>
            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
        </tr>
        </thead>
    </table>

  <%--</body>--%>

</html>
