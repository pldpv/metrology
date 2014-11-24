<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Новий відділ</title>
</head>
<body>
	<h1>Новий відділ</h1>
		<form action="department" method="post">
	<input type="hidden" name="add">
	<input type="hidden" name="company_id" value="${company.id}">
	<ul>
		<li>Назва: <input type="text" name="name" autocomplete="off"></li>
		<li>Начальник : <input type="text" name="director" autocomplete="off"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="${company.url}">До ${company.name}</a>
</body>
</html>