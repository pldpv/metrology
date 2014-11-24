<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>іНСТРУМЕНТИ</title>
<jsp:include page="../include/common_css.jsp" />

</head>
<body>
	<h1>іНСТРУМЕНТИ</h1>
	<table id="instrumentTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<td><c:out value="Служба" /></td>
				<td><c:out value="Підприємство" /></td>
				<td><c:out value="Відділ" /></td>
				<td><c:out value="Місцезнаходження" /></td>
				<td><c:out value="Інвентарний номер" /></td>
				<td><c:out value="Вид вимірювання за кодом" /></td>	
				<td><c:out value="Назва ЗВТ" /></td>
				<td><c:out value="Вид ЗВТ" /></td>
				<td><c:out value="Сфера застосування" /></td>
				<td><c:out value="Технічний стан" /></td>
				<td><c:out value="Дата отримання" /></td>
				<td><c:out value="Дата виробництва" /></td>
				<td><c:out value="Поточне калібрування" /></td>
				<td><c:out value="Періодичність калібрування" /></td>
				<td><c:out value="Наступне калібрування" /></td>
				<td><c:out value="Вартість калібрування" /></td>
				<td><c:out value="Організація, що калібрувала" /></td>
				<td><c:out value="Поточна повірка" /></td>
				<td><c:out value="Періодичність повірки" /></td>
				<td><c:out value="Наступна повірка" /></td>
				<td><c:out value="Вартість повірки" /></td>
				<td><c:out value="Організація, що повіряла" /></td>
			</tr>
		</thead>
		<c:forEach items="${instruments}" var="instrument">
			<tr>
				<td><c:out value="${instrument.department.company.railwayService.name}" /></td>
				<td><c:out value="${instrument.department.company.name}" /></td>
				<td><c:out value="${instrument.department.name}" /></td>
				<td><c:out value="${instrument.location}" /></td>
				<td><c:out value="${instrument.serialNumber}" /></td>
				<td><c:out value="${instrument.instrumentType.instrumentCategory.category}" /></td>
				<td><c:out value="${instrument.instrumentType.instrumentType}" /></td>
				<td><c:out value="${instrument.instrumentModel}" /></td>
				<td><c:out value="${instrument.instrumentType.sphereOfUse.sphereOfUse}" /></td>
				<td><c:out value="${instrument.instrumentType.technicalState.technicalState}" /></td>
				<td><c:out value="${instrument.receiptDate}" /></td>
				<td><c:out value="${instrument.productionYear}" /></td>
				<td><c:out value="${instrument.calibration.currentCheck}" /></td>
				<td><c:out value="${instrument.calibration.periodicity}" /></td>
				<td><c:out value="${instrument.calibration.nextCheck}" /></td>
				<td><c:out value="${instrument.calibration.actualCost}" /></td>
				<td><c:out value="${instrument.calibration.organization.name}" /></td>
				<td><c:out value="${instrument.verification.currentCheck}" /></td>
				<td><c:out value="${instrument.verification.periodicity}" /></td>
				<td><c:out value="${instrument.verification.nextCheck}" /></td>
				<td><c:out value="${instrument.verification.actualCost}" /></td>
				<td><c:out value="${instrument.verification.organization.name}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/">На головну</a>
</body>
<script>
	$(document).ready(function() {
		$("#instrumentTable").dataTable();
	});
</script>
</html>