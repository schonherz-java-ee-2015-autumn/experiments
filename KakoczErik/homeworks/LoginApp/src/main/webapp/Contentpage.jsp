<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "hu.schonherz.webapp.User" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<% 
	
	
	
	ArrayList<User> users=(ArrayList)request.getAttribute("Users");
%>
<title>Contentpage</title>
</head>
<body>
	<div align="center" >
		<h1>Ubercool Content</h1>
	</div>
	<div align="center" >
		Ubercool people who choose this site:<br>
		
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<t1>Ubercool Users</t1>
				</tr>
				<tr>
					<td>Username</td>
					<td>Password</td>
					<td>Date of birth</td>
					<td>e-mail</td>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>	
</body>
</html>