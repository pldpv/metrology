<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Сфери застосування</title>
<jsp:include page="../../../include/common_css.jsp" />
</head>
<body>
	<h1>Сфери застосування</h1>
	<ul>
		<c:forEach var="sphereOfUse" items="${spheresOfUse}">

			<li>${sphereOfUse.sphereOfUse}
			<a href="#"	data-url="sphereofuse?edit&id=${sphereOfUse.id}" class="modal-window">Редагувати</a>
				<form action="sphereofuse" style="float: left;" method="post">
					<input type="hidden" name="delete"> <input type="hidden"
						name="id" value="${sphereOfUse.id}"> <input type="submit"
						value="Видалити">
				</form></li>
		</c:forEach>
	</ul>
	<a href="sphereofuse?add" data-url="sphereofuse?add"
		class="modal-window">Створити сферу</a> |
	<a href="/">На головну</a>
	<div id='somediv'></div>
</body>
<script>
	$(".modal-window").click(function(event) {
		event.preventDefault();
		$("#somediv").load($(this).data("url")).dialog({
			modal : true
		});
	});
</script>
</html>