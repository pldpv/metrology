<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Нове підриєство</title>
</head>
<body>
	<h1>Нове підриєство</h1>
	<form action="company" method="post">
	<input type="hidden" name="add">
	<input type="hidden" name="railwayService_id" value="${railwayService.id}">
	<ul>
		<li>Назва: <input type="text" name="name" autocomplete="off"></li>
		<li>Начальник: <input type="text" name="director" autocomplete="off"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="${railwayService.url}">До ${railwayService.name}</a>
</body>
</html>