<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${organization.name}</title>
</head>
<body>
	<h1>Редагування${organization.name}</h1>
	<form action="organization" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${organization.id}">
		<ul>
			<li>Назва організації: <input type="text" name="name" value="${organization.name}"autocomplete="off"></li>
			<li>Вид перевірки: 
			<select name="checkType">
				<option value="0" <c:if test="${organization.checkType == 0})"> selected </c:if>>Калібрування</option>
				<option value="1" <c:if test="${organization.checkType == 1})"> selected </c:if>>Повірка</option>
				<option value="2" <c:if test="${organization.checkType == 2})"> selected </c:if>>Калібрування та повірка</option>
			</select>
		</li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="organization" method="post">
		<input type="hidden" name="delete"> 
		<input type="hidden" name="id" value="${organization.id}"> 
		<input type="submit" value="Видалити">
	</form>
	<a href="organization?list">Огранізації з перевірки</a>
</body>
</html>