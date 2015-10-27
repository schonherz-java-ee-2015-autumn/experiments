/////////////////////////////////////////////////////////////////////////////
//

$(document).ready(function() {
	
	$("table").DataTable({
		"jQueryUI": true,
		"ajax" : {
			"url" : "GetUserTableServlet",
			"type" : "POST",
			"dataSrc":"",
		},
		"columns" : [{"data" : "name"}, {"data" : "email"}]
	});
	
	$(".menu").menu();
	
});