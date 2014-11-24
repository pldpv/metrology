<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Нова сфера застосування</title>
</head>
<body>
	<h1>Нова сфера застосування</h1>
	<form action="sphereofuse" method="post">
	<input type="hidden" name="add">
	<ul>
		<li>Сфера застосування: <input type="text" name="sphere" autocomplete="off"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="sphereofuse?list">Список сфер застосування</a>
</body>
</html>