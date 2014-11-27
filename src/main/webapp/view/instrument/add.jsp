<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Нове ЗВТ</title>
<jsp:include page="../include/common_css.jsp" />
<script src="/resources/js/jquery.chained.remote.min.js"></script>
</head>
<body>
	<h1>Нове ЗВТ</h1>

	<form action="instrument" method="post">
		<input type="hidden" name="add"> <input type="hidden"
			name="department_id">
		<p>
			Служба: <select id="railwayServiceList" name="railwayService_id"
				onchange="">
			</select>
		</p>
		<p>
			Підприємство: <select id="companyList" name="company_id" onchange="">>
			</select>
		</p>
		<p>
			Відділ: <select id="departmentList" name="department_id">
			</select>
		</p>
		<p>Вид вимірювання:<select id="instrumentCategoryList" name="instrumentCategory_id">
			</select></p>
		<p>Назва ЗВТ<select id="instrumentTypeList" name="instrumentType_id">
			</select></p>
		<p>Тип ЗВТ<select id="instrumentModelList" name="instrumentModel_id">
			</select></p>
		<p>Заводський номер</p>
		<p>Рік випуску</p>
		<p>Дата отримання ЗВТ</p>
		<p>Де встановлено, використовується ЗВТ</p>
		<p>Сфера застосування</p>
		<p>Технічний стан ЗВТ</p>
		<p>ЗВТ, що калібруються</p>
		<p>ЗВТ, що повіряються</p>
		<p>Організація</p>
		<p>Дата</p>
		<p>Фактична вартісь</p>
		<p>Номер рахунку та дата його видачі</p>
		<p>Організація</p>
		<p>Дата</p>
		<p>Фактична вартісь</p>
		<p>Номер рахунку та дата його видачі</p>

		<input type="submit" value="add">
	</form>
	<a href="railwayservice?list">До списку служб</a>
</body>

<script>
	$(document).ready(function() {
		var railwayServiceList = document.getElementById("railwayServiceList");
		var companyList = document.getElementById("companyList");
		var departmentList = document.getElementById("departmentList");
		
		<c:forEach items="${railwayServices}" var="service" varStatus="loopStatus">
			var option = new Option("${service.name}", "${service}");
			railwayServiceList.options.add(option);
		</c:forEach>
		
		<c:forEach items="${companies}" var="company" varStatus="loopStatus">
			var option = new Option("${company.name}", "${company}");
			option.classList.add("${company.railwayService}")
			companyList.options.add(option);
			<c:forEach items="${company.departments}" var="department" varStatus="loopStatus">
				var option = new Option("${department.name}", "${department.id}");
				option.classList.add("${department.company}")
				departmentList.options.add(option);
			</c:forEach>
		
		</c:forEach>
		
		$("#companyList").chained("#railwayServiceList");
		$("#departmentList").chained("#companyList");
		
		<c:forEach items="${instrumentCategory}" var="category" varStatus="loopStatus">
		var option = new Option("${vategory.name}", "${category}");
		railwayServiceList.options.add(option);
		</c:forEach>
	
	});


</script>
</html>