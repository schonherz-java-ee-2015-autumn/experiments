<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
Table {
	padding: 20px;
	text-align: center;
}
</style>

<script>
	$(function() {
		$("#usersTable").DataTable();
		$("#toIndex").button();
	});
</script>

</head>
<body>
	<table border="2" id="usersTable">
		<thead>
			<tr>
				<th colspan="4" id="usersList">Felhasználók listája</th>
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

		<c:choose>
			<c:when test="${userList != NULL}">
				<c:forEach items="${userList}" var="item">
					<tr>
						<td><c:out value="${item.getName()}"></c:out></td>
						<td><c:out value="${item.getEmail()}"></c:out></td>
						<td><c:out value="${item.getPassword()}"></c:out></td>
						<td><c:out value="${item.getDate()}"></c:out></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan=4><c:out value="Nincs regisztalt felhasznalo!"></c:out>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tfoot>
			<tr>
				<td colspan="4"><a href="index.jsp" id="toIndex">Vissza a
						regisztációhoz</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>