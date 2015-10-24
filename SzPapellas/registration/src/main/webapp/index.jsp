<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/registrationPage.css">
<style>
body {
	/* 	background-color: transparent; */
	/*   	background-image: url(resources/bg.png); */
	/*  	background-repeat: repeat; */
	/*   	background-position: left top; */
	/* 	font-family: cursive; */
	/* 	color: #3ed651; */
	background: #FFFFFF;
	font-family: Verdana;
	font-size: 12px;
}

select {
	width: 32%;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	border-width: 2px;
	border-style: solid;
	padding: 6px;
	border-color: #18ab29;
	box-shadow: 0px 0px 5px 0px rgba(60, 194, 27, .75);
	font-size: 14px;
	margin-bottom: 4px;
	border-width: 2px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
}

#genderId {
	border-width: 2px;
	border-style: solid;
	padding: 6px;
	border-color: #18ab29;
	box-shadow: 0px 0px 5px 0px rgba(60, 194, 27, .75);
	font-size: 14px;
	margin-bottom: 4px;
	box-sizing: border-box;
	width: 100%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
}

#registrationButton {
	-moz-box-shadow: 0px 0px 15px -1px #3dc21b;
	-webkit-box-shadow: 0px 0px 15px -1px #3dc21b;
	box-shadow: 0px 0px 15px -1px #3dc21b;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #44c767
		), color-stop(1, #5cbf2a));
	background: -moz-linear-gradient(top, #44c767 5%, #5cbf2a 100%);
	background: -webkit-linear-gradient(top, #44c767 5%, #5cbf2a 100%);
	background: -o-linear-gradient(top, #44c767 5%, #5cbf2a 100%);
	background: -ms-linear-gradient(top, #44c767 5%, #5cbf2a 100%);
	background: linear-gradient(to bottom, #44c767 5%, #5cbf2a 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#44c767',
		endColorstr='#5cbf2a', GradientType=0);
	background-color: #44c767;
	border: 2px solid #18ab29;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Verdana;
	font-size: 16px;
	padding: 4px 4px;
	text-decoration: none;
	text-shadow: 0px 0px 0px #2f6627;
	margin-top: 30px;
	width: 100%;
}

#registrationButton:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #5cbf2a
		), color-stop(1, #44c767));
	background: -moz-linear-gradient(top, #5cbf2a 5%, #44c767 100%);
	background: -webkit-linear-gradient(top, #5cbf2a 5%, #44c767 100%);
	background: -o-linear-gradient(top, #5cbf2a 5%, #44c767 100%);
	background: -ms-linear-gradient(top, #5cbf2a 5%, #44c767 100%);
	background: linear-gradient(to bottom, #5cbf2a 5%, #44c767 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#5cbf2a',
		endColorstr='#44c767', GradientType=0);
	background-color: #5cbf2a;
}

#registrationButton:active {
	position: relative;
}

input {
	width: 100%;
	border-width: 2px;
	border-style: solid;
	padding: 6px;
	border-color: #18ab29;
	box-shadow: 0px 0px 5px 0px rgba(60, 194, 27, .75);
	font-size: 14px;
	margin-bottom: 4px;
	border-width: 2px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
}

table {
	border: 2px solid #5cbf2a;
	padding: 15px;
	margin: auto;
	align: center;
	width: 30%;
	box-shadow: 0px 0px 5px 0px #D9DADB;
}

#success {
	border: 2px solid #5cbf2a;
	padding: 15px;
	margin: auto;
	align: center;
	width: 40%;
	box-shadow: 0px 0px 5px 0px #D9DADB;
}

p {
	text-align: center;
	font-family: Verdana;
	font-size: 20px;
	color: #18ab29;
}

.tooltip {
	margin-left: 10px;
	border: 2px solid #FFFFFF;
	color: #FFFFFF;
	text-align: center;
	font: bold 14px "Helvetica Neue", Sans-Serif;
	background-color: #FF0000;
	position: absolute;
	z-index: 2;
	padding: 6px;
	box-shadow: 0 0 7px black;
}
</style>

<title>Registration</title>
</head>
<body>
	<div id="content">
		<form id="registrationForm" action="ServletCheckRegistration"
			method="post">
			<table>
				<tr>
					<td><input type="text" id="firstNameId" name="firstName"
						placeholder="First Name"></td>
				</tr>
				<tr>
					<td><input type="text" id="lastNameId" name="lastName"
						placeholder="Last name"></td>
				</tr>
				<tr>
					<td><input type="text" id="emailId" name="email"
						placeholder="Email"></td>
				</tr>
				<tr>
					<td><input type="text" id="phoneId" name="phone"
						placeholder="Phone"></td>
				</tr>
				<tr>
					<td><input type="text" id="locationId" name="location"
						placeholder="Location"></td>
				</tr>
				<tr>
					<td><input type="password" id="passwordId" name="password"
						placeholder="Password"></td>
				</tr>
				<tr>
					<td><input type="password" id="confirmPasswordId"
						name="passwordConfirmation" placeholder="Confirm password"></td>
				</tr>
				<tr>
					<td><select id="genderId" name="gender">
							<option value="0">Select gender</option>
							<option value="1">Male</option>
							<option value="2">Female</option>
					</select></td>
				<tr>
					<td>Birthday</td>
				</tr>
				<tr id="birthdatTr">
					<%@page import="java.util.*"%>
					<%
						int numberOfYears = 80;
						int numberOfDays = 30;
						int day = 1;
						Calendar calendar = Calendar.getInstance();
						int currentYear = calendar.get(Calendar.YEAR);
					%>
					<td><select id="year" name="year">
							<%
								for (int i = 0; i <= numberOfYears; i++) {
							%>
							<option value="<%=currentYear - i%>">
								<%=currentYear - i%></option>
							<%
								}
							%>
					</select> <select id="month" name="month">
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
					</select> <select id="day" name="day">

							<%
								for (int i = 0; i <= numberOfDays; i++) {
							%>
							<option value="<%=day + i%>">
								<%=day + i%></option>
							<%
								}
							%>

					</select></td>
				</tr>
				<tr>
					<td><input id="registrationButton" type="submit"
						value="Registration"></td>
				</tr>
			</table>

		</form>
	</div>
	<script>
		$(document)
				.on(
						'click',
						'#registrationButton',
						function(event) {

							var errorMessage;
							var errorId;

							if (!$("#firstNameId").val()) {
								errorMessage = "You must enter your first name!";
								errorId = "#firstNameId";
								event.preventDefault();
							} else if (!$("#lastNameId").val()) {
								errorMessage = "You must enter your last name!";
								errorId = "#lastNameId";
								event.preventDefault();
							} else if (!$("#emailId").val()) {
								errorMessage = "You must enter your email!";
								errorId = "#emailId";
								event.preventDefault();
							} else if (!validateEmail($("#emailId").val())) {
								errorMessage = "You must enter a valid email!";
								errorId = "#emailId";
								event.preventDefault();
							} else if (!$("#phoneId").val()) {
								errorMessage = "You must enter your phone number!";
								errorId = "#phoneId";
								event.preventDefault();
							} else if (!validatePhone($("#phoneId").val())) {
								errorMessage = "You must enter a valid phone number!";
								errorId = "#phoneId";
								event.preventDefault();
							} else if (!$("#locationId").val()) {
								errorMessage = "You must enter your location!";
								errorId = "#locationId";
								event.preventDefault();
							} else if (!$("#passwordId").val()) {
								errorMessage = "You must enter a valid password!";
								errorId = "#passwordId";
								event.preventDefault();
							} else if (!$("#confirmPasswordId").val()) {
								errorMessage = "You must confirm your password!";
								errorId = "#confirmPasswordId";
								event.preventDefault();
							} else if ($("#passwordId").val() != $(
									"#confirmPasswordId").val()) {
								errorMessage = "Password confirmation doesn't match password!";
								errorId = "#confirmPasswordId";
								event.preventDefault();
							} else if ($("#genderId").val() == 0) {
								errorMessage = "You must select your gender!";
								errorId = "#genderId";
								event.preventDefault();
							}

							if (errorMessage.length > 0) {

								elementPosition(errorId, errorMessage);
								onTextChanged(errorId);

							}
						});

		var elementPosition = function(element, errorMessage) {

			var position = $(element).position();
			var elementWidth = $(element).width();
			showTooltip(position.left + elementWidth, position.top,
					errorMessage);

		};

		var tooltipPosition = function(positionLeft, positionTop) {

			$('div.tooltip').css({
				top : positionTop,
				left : positionLeft
			});
		};

		var hideTooltip = function() {
			$('div.tooltip').remove();
		};

		var showTooltip = function(positionLeft, positionTop, errorMessage) {
			$('div.tooltip').remove();
			$('<div class="tooltip">' + errorMessage + '</div>').appendTo(
					'body');
			tooltipPosition(positionLeft, positionTop);
		};

		var onTextChanged = function(element) {

			$(element).on("keyup change", function() {
				hideTooltip();
			});
		};

		function validateEmail(email) {
			var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			return re.test(email);
		}

		function validatePhone(phone) {
			var re = /[0-9 -()+]+$/;
			return re.test(phone);
		}
	</script>
	<%
		String state = (String) request.getAttribute("state");
		if (state != null && state.equals("OK")) {
	%>
	<div id="success">
		<p>Successful registration!</p>
		<script>
			$("#content").hide();
			setTimeout(function() {
				document.location.href = "ServletDisplayUsers"
			}, 2000);
		</script>
	</div>
	<%
		} else if (state != null) {
			System.out.println(request.getAttribute("firstName"));
	%>
	<script>
		elementPosition("#emailId",
				"Sorry, it looks like this email belongs to an existing account.");
		onTextChanged("#emailId");

		function fill(a) {
			for ( var k in a) {
				$('[id="' + k + '"]').val(a[k]);
			}
		}

		array_example = {
			"#firstNameId" : request.getParameter("firstName"),
			"#lastNameId" : request.getParameter("lastName"),
			"#emailId" : request.getParameter("email"),
			"#phoneId" : request.getParameter("phone"),
			"#locationId" : request.getParameter("location"),
			"#passwordId" : request.getParameter("password"),
			"#confirmPasswordId" : request.getParameter("password"),
			"#genderId" : request.getParameter("gender"),
			"#year" : request.getParameter("year"),
			"#month" : request.getParameter("month"),
			"#day" : request.getParameter("day"),
		};

		fill(array_example);
	</script>
	<%
		}
	%>
</body>
</html>

