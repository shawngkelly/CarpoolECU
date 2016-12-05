<%--
  Created by IntelliJ IDEA.
  User: Amanda
  Date: 10/21/2016
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="css"/>
    <spring:url value="/resources/css/site.css" var="site"/>
    <link href="${css}" rel="stylesheet"/>
    <link href="${site}" rel="stylesheet"/>

</head>

<style type="text/css">

    body {
        background: url(http://www.vaterrarc.com/Content/Images/Products/landing/bg_road2.jpg);
        background-position: center;
        background-repeat: no-repeat;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        border: 20px solid black;
    }

    h1 {
        color: #592A8A;
        font-size: 50px;
        text-align: center;
        border: solid #592A8A 5px;
        background-color: #FEC923;
        background-position: top;
        width: 100%;
        height: 60px;
        border-radius: 15px;
    }

    a {
        color: #592A8A;
    }


    .bigButton {
        background: #FEC923;
        width: 125px;
        border-radius: 15px;
        font-family: Georgia;
        text-align: center;
        color: #592A8A;
        font-size: 30px;
        padding: 5px 10px 5px 10px;
        border: solid #592A8A 5px;
        text-decoration: none;

        position:fixed;
        bottom:25%;
        left:30%;
        right:25%;
    }

    .bigButton :hover {
        background: #FEC923;
        background-image: -webkit-linear-gradient(top, #FEC923, #592A8A);
        background-image: -moz-linear-gradient(top, #FEC923, #592A8A);
        background-image: -ms-linear-gradient(top, #FEC923, #592A8A);
        background-image: -o-linear-gradient(top, #FEC923, #592A8A);
        background-image: linear-gradient(to bottom, #FEC923, #592A8A);
        text-decoration: none;
    }

    .bigButton:active {
        background-color: #3e8e41;
        box-shadow: 0 5px #666;
        transform: translateY(4px);
    }

    div {
        position: fixed;
        top: auto;
        left: auto;
        margin-top: auto;
        margin-left: auto;
    }
</style>

<body>
<h1>ECU Carpool</h1>

<img src="http://www.iconsdb.com/icons/preview/orange/steering-wheel-xxl.png" width="100" height="100"
     style="position:fixed; bottom:34%; left:30.7%; right:30%;">
<img src="http://www.boster-kobayashi.com/wp-content/uploads/2012/05/seat_belt_icon_BKA.jpg" width="100" height="100"
     style="position:fixed; bottom:34%; left:58.7%; right:30%;">

<div>
    <a href="/driver" Class="bigButton"> Drivers </a>
    <a href="/student" Class="bigButton" style="position: fixed; margin-left: 28%"> Riders </a>
</div>