<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>${company.name}</title>
</head>
<body>
	<div id="nav">
		<jsp:include page="../../include/nav.jsp" />
	</div>
	<div id="page-wrapper">
		<div class="col-lg-12">
			<h1 class="page-header">${company.name}</h1>
		</div>
		<form class="form-inline">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal" data-whatever="department?add&company_id=${company.id}">Новий відділ</button>
			<input id="myFilter" class="form-control" placeholder="Пошук...">
    	</form>
		<ul class="list-group">
			<c:forEach var="department" items="${company.departments}">
				<li class="list-group-item"> 
			    	<p class="btn btn-default btn-md" >${department.name}</p>
					<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-whatever="department?edit&id=${company.id}">Редагувати</button>
					<form  action="department" style="display: inline-block;margin:0;" method="post">
						<input type="hidden" name="delete"/> 
						<input type="hidden" name="id" value="${department.id}"/> 
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