<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>${instrumentCategory.category}</title>
</head>
<body>
	<h1>${instrumentCategory.category}</h1>
	<ul>
		<c:forEach var="instrumentType" items="${instrumentCategory.instrumentType}">
			<li><a href="${instrumentType.url}">${instrumentType.instrumentType}</a></li>
		</c:forEach>
	</ul>
	<a href="${instrumentCategory.url}&edit">Редагувати вид</a>|
	<a href="instrumenttype?add&category_id=${instrumentCategory.id}">Нове ЗВТ</a>|
	<a href="instrumentcategory?list">До видів вимірювання</a>
</body>
</html>