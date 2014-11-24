<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${company.name}</title>
</head>
<body>
	<h1>Редагування ${company.name}</h1>
	<form action="company" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${company.id}">
		<ul>
			<li>Назва: <input type="text" name="name" value="${company.name}"></li>
			<li>Начальник: <input type="text" name="director" value="${company.director}"></li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="company" method="post">
		<input type="hidden" name="delete"> <input type="hidden"
			name="id" value="${company.id}"> <input type="submit"
			value="Видалити">
	</form>
	<a href="${company.railwayService.url}">Назад до ${company.railwayService.name}</a>
</body>
</html>