<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Нове ЗВТ</title>
<jsp:include page="../include/common_css.jsp" />
</head>
<body>
	<h1>Нове ЗВТ</h1>

	<form action="instrument" method="post">
		<input type="hidden" name="add"> <input type="hidden"
			name="department_id">
		<p>
			Служба: <select id="railwayServiceList" name="railwayService_id"
				onchange="changeCompaniesCombo()">
			</select>
		</p>
		<p>
			Підприємство: <select id="companyList" name="company_id" onchange="changeCompaniesCombo()">>
			</select>
		</p>
		<p>
			Відділ: <select id="departmentList" name="department_id">
			</select>
		</p>
		<p>Вид вимірювання</p>
		<p>Назва ЗВТ</p>
		<p>Тип ЗВТ</p>
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
		<c:forEach items="${railwayServices}" var="service" varStatus="loopStatus">
		var option = new Option("${service.name}", "${service}");
		railwayServiceList.options.add(option);
		</c:forEach>
		changeCompaniesCombo();
	});

	function changeCompaniesCombo() {

		var railwayServiceList = document.getElementById("railwayServiceList");
		var companyList = document.getElementById("companyList");
		var selected = railwayServiceList.value;
		while (companyList.options.length) {
			companyList.remove(0);
		}
		<c:forEach items="${companies}" var="company" varStatus="loopStatus">
			if ("${company.railwayService}" == selected) {
				var option = new Option("${company.name}", "${company}");
				companyList.options.add(option);
			}
		</c:forEach>
	}

	function changeDepartmentCombo() {
		var departmentList = document.getElementById("departmentList");
		var companyList = document.getElementById("companyList");
		var selected = companyList.value;

		while (departmentList.options.length) {
			departmentList.remove(0);
		}
		<c:forEach items="${selected.departments}" var="department" varStatus="loopStatus">
			var option = new Option("${department.name}", "${department.id}");
			companyList.options.add(option);
		</c:forEach>
	}
</script>
</html>