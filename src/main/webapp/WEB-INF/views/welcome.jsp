<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/dashboard.css" rel="stylesheet" type="text/css">

    <title>Main page</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">TEST</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">About<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">History</a></li>
                        <li><a href="#">Contacts</a></li>
                    </ul>
                </li>
                <li><a href="/reports/">Reports</a></li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container-fluid">
    <div class="jumbotron">
        <div class="container">
            <h1>REPORTS</h1>
            <p><a class="btn btn-primary btn-lg" href="/reports/" role="button">Show &raquo;</a></p>
        </div>
    </div>

    <div class="row">

        <div class="col-sm-9 col-md-10 main">
            <div class="col-sm-3 col-md-3">
                <h2>Diagrams ...</h2>
                <p>Text.</p>
                <p><a class="btn btn-primary" href="#" role="button">Go &raquo;</a></p>
            </div>
            <div class="col-sm-3 col-md-3">
                <h2>Something else ...</h2>
                <p>Text.</p>
                <p><a class="btn btn-primary" href="#" role="button">Go &raquo;</a></p>
            </div>
            <div class="col-sm-3 col-md-3">
                <h2>Something else ...</h2>
                <p>Text.</p>
                <p><a class="btn btn-primary" href="#" role="button">Go &raquo;</a></p>
            </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container-fluid">
        <p class="text-center">&copy; 2017 Activity.by</p>
    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>