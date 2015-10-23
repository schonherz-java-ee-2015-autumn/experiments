<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Felhasználók</title>
</head>
<body>
	<table border="2">
		<thead></thead>
		<tbody>
			<tr>
				<td>Felhasználónév</td>
				<td>Jelszó</td>
			</tr>

				<c:forEach var="users" items="${users}">
					<tr>
						<td>${users.key}</td>
						<td>${users.value}</td>
					</tr>
				</c:forEach>
			
		</tbody>
	</table>
</body>
</html>