<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Створити службу</title>
</head>
<body>
	<h1>Створити службу</h1>
	<form action="railwayservice" method="post">
	<input type="hidden" name="add">
	<ul>
		<li>Назва: <input type="text" name="name" autocomplete="off"></li>
		<li>Начальник служби: <input type="text" name="director" autocomplete="off"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="railwayservice?list">До списку служб</a>
</body>
</html>