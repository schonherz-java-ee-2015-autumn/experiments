<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.warning {
	color: red;
	font-weight: bold;
	border: 34;
}
tfoot{
 text-align: center;
}

</style>
<script>
	
	
	$(function() {
		$( "#date" ).datepicker();
		$("#sendform").button();
		$("#sendformreglist").button();
		
		$("#registr").submit(
				function(event) {

					if (!$("#user").val()) {
						$("#userL").addClass("warning");
						event.preventDefault();
					} else {
						$('#userL').removeClass('warning');
					}
					if (!$("#passwd").val()
							|| $("#passwd").val() != $("#passwd2").val()) {
						$("#passwdL").addClass("warning");
						$("#passwd2L").addClass("warning");
						event.preventDefault();
					} else {
						$('#passwdL').removeClass('warning');
						$('#passwd2L').removeClass('warning');
					}

					if (!$("#email").val()) {
						$("#emailL").addClass("warning");
						event.preventDefault();
					} else {
						$('#emailL').removeClass('warning');
					}
				});
	});
</script>

<title>Registration</title>
</head>
<body>
	<div align="center" id="registration">
		<form action="RegistrationServlet" method="post" id="registr">
			<table border="2" id="regTable">
				<thead>
					<tr>
						<td colspan="2" align="center"><h2>Regisztáció</h2></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label id="userL">Felhasználónév: </label></td>
						<td><input type="text" name="user" id="user" title="Kérlek add meg a felhasználóneved"></td>
					</tr>
					<tr>
						<td><label id="passwdL">Jelszó: </label></td>
						<td><input type="password" name="passwd" id="passwd" title="Kérlek add meg a jelszavad"></td>
					</tr>
					<tr>
						<td><label id="passwd2L">Jelszó újra: </label></td>
						<td><input type="password" name="passwd2" id="passwd2" title="Kérlek add meg a jelszavad újra"></td>
					</tr>
					<tr>
						<td><label id="emailL">E-mail cím: </label></td>
						<td><input type="email" name="email" id="email" title="Kérlek add meg az e-mail címed"></td>
					</tr>
					<tr>
						<td><label id="dateIdL">Születési dátum:</label></td>
						<td><input type="text" name="date" id="date" title="Kérlek add meg a születési dátumod"></td>
				</tr>
				</tbody>
			</table>
			<input type="submit" id="sendform" value="Küldés!">
		</form>
		<form action="RegistrationListServlet" method="get" id="reglist">
			<input type="submit" id="sendformreglist" value="Regisztraltak listaja">
		</form>
	</div>

	<div align="center" id="registrationlist"></div>
	<%
		String state = (String) request.getAttribute("state");

		if (state != null && state.equals("OK")) {
	%>
	<div>
		<font color="green" size="26"> Sikeres regisztráció! </font>
		<script>
			setTimeout(function() {
				document.location.href = "userList.jsp"
			}, 1000);
		</script>
	</div>
	<%
		} else if (state != null) {
	%>
	<div>
		<font color="red" size="26"> Hiba történt a regisztráció
			közben! </font>
	</div>
	<%
		}
	%>
</body>
</html>