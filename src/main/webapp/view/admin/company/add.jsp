<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Нове підриєство</title>
</head>
<body>
	<form class="form-horizontal" action="company" method="post">
		<input type="hidden" name="add"> 
		<input type="hidden" name="railwayService_id" value="${railwayService.id}">
		<div class="form-group form-group-sm">
			<label class="control-label col-sm-4" for="inputName">Назва</label> 
			<div class="col-sm-8">
				<input class="form-control" type="text" id="inputName" name="name" autocomplete="off">
			</div>
		</div> 
		<div class="form-group form-group-sm">
			<label class="control-label col-sm-4" for="inputDirector">Начальник	підприємства</label> 
			<div class="col-sm-8">
				<input class="form-control" type="text" id ="inputDirector" name="director" autocomplete="off">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<div class="col-md-9 col-md-offset-9">
				<button type="submit" class="btn btn-success">Зберегти</button>
			</div>
		</div>
	</form>
</body>
</html>