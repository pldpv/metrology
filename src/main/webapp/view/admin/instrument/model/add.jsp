<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Новий тип ${instrumentType.instrumentType}</title>
</head>
<body>
	<h1>Новий тип ${instrumentType.instrumentType}</h1>
	<form action="instrumentmodel" method="post">
	<input type="hidden" name="add">
	<input type="hidden" name="typeId" value="${instrumentType.id}">
	<ul>
		<li>Тип ЗВТ: <input type="text" name="model" autocomplete="off"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="${type.url}">До ${type.name}</a>
</body>
</html>