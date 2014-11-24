<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${instrumentCategory.category}</title>
</head>
<body>
	<h1>Редагування ${instrumentCategory.category}</h1>
	<form action="instrumentcategory" method="post">
		<input type="hidden" name="edit"> 
		<ul>
		<li>Код виду: <input type="text" name="id" value="${instrumentCategory.id}"autocomplete="off"></li>
		<li>Вид вимірювання: <input type="text" name="category" value="${instrumentCategory.category}" autocomplete="off"></li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="instrumentcategory" method="post">
		<input type="hidden" name="delete"> 
		<input type="hidden" name="id" value="${instrumentCategory.id}"> 
		<input type="submit" value="Видалити">
	</form>
	<a href="instrumentcategory?list">Види вимірювання за кодом</a>
</body>
</html>