<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav nav-pills">
<sec:authentication var="principal" property="principal" />
	<li class="active"><a href="/">Головна</a></li>
	<li><a href="#">Перегляд інструментів</a></li>
	<li><a href="#">Редагування інструментів</a></li>
	<sec:authorize access="hasRole('COMPANY_ADMIN')">
	<li><a href="company?view&id=${principal.company.id}">Редагування підприємства</a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
		<li><a href="/admin">Панель адміністратора</a></li>
	</sec:authorize>
</ul>