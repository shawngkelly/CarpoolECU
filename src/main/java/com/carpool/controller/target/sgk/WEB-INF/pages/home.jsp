<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url value="/resources/css/bootstrap.min.css" var="css"/>
	<spring:url value="/resources/css/site.css" var="site"/>
	<link href="${css}" rel="stylesheet" />
	<link href="${site}" rel="stylesheet" />

</head>
<body>
	<h1>ECU Carpool App</h1>
	<a href="/driver">go to driver</a>

</body>
</html>