<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentModel="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>${instrumentModel.instrumentModel}</title>
</head>
<body>
	<h1>${instrumentModel.instrumentModel}</h1>
	
	<a href="${instrumentModel.url}&edit">Редагувати ЗВТ</a>|
	<a href="instrumenttype?list">До видів вимірювання</a>
</body>
</html>