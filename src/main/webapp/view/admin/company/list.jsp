<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Служби Залізниці</title>
<script src="http://knockoutjs.com/downloads/knockout-3.0.0.debug.js" type="text/javascript"></script>
</head>
<body>
	<div id="nav">
		<jsp:include page="../../include/nav.jsp" />
	</div>
	<div id="page-wrapper">
		<p>
			Служба: <select id="railwayServiceList" onchange="listChange()" data-bind="options: $root.availableRailwayServices, value: railwayService, optionsText: 'railwayServiceName'"></select>
		</p>
		<ul id ="companyList" class="list-group" class="list-inline">
	
		</ul>		
	</div>

    <table>
    <thead><tr>
        <th>Passenger name</th><th>Meal</th><th>Surcharge</th><th></th>
    </tr></thead>
    <tbody data-bind="foreach: seats">
        <tr>
            <td><input data-bind="value: name" /></td>
            <td><select data-bind="options: $root.availableMeals, value: meal, optionsText: 'mealName'"></select></td>
            <td data-bind="text: formattedPrice"></td>
        </tr>    
    </tbody>
</table>


<script>
//Class to represent a row in the seat reservations grid
function SeatReservation(name, initialMeal) {
    var self = this;
    self.name = name;
    self.meal = ko.observable(initialMeal);

    self.formattedPrice = ko.computed(function() {
        var price = self.meal().price;
        return price ? "$" + price.toFixed(2) : "None";        
    });    
}

// Overall viewmodel for this screen, along with initial state
function ReservationsViewModel() {
    var self = this;

    // Non-editable catalog data - would come from the server
    self.availableMeals = [
        { mealName: "Standard (sandwich)", price: 0 },
        { mealName: "Premium (lobster)", price: 34.95 },
        { mealName: "Ultimate (whole zebra)", price: 290 }
    ];    

    // Editable data
    self.seats = ko.observableArray([
        new SeatReservation("Steve", self.availableMeals[0]),
        new SeatReservation("Bert", self.availableMeals[0])
    ]);

    // Operations
    self.addSeat = function() {
        self.seats.push(new SeatReservation("", self.availableMeals[0]));
    }
}
var ReservationViewModel={
		
}
ko.applyBindings(new ReservationsViewModel());
</script>
<script src="/resources/js/fastLiveFilter.js"></script>
</body>
</html>