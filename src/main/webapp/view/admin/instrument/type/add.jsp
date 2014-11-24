<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Нове ЗВТ</title>
</head>
<body>
	<h1>Нове ЗВТ</h1>
	<form action="instrumenttype" method="post">
	<input type="hidden" name="add">
	<input type="hidden" name="categoryId" value="${instrumentCategory.id}">
	<ul>
		<li>Назва ЗВТ: <input type="text" name="type" autocomplete="off"></li>
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
	<input type="submit" value="add">
	</form>
	<a href="${category.url}">До ${category.name}</a>
</body>
</html>