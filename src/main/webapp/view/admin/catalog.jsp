<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Збірник організаційно-методичних
				докуметів з метрології</title>
 <c:url var="bootstrapResponsiveUrl" value="/resources/css/bootstrap.css"/>
    <link href="${bootstrapResponsiveUrl}" rel="stylesheet"></link>
</head>
<body>
	<h1>Збірник організаційно-методичних докуметів з метрології</h1>
	<ul>
		<li><a href="instrumentcategory?list">Редагування видів вимюрювання</a></li>
		<li><a href="sphereofuse?list">Редагування сфер застосування</a></li>
		<li><a href="organization?list">Редагування підприємств перевірки інструментів</a></li>
	</ul>
</body>
</html>