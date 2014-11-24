<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${railwayService.name}</title>
</head>
<body>
	<h1>Редагування ${railwayService.name}</h1>
	<form action="railwayservice" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${railwayService.id}">
		<ul>
			<li>Назва: <input type="text" name="name" value="${railwayService.name}"></li>
			<li>Начальник служби: <input type="text" name="director" value="${railwayService.director}"></li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="railwayservice" method="post">
		<input type="hidden" name="delete"> 
		<input type="hidden" name="id" value="${railwayService.id}"> 
		<input type="submit" value="Видалити">
	</form>
	<a href="railwayservice?list">До списку служб</a>
</body>
</html>