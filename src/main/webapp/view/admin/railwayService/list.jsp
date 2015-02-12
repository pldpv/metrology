<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Служби Залізниці</title>
</head>
<body>
	<div id="nav">
		<jsp:include page="../../include/nav.jsp" />
	</div>
	<div id="page-wrapper">
		<div class="col-lg-12">
			<h1 class="page-header">Служби Залізниці</h1>
		</div>
		<form class="form-inline">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal" data-whatever="railwayservice?add">Нова служба</button>
			<input id="myFilter" class="form-control" placeholder="Пошук...">
    	</form>
		<ul class="list-group">
			<c:forEach var="railwayService" items="${railwayServices}">
			    <li class="list-group-item">
					<a href="${railwayService.url}" class="btn btn-default btn-md" >${railwayService.name}</a>
					<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-whatever="railwayservice?edit&id=${railwayService.id}">Редагувати</button>
					<a class="btn btn-danger" onclick="return confirm('Ви впевнені, що бажаєте видалити запис?')" role="button" href="railwayservice?delete&id=${railwayService.id}">Видалити</a>
				</li>
			</c:forEach>	
		</ul>		
	</div>
	<div id="modal">
			<jsp:include page="../../include/modal.jsp" />
    </div>
<script>
$(function() {
    $('#myFilter').fastLiveFilter('.list-group');
});
</script>
<script src="/resources/js/fastLiveFilter.js"></script>
</body>
</html>