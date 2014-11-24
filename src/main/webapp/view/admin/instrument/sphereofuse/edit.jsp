<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${sphereOfUse.sphereOfUse}</title>
</head>
<body>
	<h1>Редагування ${sphereOfUse.sphereOfUse}</h1>
	<form action="sphereofuse" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${sphereofuse.id}">
		<ul>
			<li>Сфера застосування: <input type="text" name="sphere" value="${sphereOfUse.sphereOfUse}"></li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="sphereofuse" method="post">
		<input type="hidden" name="delete"> 
		<input type="hidden" name="id" value="${sphereOfUse.id}"> 
		<input type="submit" value="Видалити">
	</form>
	<a href="sphereofuse?list">Сфери застосування</a>
</body>
</html>