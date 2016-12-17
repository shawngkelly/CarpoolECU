<%--
  Created by IntelliJ IDEA.
  User: Shawn
  Date: 12/11/2016
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>ECU CarPool APP</h1>
<form name="login">
    Username<input type="text" name="userid"/>
    Password<input type="password" name="pswrd"/>
    <input type="button" onclick="check(this.form)" value="Login"/>
    <input type="reset" value="Cancel"/>
</form>
<script language="javascript">
    function check(form)/*function to check userid & password*/
    {
        /*the following code checkes whether the entered userid and password are matching*/
        if(form.userid.value == "myuserid" && form.pswrd.value == "mypswrd")
        {
            window.open('target.html')/*opens the target page while Id & password matches*/
        }
        else
        {
            alert("Error Password or Username")/*displays error message*/
        }
    }
</script>
</body>




</html>

