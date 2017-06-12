<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/dashboard.css" rel="stylesheet" type="text/css">

    <title>Reports page</title>
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
    <div class="container">

        <form:form method="POST" modelAttribute="reportForm" class="form-signin">
            <h2 class="form-signin-heading">Enter criteria</h2>
            <spring:bind path="startDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    From
                    <form:input path="startDate" class="form-control" placeholder="Start date (e.g. Jan 1, 2014)"
                                autofocus="true"/>
                    <form:errors path="startDate"/>
                </div>
            </spring:bind>

            <spring:bind path="endDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    To
                    <form:input path="endDate" class="form-control" placeholder="End date (e.g. Jan 31, 2014)"/>
                    <form:errors path="endDate"/>
                </div>
            </spring:bind>

            <spring:bind path="performer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select path="performer" class="form-control" autofocus="true">
                        <form:option value="" label="All Performers"></form:option>
                        <form:options items="${allPerformers}"/>
                    </form:select>
                    <form:errors path="performer"/>
                </div>
            </spring:bind>

            <div class="btn-group form-group">
                <form:button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                             aria-haspopup="true" aria-expanded="false">
                    PERIOD
                    <span class="caret"></span>
                </form:button>
                <ul class="dropdown-menu">
                    <c:forEach var="period" items="${reportForm.periods}">
                        <li>
                            <a href="/reports/${period}">${period}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
    </div>

    <div class="container">
        <c:if test="${reports != null}">
            <c:choose>
                <c:when test="${reports.isEmpty()}">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            report not found
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Performer</th>
                            <th>Activity</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${reports}" var="report">
                            <tr>
                                <td><spring:eval expression="report.startDate"></spring:eval></td>
                                <td><spring:eval expression="report.endDate"></spring:eval></td>
                                <td>${report.performer}</td>
                                <td>${report.activity}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </c:if>
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