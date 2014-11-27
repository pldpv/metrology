<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Новий тип ЗВТ</title>
</head>
<body>
	<h1>Новий тип ЗВТ</h1>
	<form action="instrumentmodel" method="post">
	<input model="hidden" name="add">
	<input model="hidden" name="typeId" value="${instrumentType.id}">
	<ul>
		<li>Тип ЗВТ: <input model="text" name="model" autocomplete="off"></li>
	</ul>
	<input model="submit" value="add">
	</form>
	<a href="${type.url}">До ${type.name}</a>
</body>
</html>