<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/registration.css">
<link href='http://fonts.googleapis.com/css?family=Roboto:400'
	rel='stylesheet' type='text/css'>
<script src="js/signUpValidationRules.js"></script>
</head>
<body>
	<div id="tab" class="tab">
		<h2>Sing up</h2>
		<form id="signUpForm" method="post" action="SaveUserServlet">
			<input class="simple" type="text" id="userName" name="userName"
				placeholder="User name" value="papus89" required> <input
				class="left" type="text" id="firstName" name="firstName"
				placeholder="First Name" value="Szabolcs" required> <input
				class="right" type="text" id="lastName" name="lastName"
				placeholder="Last name" value="Papellas" required> <input
				class="simple" type="email" id="email" name="email"
				placeholder="Email" value="papellas_szabolcs@yahoo.com" required>
			<input class="simple" type="tel" id="phone" name="phone"
				placeholder="Phone" value="+36202080016" required> <input
				class="simple" type="text" id="location" name="location"
				placeholder="Location" value="Debrecen" required> <input
				class="left" type="password" id="password" name="password"
				placeholder="Password" value="abcd" required> <input
				class="right" type="password" id="confirmPassword"
				name="confirmPassword" placeholder="Confirm password" value="abcd"
				required> <select class="simple" id="gender" name="gender">
				<option value="0">Select gender</option>
				<option value="m">Male</option>
				<option value="f">Female</option>
			</select>

			<%@page import="java.util.*"%>
			<%
				int numberOfYears = 80;
				int numberOfDays = 30;
				int day = 1;
				Calendar calendar = Calendar.getInstance();
				int currentYear = calendar.get(Calendar.YEAR);
			%>
			<select class="leftDate" id="year" name="year">
				<option value="0">Year</option>
				<%
					for (int i = 0; i <= numberOfYears; i++) {
				%>
				<option value="<%=currentYear - i%>">
					<%=currentYear - i%></option>
				<%
					}
				%>
			</select><select class="centerDate" id="month" name="month">
				<option value=0>Month</option>
				<option value=January>January</option>
				<option value=February>February</option>
				<option value=March>March</option>
				<option value=April>April</option>
				<option value=May>May</option>
				<option value=June>June</option>
				<option value=July>July</option>
				<option value=August>August</option>
				<option value=September>September</option>
				<option value=October>October</option>
				<option value=November>November</option>
				<option value=December>December</option>
			</select><select class="rightDate" id="day" name="day">
				<option value=0>Day</option>

				<%
					for (int i = 0; i <= numberOfDays; i++) {
				%>
				<option value="<%=day + i%>">
					<%=day + i%></option>
				<%
					}
				%>

			</select>
			<button id="buttonSignUp">Submit</button>
		</form>
		<button class="href" onclick="window.location.href='index.jsp';">Sign
			in!</button>
	</div>
	<c:choose>
		<c:when test="${state == 'OK'}">
			<script>
				setTimeout(function() {
					document.location.href = "index.jsp"
				}, 2000);
			</script>
		</c:when>
		<c:otherwise>
			<c:out value="${state}!" />
		</c:otherwise>
	</c:choose>
</body>
</html>

