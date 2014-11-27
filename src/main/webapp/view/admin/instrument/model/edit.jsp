<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Редагування ${instrumentType.instrumentType}</title>
</head>
<body>
	<h1>Редагування ${instrumentType.instrumentType}</h1>
	<form action="instrumenttype" method="post">
		<input type="hidden" name="edit"> 
		<input type="hidden" name="id" value="${instrumentType.id}">
		<ul>
			<li>Назва ЗВТ:: <input type="text" name="type" value="${instrumentType.instrumentType}"></li>
			
			<li>Сфера застосування:
			<select name="sphereofuse_id">
				<option value="0">(none)</option>
				<c:forEach var="sphereOfUse" items="${spheresOfUse}">
					<c:choose>
						<c:when test="${sphereOfUse == instrumentType.sphereOfUse}">
							<option value="${sphereOfUse.id}" selected>${sphereOfUse.sphereOfUse}</option>
						</c:when>
						<c:otherwise>
							<option value="${sphereOfUse.id}">${sphereOfUse.sphereOfUse}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</li>
		</ul>
		<input type="submit" value="Редагувати">
	</form>
	<form action="instrumenttype" method="post">
		<input type="hidden" name="delete"> <input type="hidden"
			name="id" value="${instrumentType.id}"> <input type="submit"
			value="Видалити">
	</form>
	<a href="${instrumentType.instrumentCategory.url}">Назад до ${instrumentType.instrumentCategory.category}</a>
</body>
</html>