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
		<table id="instrumentTable" class="display" cellspacing="0"
			width="100%">
			<thead>
				<tr>
					<th rowspan="2">Служба</th>
					<th rowspan="2">Підприємство</th>
					<th rowspan="2">Відділ</th>
					<th rowspan="2">Вид вимірювання</th>
					<th rowspan="2">Назва ЗВТ</th>
					<th rowspan="2">Тип ЗВТ</th>
					<th rowspan="2">Заводський номер</th>
					<th rowspan="2">Рік випуску</th>
					<th rowspan="2">Дата отримання ЗВТ</th>
					<th rowspan="2">Де встановлено, використовується ЗВТ</th>
					<th rowspan="2">Сфера застосування</th>
					<th rowspan="2">Технічний стан ЗВТ</th>
					<th colspan="2">ЗВТ, що калібруються</th>
					<th colspan="2">ЗВТ, що повіряються</th>
				</tr>
				<tr>
					<th>Організація</th>
					<th>Дата</th>
					<th>Фактична вартісь</th>
					<th>Номер рахунку та дата його видачі</th>
					<th>Організація</th>
					<th>Дата</th>
					<th>Фактична вартісь</th>
					<th>Номер рахунку та дата його видачі</th>
				</tr>
			</thead>
			<td><select id="railwayServiceList" name="railwayService_id" onchange="changeCompanies()">
					<option value="0">Служба</option>
			</select></td>
			<td><select id="companyList" name="company_id">
					<option value="0">Підприємство</option>
			</select></td>
		</table>

		<input type="submit" value="add">
	</form>
	<a href="railwayservice?list">До списку служб</a>
</body>
<script>
$(document).ready ( function(){
	var railwayServiceList = document.getElementById("railwayServiceList");
	
	var services = {};

	<c:forEach items="${railwayServices}" var="service" varStatus="loopStatus">
		var option = new Option("${service.name}", "${service.id}");
		railwayServiceList.options.add(option);
	</c:forEach>
	
	
});
function changeCompanies(){
	
	var railwayServiceList = document.getElementById("railwayServiceList");
	var companyList = document.getElementById("companyList");
	
	while(companyList.options.length>1){
		companyList.remove(1);		
	}
	var selected=railwayServiceList.value;
	<c:forEach items="${companies}" var="company" varStatus="loopStatus">
	if ("${company.railwayService.id}"==selected){
		var option = new Option("${company.name}", "${company.id}");
		companyList.options.add(option);	
	}
	
</c:forEach>
}
</script>
</html>