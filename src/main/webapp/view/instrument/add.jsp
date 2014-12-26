<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Нове ЗВТ</title>
<jsp:include page="../include/common_css.jsp" />
<script src="/resources/js/jquery.chained.remote.min.js"></script>
<script src="/resources/js/jquery.ui.datepicker-ua.js"></script>

</head>

<body>
	<h1>Нове ЗВТ</h1>

	<form action="instrument" method="post">
		<input type="hidden" name="add"> <input type="hidden"
			name="department_id">
		<p>
			Служба: <select id="railwayServiceList" ></select>
		</p>
		<p>
			Підприємство: <select id="companyList" ></select>
		</p>
		<p>
			Відділ: <select id="departmentList" name="department_id" required></select>
		</p>
		<p>
			Вид вимірювання: <select id="instrumentCategoryList"
				name="instrumentCategory_id" required></select>
		</p>
		<p>
			Назва ЗВТ: <select id="instrumentTypeList" name="instrumentType_id" required></select>
		</p>
		<p>
			Тип ЗВТ: <select id="instrumentModelList" name="instrumentModel_id" required>
			</select>
		</p>
		<p>
			Заводський номер: <input type="number" name="serialNumber"
				autocomplete="off" required>
		</p>
		<p>
			Рік випуску: <select name="produtionYear" id="produtionYear" required></select>
		</p>
		<p>
			Дата отримання ЗВТ: <input type="text" id="receiptDate" required>
		</p>
		<p>
			Де встановлено, використовується ЗВТ: <input type="text"
				name="location" autocomplete="off" required>
		</p>
		<p>
			Сфера застосування: <select id="sphereOfUseList"
				name="sphereOfUse_id" required>
			</select>
		</p>
		<p>Технічний стан ЗВТ:<select id="technicalStateList"
				name="technicalState_id" required>
			</select></p>
		<p>
			ЗВТ, що калібруються <input type="checkbox" id="calibrationCb">
		</p>
		<div id="calibration">
			<p>Організація:<select id="calibrationOrganizationList"
				name="calibrationOrganization_id" required>
			</select></p>
			<p>
				Дата: <input type="text" id="calibrationDate" name="calibrationDate" >
			</p>
			<p>
				Фактична вартісь<input type="number" name="actualCostCalibration"
					autocomplete="off">
			</p>
			<p>Номер рахунку та дата його видачі <input type="text" name="actualCostCalibration"
					autocomplete="off"></p>
		</div>
		
		<p>
			ЗВТ, що повіряються<input type="checkbox" id="verificationCb">
		</p>
		<div id="verification">
		<p>Організація<select id="verificationOrganizationList"
				name="verificationOrganization_id" required>
			</select></p>
		<p>
			Дата<input type="text" id="verificationDate" name="verificationDate">
		</p>
		<p>Фактична вартісь<input type="number" name="actualCostVerification"
					autocomplete="off"></p>
		<p>Номер рахунку та дата його видачі<input type="text" name="actualCostVerification"
					autocomplete="off"></p>
		</div>
		<input type="submit" value="add">
	</form>
	<a href="railwayservice?list">До списку служб</a>
</body>

<script>
	$(document)
			.ready(
					function() {
						var railwayServiceList = document
								.getElementById("railwayServiceList");
						var companyList = document
								.getElementById("companyList");
						var departmentList = document
								.getElementById("departmentList");
						var sphereOfUseList = document
								.getElementById("sphereOfUseList");

						<c:forEach items="${railwayServices}" var="service" varStatus="loopStatus">
						var option = new Option("${service.name}", "${service}");
						railwayServiceList.options.add(option);
						</c:forEach>

						<c:forEach items="${companies}" var="company" varStatus="loopStatus">
						var option = new Option("${company.name}", "${company}");
						option.classList.add("${company.railwayService}")
						companyList.options.add(option);
						<c:forEach items="${company.departments}" var="department" varStatus="loopStatus">
						var option = new Option("${department.name}",
								"${department.id}");
						option.classList.add("${department.company}")
						departmentList.options.add(option);
						</c:forEach>

						</c:forEach>

						<c:forEach items="${instrumentCategories}" var="category" varStatus="loopStatus">
						var option = new Option("${category.category}",
								"${category}");
						instrumentCategoryList.options.add(option);

						<c:forEach items="${category.instrumentType}" var="type" varStatus="loopStatus">
						var option = new Option("${type.instrumentType}",
								"${type}");
						option.classList.add("${type.instrumentCategory}")
						instrumentTypeList.options.add(option);

						<c:forEach items="${type.instrumentModel}" var="model" varStatus="loopStatus">
						var option = new Option("${model.instrumentModel}",
								"${model.id}");
						option.classList.add("${model.instrumentType}")
						instrumentModelList.options.add(option);
						</c:forEach>

						</c:forEach>
						</c:forEach>

						<c:forEach items="${spheresOfUse}" var="sphereOfUse" varStatus="loopStatus">
						var o = new Option("${sphereOfUse.sphereOfUse}",
								"${sphereOfUse.id}");
						sphereOfUseList.options.add(o);
						<c:forEach items="${sphereOfUse.instrumenType}" var="instrumenType" varStatus="loopStatus">
						o.classList.add("${instrumenType}")
						</c:forEach>

						</c:forEach>

						$("#companyList").chained("#railwayServiceList");
						$("#departmentList").chained("#companyList");
						$("#instrumentTypeList").chained(
								"#instrumentCategoryList");
						$("#instrumentModelList")
								.chained("#instrumentTypeList");
						$("#sphereOfUseList").chained("#instrumentTypeList");

						for (i = new Date().getFullYear(); i > 1970; i--) {
							$('#produtionYear').append(
									$('<option />').val(i).html(i));
						}
						$('#receiptDate').datepicker({maxDate:new Date()});
						$('#calibrationDate').datepicker({maxDate:new Date()});
						$('#verificationDate').datepicker({maxDate:new Date()});
						checkInstrument("calibrationCb","calibration");
						checkInstrument("verificationCb","verification")
					});
	function checkInstrument(checkBoxId,divClass){
			$('#'+divClass).hide();
			$('#'+checkBoxId).change(function () {
		        if (!this.checked)
		           $('#'+divClass).fadeOut('slow');
		        else 
		            $('#'+divClass).fadeIn('slow');
		    });

	}
	
</script>
</html>