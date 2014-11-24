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
		<li>Сфера засмтосування:${instrumentType.sphereOfUse.sphereOfUse}</li>
	</ul>
	<a href="${instrumentType.url}&edit">Редагувати ЗВТ</a>|
	<a href="instrumentcategory?list">До видів вимірювання</a>
</body>
</html>