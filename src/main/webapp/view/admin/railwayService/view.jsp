<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>${railwayService.name}</title>
</head>
<body>
	<h1>${railwayService.name}</h1>
	<ul>
		<c:forEach var="company" items="${railwayService.companies}">
			<li><a href="${company.url}">${company.name}</a></li>
		</c:forEach>
	</ul>
	<a href="${railwayService.url}&edit">Редагувати службу</a>|
	<a href="company?add&railwayService_id=${railwayService.id}">Створити підприємство</a>|
	<a href="railwayservice?list">До списку служб</a>
</body>
</html>