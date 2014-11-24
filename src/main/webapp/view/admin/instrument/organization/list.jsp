<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Огранізації з перевірки</title>
<jsp:include page="../../../include/common_css.jsp" />
</head>
<body>
	<h1>Огранізації з перевірки</h1>
	<ul>
		<c:forEach var="organization" items="${organizations}">

			<li>${organization.name}
			<a href="organization?edit&id=${organization.id}">Редагувати</a>
				<form action="organization" method="post">
					<input type="hidden" name="delete"> <input type="hidden"
						name="id" value="${organization.id}"> <input type="submit"
						value="Видалити">
				</form></li>
		</c:forEach>
	</ul>
	<a href="organization?add">Створити організацію з перевірки</a> |
	<a href="/">На головну</a>
	
</body>

</html>