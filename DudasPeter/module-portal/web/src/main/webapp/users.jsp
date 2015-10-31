<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Facebook 2 - Users</title>
<%@ include file="header.jsp" %>
</head>
<body>

	<div id="container">
		<div id="topnav">
			<%@ include file="topnav.jsp"%>
		</div>
		
		<div id="content">
			<div class="table-wrapper">
				<table class="usertable">
					<thead>
						<tr>
							<th>Name</th>
							<th>E-mail</th>
							<th>Date of Birth</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		
		<div id="footer">
			<%@include file="footer.jsp"%>
		</div>
	</div>

</body>
</html>
