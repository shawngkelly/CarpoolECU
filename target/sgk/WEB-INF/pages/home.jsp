<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url value="/resources/css/bootstrap.min.css" var="css"/>
	<spring:url value="/resources/css/site.css" var="site"/>
	<spring:url value="/resources/css/ecucarpoolthemes.css" var="carpool"/>
	<spring:url value="/resources/css/styles.css" var="styles"/>
	<link href="${css}" rel="stylesheet" />
	<link href="${site}" rel="stylesheet" />
    <link href="${carpool}" rel="stylesheet" />
	<link href="${styles}" rel="stylesheet"/>
</head>
<body>

	<h1>ECU Carpool App</h1>
	<a href="/driver">go to driver</a>
	<a href="/student" id="button1" class="btn btn-info" role="button"
	style="position:fixed; bottom:60%; left:30.7%; right:30%">
		Update Students</a>
	<a href="/riderTrip" id="button2" class="btn btn-info" role="button"
	style="position:fixed; bottom:45%; left:30.7%; right:30%">
		Update Rider Trip</a>
	<a href="/driverTrip" id="button4" class="btn btn-info" role="button"
	style="position:fixed; bottom:30%; left:30.7%; right:30%">
		Update Driver Trip</a>
	<a href="/report" id =button3" class="btn btn-info" role="button"
	style="position:fixed; bottom:15%; left:30.7%; right:30%">
		Go to Reports</a>

</body>
</html>