<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Нова організація перевірки</title>
</head>
<body>
	<h1>Нова організація перевірки</h1>
	<form action="organization" method="post">
		<input type="hidden" name="add">
		<ul>
			<li>Назва організації: <input type="text" name="name"
				autocomplete="off"></li>
			<li>Вид перевірки: <select name="checkType">
					<option value="0">Калібрування</option>
					<option value="1">Повірка</option>
					<option value="2">Калібрування та повірка</option>
			</select>
			</li>
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="organization?list">Список сфер застосування</a>
</body>
</html>