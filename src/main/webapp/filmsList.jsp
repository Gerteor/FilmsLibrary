<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/css/style.css" %>
</style>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Title</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <%@ include file="header.jsp" %>
</div>

<body>
<center>
<form action="<%= request.getContextPath()%>/search" method="POST">
    <div class="row">
        <div class="span10">
            <form data-bind="submit: AddDepartment " class="form-inline">
                <input type="text" class="input-large" placeholder="Director" name="name" />
                <input type="number" class="input-large" placeholder="Release from" name="first"/>
                <input type="number" class="input-large" placeholder="Release until" name="second"/>
                <button type="submit" class="button button1">Search</button>
            </form>
        </div>
    </div>
</form>

<table class="simple-little-table" cellspacing='0'>

    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birth date</th>
        <th>Film Name</th>
        <th>Release Date</th>
        <th>Genre</th>
    </tr>
    <c:forEach items="${filmsList}" var="director">

        <tr>
            <td>${director.firstName}</td>
            <td>${director.lastName}</td>
            <td>${director.birthDate}</td>
            <td>${director.films.nameFilm}</td>
            <c:choose>
                <c:when test="${empty director.films.releaseDate}">
                    <td>${director.films.dateYear}</td>
                </c:when>
                <c:when test="${0 == director.films.dateYear}">
                    <td>${director.films.releaseDate}</td>
                </c:when>
            </c:choose>
            <td>${director.films.genre}</td>
        </tr>

    </c:forEach>
</table>

<div class="container">
    <%@ include file="footer.jsp" %>
</div>
</center>
</body>
</html>