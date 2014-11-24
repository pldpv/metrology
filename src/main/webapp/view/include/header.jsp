<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="login_info">
    <sec:authorize access="isAuthenticated()">  
        <strong><sec:authentication property="principal.username"/>,<a href="/logout">Вийти</a></strong>
    </sec:authorize>
</div>
<div class ="nav">
	<jsp:include page="navigation.jsp" />
</div>
