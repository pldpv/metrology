<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Служби Залізниці</title>
<jsp:include page="../../include/common_css.jsp" />
</head>
<body>
	<h1>Служби Залізниці</h1>
	<ul>
		<c:forEach var="railwayService" items="${railwayServices}">
			<li>
			<a href="${railwayService.url}">${railwayService.name}</a> 
			<a href="#" data-url="railwayservice?edit&id=${railwayService.id}" class="edit-action">Редагувати</a> 
			<form action="railwayservice" method="post">
				<input type="hidden" name="delete"> 
				<input type="hidden" name="id" value="${railwayService.id}"> 
				<input type="submit" value="Видалити">
			</form>
			</li>
		</c:forEach>
	</ul>
	<a href="railwayservice?add">Створити службу</a> |
	<a href="/">На головну</a>
	<div id='somediv'></div>
</body>
<script>
 $(".edit-action").click(
			function(event) {
				event.preventDefault();
				$("#somediv").load($(this).data("url")).dialog({modal:true}); 
			});
</script>
</html>