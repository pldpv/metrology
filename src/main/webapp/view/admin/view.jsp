<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Панель адміністратора</title>
 <c:url var="bootstrapResponsiveUrl" value="/resources/css/bootstrap.css"/>
    <link href="${bootstrapResponsiveUrl}" rel="stylesheet"></link>
</head>
<body>
	<h1>Панель адміністратора</h1>
	<ul>
		<li><a href="railwayservice?list"><span class="glyphicon glyphicon-home"></span> Редагування підприємств</a></li>
		<li><a href="catalog">Збірник організаційно-методичних
				докуметів з метрології</a></li>
		<li><a href="users">Редагування користувачів</a></li>
	</ul>
</body>
</html>