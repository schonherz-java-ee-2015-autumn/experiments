<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Felhasználók</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">

<style>
body {
	background-color: green;
}

thead th {
	text-align: center;
}

tfoot td {
	text-align: center;
}
tbody td {
	text-align: center;	
}
#userList {
	text-align: center;
}

Table {
	padding: 20px;
}


</style>

<script>
	$(function() {
		$("#userTable").DataTable();
		$("#toIndex").button();
	});
</script>

</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="org.web.User"%>
	<table border="2" id="userTable">
		<thead>
			<tr>
				<th colspan="4" id="userList">Felhasználók listája</th>
			</tr>
			<tr>
				<th>Felhasználónév
				</td>
				<th>E-mail
				</td>
				<th>Jelszó
				</td>
				</td>
				<th>Születési Dátum
				</td>
			</tr>
		</thead>
		<tbody>
			<%
			
				if (session.getAttribute("userList") != null) {
					ArrayList<User> itemsArray = (ArrayList<User>) session.getAttribute("userList");
					for (int i = 0; i < itemsArray.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.println(itemsArray.get(i).getName());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getEmail());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getPassword());
					%>
				</td>
				<td>
					<%
						out.println(itemsArray.get(i).getDate());
					%>
				</td>
			</tr>
			<%
				}
				} else {
					%>
					<tr>
						<td colspan="4" >
						<%
						out.println("Nincs regisztalt felhasznalo!");
						%>
						</td>
					</tr>
			<%		
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" ><a href="index.jsp" id="toIndex">Vissza a
						regisztációhoz</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>