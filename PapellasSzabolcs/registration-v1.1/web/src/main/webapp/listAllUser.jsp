<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered Users</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="css/list.css">
</head>
<script>
	$(document).ready(function() {
		$('#example').dataTable({
			"dom" : ' <"search"f><"top"l>rt<"bottom"ip><"clear">',
			"bJQueryUI" : true,
			"processing" : true,
			"ajax" : "ListAllUserServlet",
			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "userName"
			}, {
				"data" : "firstName"
			}, {
				"data" : "lastName"
			}, {
				"data" : "email"
			}, {
				"data" : "phone"
			}, {
				"data" : "location"
			}, {
				"data" : "gender"
			}, {
				"data" : "birthday"
			} ]
		});
	});
</script>
<body>
	<c:if test="${not empty user}">
		<c:out value="Welcome ${user.firstName} ${user.lastName}!" />
	</c:if>
	<button class="href" onclick="document.location.href='LogOutServlet';">Sign
		out</button>

	<table id="example" class="display">
		<thead>
			<tr>
				<th>User id</th>
				<th>User name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Location</th>
				<th>Gender</th>
				<th>Birth date</th>
			</tr>
		</thead>
	</table>

</body>
</html>