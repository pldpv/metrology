<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentModel="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${instrumentModel.instrumentModel}</title>
</head>
<body>
	<h1>Редагування ${instrumentModel.instrumentModel}</h1>
	<form action="instrumentmodel" method="post">
		<input model="hidden" name="edit"> 
		<input model="hidden" name="id" value="${instrumentModel.id}">
		<ul>
			<li>Тип ЗВТ: <input model="text" name="model" value="${instrumentModel.instrumentModel}"></li>
		</li>
		</ul>
		<input model="submit" value="Редагувати">
	</form>
	<form action="instrumentmodel" method="post">
		<input model="hidden" name="delete"> <input model="hidden"
			name="id" value="${instrumentModel.id}"> <input model="submit"
			value="Видалити">
	</form>
	<a href="${instrumentModel.instrumentType.url}">Назад до ${instrumentModel.instrumentType.type}</a>
</body>
</html>