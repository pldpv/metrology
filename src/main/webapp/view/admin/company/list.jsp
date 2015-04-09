<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Підриємства залізниці</title>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<div id="nav">
		
	</div>
	<div id="page-wrapper">
	<p>
			Служба: <select id="railwayServiceList"></select>
	</p>
<select data-bind="options: $root.availableMeals, value: meal, optionsText: 'mealName'"></select>
<ul data-bind="foreach: formattedPrice">
    <li>The current item is: <b data-bind="text: $data"></b>

    </li>
</ul>
<script src="http://knockoutjs.com/downloads/knockout-3.2.0.debug.js" type="text/javascript"></script>
<script type="text/javascript">
function ReservationsViewModel() {
    var self = this;
    // Non-editable catalog data - would come from the server
    self.availableMeals =[{
        mealName: "Standard (sandwich)",
        price: ['A', 'b']
    }, {
        mealName: "Premium (lobster)",
        price: ['A']
    }, {
        mealName: "Ultimate (whole zebra)",
        price: ['A']
    }];
   self.meal=ko.observable();
   self.formattedPrice=ko.pureComputed(function(){
	   	var p=self.meal().price;
        return p;
    });

}
ko.applyBindings(new ReservationsViewModel());
</script>

</body>

</html>