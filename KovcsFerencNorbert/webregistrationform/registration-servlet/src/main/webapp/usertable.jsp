<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includeStyle.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link id="theme" rel="stylesheet"
	href="https://code.jquery.com/ui/1.11.4/themes/trontastic/jquery-ui.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
	$(function() {

		// 		var info = table.page.info();

		$('table')
				.DataTable(
						{
							type : "POST",
							"language" : {
								"zeroRecords" : "There is no such user."
							},
							"bJQueryUI" : true,
							serverSide : true,
							"sAjaxDataProp" : "",
							ajax : "UserProviderServlet",
							'columns' : [ {
								"data" : "userName"
							}, {
								"data" : "name"
							}, {
								"data" : "email"
							}, {
								"data" : "phoneNumber"
							}, {
								"data" : "dateOfBirth"
							}, {
								"data" : "city"
							} ]
						});

	});
</script>
<title>Registred so far</title>
</head>
<body>
	<h1>Registered so far</h1>
	<table>
		<tfoot>
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone number</th>
				<th>Date of birth</th>
				<th>Location</th>
			</tr>
		</tfoot>
		<thead>
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone number</th>
				<th>Date of birth</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
</body>
</html>