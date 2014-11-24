<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="include/common_css.jsp" />
<title>Login</title>
</head>
<body style="background-color: #CBE2FF;">

	<div class="container">
		<form id="signin" class="form-signin" action="/login" method="post">
			
			<h2 class="form-signin-heading">АРМ Метрологія</h2>

			<p>
				<span class="glyphicon glyphicon-user"></span><input type="text"
					class="input-block-level" placeholder="Ім'я користувача"
					id="username" name="username">
			</p>
			<p>
				<span class="glyphicon glyphicon-lock"></span><input type="password"
					class="input-block-level" placeholder="Пароль" id="password"
					name="password">
			</p>
			<div class="auth-error">
				<c:if test="${param.error != null}">
					<p>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>
				</c:if>
			</div>
			<p>
				<button class="btn btn-large btn-primary" id="login_button"
					type="submit">Увійти</button>
			</p>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			if ("${param.error != null}") {
				$("#signin").effect("shake").direction();
			}
		});
	</script>
</body>
</html>