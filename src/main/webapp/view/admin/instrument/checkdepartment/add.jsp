<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<jsp:include page="../../../include/common_css.jsp" />
<script src="/resources/js/jquery.multiple.select.js"></script>
<link href="/resources/css/multiple-select.css" rel="stylesheet"></link>
<title>Новий відділ з перевірки приладів</title>
</head>
<body>
	<h1>Новий відділ</h1>
	<form action="checkdepartment" method="post">
		<input type="hidden" name="add"> <input type="hidden"
			name="company_id" value="${company.id}">
		<ul>
			<li>Назва: <input type="text" name="name" autocomplete="off"></li>
			<li>Начальник : <input type="text" name="director"
				autocomplete="off"></li>
			<li>Сертифікат : <input type="text" name="picturePath"
				autocomplete="off"></li>
			<li>
			<select id="typeselect"  name="typeselect" multiple="multiple">
			
			</select>
			</li>
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="checkdepartment?list">До списку відділів перевірки</a>

</body>
<script>


$(document)
.ready(
		function() {
			var typeselect=document.getElementById("typeselect");
			<c:forEach items="${instrumentType}" var="instrumenttype" varStatus="loopStatus">
				var option =new Option("${instrumenttype.instrumentType}", "${instrumenttype}");
				typeselect.options.add(option);
			</c:forEach>
			$('#typeselect').multipleSelect({
			    filter: true
			});
		});

</script>
</html>
