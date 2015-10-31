/////////////////////////////////////////////////////////////////////////////
//

$(document).ready(function() {

	$("table").DataTable({
		"jQueryUI" : true,
		"serverSide" : true,
		"ajax" : {
			"url" : "GetUserTableServlet",
			"type" : "POST",
			"dataSrc" : "data",
			"dataType" : "json"
		},
		"columns" : [ {
			"data" : "name"
		}, {
			"data" : "email"
		}, {
			"data" : "dob"
		} ]
	});

	$(".menu").menu();

});