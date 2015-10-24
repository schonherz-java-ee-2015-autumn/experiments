<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="header.jsp"></jsp:include>
<script src="resources/datatable/js/jquery.dataTables.js"></script>
<link href="resources/datatable/css/jquery.dataTables_themeroller.css"
	rel="stylesheet">
</head>
<body>
	<div id="main">
		<table id="example" class="display">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-mail</th>
					<th>Date of birth</th>

				</tr>
			</thead>
		</table>
		<script>
			$(document).ready(function() {
				$('#example').dataTable({
					"bJQueryUI" : true,
					"ajax" : "UserListServlet",

					"columns" : [ {
						"data" : "firstName"
					}, {
						"data" : "lastName"
					}, {
						"data" : "email"
					}, {
						"data" : "dateOfBirth"
					}

					]
				});
			});
		</script>

	
	</div>


</body>
</html>
