<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>${department.name}</title>
</head>
<body>
	<h1>${department.company.name} - ${department.name}</h1>
	<ul>
			<li>${department.name}</a></li>
			<li>${department.director}</a></li>
	</ul>
	<a href="${department.url}&edit">Редагувати відділ</a> | 
	<a href="${department.company.url}">Назад до ${department.company.name}</a>
</body>
</html>