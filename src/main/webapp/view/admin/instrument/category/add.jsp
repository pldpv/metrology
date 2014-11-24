<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Новий вид вимірювання</title>
</head>
<body>
	<h1>Новий вид вимірювання</h1>
	<form action="instrumentcategory" method="post">
	<input type="hidden" name="add">
	<ul>
		<li>Код виду: <input type="text" name="id" autocomplete="off"></li>
		<li>Вид вимірювання: <input type="text" name="category" autocomplete="off"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="instrumentcategory?list">Види вимірювання</a>
</body>
</html>