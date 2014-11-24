<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Види вимірювань за кодом</title>
<jsp:include page="../../../include/common_css.jsp" />
</head>
<body>
	<h1>Види вимірювань за кодом</h1>
	<ul>
		<c:forEach var="instrumentCategory" items="${instrumentCategories}">
			<li>
			<a href="${instrumentCategory.url}">${instrumentCategory.category}</a> 
			<a href="#" data-url="instrumentcategory?edit&id=${instrumentCategory.id}" class="edit-action">Редагувати</a> 
			<form action="instrumentcategory" method="post">
				<input type="hidden" name="delete"> 
				<input type="hidden" name="id" value="${instrumentCategory.id}"> 
				<input type="submit" value="Видалити">
			</form>
			</li>
		</c:forEach>
	</ul>
	<a href="instrumentcategory?add">Новий вид вимірювання за кодом</a> |
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