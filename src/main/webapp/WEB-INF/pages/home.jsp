<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url value="/resources/css/bootstrap.min.css" var="css"/>
	<spring:url value="/resources/css/site.css" var="site"/>
	<spring:url value="/resources/css/ecucarpoolthemes.css" var="carpool"/>
	<link href="${css}" rel="stylesheet" />
	<link href="${site}" rel="stylesheet" />
    <link href="${carpool}" rel="stylesheet" />
</head>
<body>

	<h1>ECU Carpool App</h1>
	<a href="/driver">go to driver</a>
	<a href="/student" id="button1" class="btn btn-info" role="button">Update
		Students</a>
	<a href="/riderTrip" id="button2" class="btn btn-info"
	role="button">Update Rider Trip</a>

</body>
</html>