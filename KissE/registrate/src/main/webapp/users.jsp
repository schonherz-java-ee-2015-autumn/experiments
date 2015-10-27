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
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel = "stylesheet" href = "style.css">

<script>
	$(function() {
		$("#uTable").DataTable();
	});
</script>

</head>

<body>
	<%@page import="java.util.ArrayList"%>
	<table id="uTable">
		<thead id = "uTableHead">
			<tr>
				<td colspan=7 id="regUsers">Registered Users</td>
			</tr>
			<tr>

				<th>Username</th>
				<th>Title</th>
				<th>Full Name</th>
				<th>Date Of Birth</th>
				<th>Place Of Birth</th>
				<th>E-mail</th>
				<th>Phone Number</th>

			</tr>

		</thead>

		<tbody>
			<%
				if (session.getAttribute("regUsers") != null) {
					ArrayList<hu.schonherz.training.registrate.RegData> usersArray = (ArrayList<hu.schonherz.training.registrate.RegData>) session
							.getAttribute("regUsers");
					for (int i = 0; i < usersArray.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.println(usersArray.get(i).getUserName());
					%>
				</td>
				<td>
					<%
						out.println(usersArray.get(i).getTitle());
					%>
				</td>
				<td>
					<%
						out.println(usersArray.get(i).getFullName());
					%>
				</td>
				<td>
					<%
						out.println(usersArray.get(i).getDateOfBirth());
					%>
				</td>
				<td>
					<%
						out.println(usersArray.get(i).getPlaceOfBirth());
					%>
				</td>
				<td>
					<%
						out.println(usersArray.get(i).getEmail());
					%>
				</td>
				<td>
					<%
						out.println(usersArray.get(i).getPhoneNumber());
					%>
				</td>

			</tr>
			<%
			}
		} else {
			out.println("No registered users");
		}
	%>



		</tbody>
		
		<tfoot>
		<tr>
		<td colspan = 7> <button type = button class = "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><a href = "index.jsp">Back To The registration</a></button></td>
		</tr>
		</tfoot>
	</table>



</body>
</html>