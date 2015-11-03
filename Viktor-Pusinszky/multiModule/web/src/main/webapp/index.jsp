<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style>
.warning {
	color: red;
	font-weight: bold;
	border: 34;
}
#SikertelenRegisztracioID {
	color : red ;
	font-weight: bold;
	font-size: 26px;
}
#SikeresRegisztracioID {
	color : green ;
	font-weight: bold;
	font-size: 26px;
}
</style>

<script>
	$(function() {

		$("#date").datepicker();
		$("#sendform").button();
		$("#sendformreglist").button();
		$("#registrationwform").submit(
				function(event) {
					if (!$("#user").val()) {
						$("#userL").addClass("warning");
						event.preventDefault();
					} else {
						$('#userL').removeClass('warning');
					}
					if (!$("#password").val()
							|| $("#password").val() != $("#password2").val()) {
						$("#passwordL").addClass("warning");
						$("#password2L").addClass("warning");
						event.preventDefault();
					} else {
						$('#passwordL').removeClass('warning');
						$('#password2L').removeClass('warning');
					}
					if (!$("#email").val()) {
						$("#emailL").addClass("warning");
						event.preventDefault();
					} else {
						$('#emailL').removeClass('warning');
					}
					if (!$("#date").val()) {
						$("#dateL").addClass("warning");
						event.preventDefault();
					} else {
						$('#dateL').removeClass('warning');
					}
				});
	});
</script>

<title>Registration</title>
</head>
<body>
	<div align="center" id="registration">
		<form action="RegistrationServlet" method="post" id="registrationform">
			<table border="2" id="regTable">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h2>Regisztáció</h2>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label id="userL">Felhasználónév:</label></td>
						<td><input type="text" name="user" id="user"></td>
					</tr>
					<tr>
						<td><label id="passwordL">Jelszó:</label></td>
						<td><input type="password" name="password" id="password"></td>
					</tr>
					<tr>
						<td><label id="password2L">Jelszó újra:</label></td>
						<td><input type="password" name="password2" id="password2"></td>
					</tr>
					<tr>
						<td><label id="emailL">E-mail cím:</label></td>
						<td><input type="email" name="email" id="email"></td>
					</tr>
					<tr>
						<td><label id="dateL">Születési dátum:</label></td>
						<td><input type="text" name="date" id="date"></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" id="sendform" value="Küldés!">
		</form>
		<form action="RegistrationListServlet" method="get" id="reglist">
			<input type="submit" id="sendformreglist"
				value="Regisztraltak listaja">
		</form>
	</div>

	<div align="center" id="registrationState">
		<c:choose>
			<c:when test="${state == 'OK'}">
				<div>
					<font id="SikeresRegisztracioID">Sikeres regisztráció!</font>
					<script>
// 						setTimeout(function() {
// 							document.location.href = "userList.jsp"
// 						}, 1000);
					</script>
				</div>
			</c:when>
			<c:when test="${state == 'ERROR'}">
				<div>
					<font id="SikertelenRegisztracioID"> Hiba történt a regisztráció közben!</font>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>