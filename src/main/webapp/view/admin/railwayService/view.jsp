<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>${railwayService.name}</title>
</head>
<body>
	<div id="nav">
		<jsp:include page="../../include/nav.jsp" />
	</div>
	<div id="page-wrapper">
		<div class="col-lg-12">
			<h1 class="page-header">${railwayService.name}</h1>
		</div>
		<form class="form-inline">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal" data-whatever="company?add&railwayService_id=${railwayService.id}">Нове підприємство</button>
			<input id="myFilter" class="form-control" placeholder="Пошук...">
    	</form>
		<ul class="list-group" class="list-inline">
			<c:forEach var="company" items="${railwayService.companies}">
			    <li class="list-group-item"> 
			    	<a href="${company.url}" class="btn btn-default btn-md" >${company.name}</a>
					<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-whatever="company?edit&id=${company.id}">Редагувати</button>
					<form  action="company" method="post">
						<input type="hidden" name="delete"/> 
						<input type="hidden" name="id" value="${company.id}"/> 
						<input type="submit" onclick="return confirm('Ви впевнені, що бажаєте видалити запис?')" class ="btn btn-danger" value="Видалити"/>
					</form>
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