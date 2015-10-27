<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Felhasználók</title>

<body>
<script>

</script>
	<%@page import="java.util.ArrayList"%>
	<table border="2" id="userTable">
		<thead></thead>
		<thead>
			<tr>
				<th>Felhasználónév</td>
				<th>E-mail</td>
				<th>Jelszó</td>
			</tr>
		</thead>
		<tbody>
			<%
				if (session.getAttribute("user") != null) {
					ArrayList<hu.schonherz.web.login.User> itemsArray = (ArrayList<hu.schonherz.web.login.User>) session
							.getAttribute("user");
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
			</tr>
			<%
					}
				}else {
					out.println("Nincs regisztalt felhasznalo!");
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
					<a href="index.jsp" id="toIndex" >Vissza a regisztációhoz</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>