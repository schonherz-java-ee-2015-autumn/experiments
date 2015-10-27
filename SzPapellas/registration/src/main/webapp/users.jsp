<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<!-- <link rel="stylesheet" href="jquery-ui.css"> -->
<!-- <script src="jquery.js"></script> -->
<!-- <script src="jquery-ui.js"></script> -->
<!-- <script src="jquery.dataTables.min.js"></script> -->
<!-- <link rel="stylesheet" href="jquery.dataTables.min.css"/> -->
<script>
	$(function() {
		$("#userTable").DataTable();
		$("#toIndex").button();
	});
</script>
<style>
body {
	background: rgb(226, 226, 226);
	font-family: cursive;
}

table {
	/* 	border: 1px solid black; */
	/* 	border-radius: 15px; */
	padding: 15px;
	margin: auto;
}

thead th {
	text-align: left;
}

tfoot td {
	margin: auto;
	text-align: center;
}

h2 {
	text-align: center;
}

.warning {
	color: red;
	font-weight: bold;
}

#userList {
	text-align: center;
}
</style>
</head>
<body>
	<%@page import="java.util.ArrayList"%>

	<jsp:useBean id="data" class="hu.neuron.data.RegisteredUsers" />
	<table id="userTable">
		<thead>
			<tr>
				<th colspan="5" id="userList">Users</th>
			</tr>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Location</th>
				<th>Gender</th>
				<th>Birthday</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (request.getAttribute("userList") != null) {
					ArrayList<hu.neuron.data.User> itemsArray = (ArrayList<hu.neuron.data.User>) request
							.getAttribute("userList");
					for (int i = 0; i < itemsArray.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.println(itemsArray.get(i).getFirstName() + " " + itemsArray.get(i).getLastName());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getEmail());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getPhone());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getLocation());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getGender());
					%>
				</td>

				<td>
					<%
						out.println(itemsArray.get(i).getBirthday());
					%>
				</td>
			</tr>
			<%
				}
				} else {
					out.println("Bocsika nincs regisztalt felhasznalo!");
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<!-- <input type="button" value="Vissza a regiszt�ci�hoz!"/> --> <a
					href="index.jsp" id="toIndex">Registration form</a>
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>