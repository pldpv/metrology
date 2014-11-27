<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>ЗВТ</title>
<jsp:include page="../../../include/common_css.jsp" />
</head>
<body>
	<h1>ЗВТ</h1>
	<ul>
		<c:forEach var="instrumentType" items="${instrumentTypes}">
			<li>
			<a href="${instrumentType.url}">${instrumentType.type}</a> 
			<a href="#" data-url="instrumenttype?edit&id=${instrumentType.id}" class="edit-action">Редагувати</a> 
			<form action="instrumenttype" method="post">
				<input type="hidden" name="delete"> 
				<input type="hidden" name="id" value="${instrumentType.id}"> 
				<input type="submit" value="Видалити">
			</form>
			</li>
		</c:forEach>
	</ul>
	<a href="instrumenttype?add">Новий вид вимірювання за кодом</a> |
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