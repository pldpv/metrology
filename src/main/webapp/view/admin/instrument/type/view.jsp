
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>${instrumentType.instrumentType}</title>
</head>
<body>
	<h1>${instrumentType.instrumentType}</h1>
	<ul>
		<c:forEach var="instrumentModel" items="${instrumentType.instrumentModel}">
			<li><a href="${instrumentModel.url}">${instrumentModel.instrumentModel}</a></li>
		</c:forEach>
	</ul>
	<a href="${instrumentType.url}&edit">Редагувати ЗВТ</a>|
	<a href="instrumentmodel?add&type_id=${instrumentType.id}">Новий вид</a>
	<a href="instrumentcategory?list">До видів вимірювання</a>
	
</body>
</html>