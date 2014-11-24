<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${department.name}</title>
</head>
<body>
	<h1>Редагування ${department.name}</h1>
	<form action="department" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${department.id}">
		<ul>
			<li>Назва відділу: <input type="text" name="name" value="${department.name}"></li>
			<li>Начальник відділу: <input type="text" name="director" value="${department.director}"></li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="department" method="post">
		<input type="hidden" name="delete"> <input type="hidden"
			name="id" value="${department.id}"> <input type="submit"
			value="Видалити">
	</form>
	<a href="${department.company.url}">Назад до ${department.company.name}</a>
</body>
</html>