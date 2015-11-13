<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/site.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/registration.js"></script>
<title>Regisztráció</title>
</head>
<body>
	<div id="web_body">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="regTable">
			<form method="post" action="Registration">
				<table>
					<thead>
						<tr>
							<td colspan="2"><h3>Regisztráció</h3></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="user" id="userL">Felhasználónév:</label></td>
							<td><input placeholder="Felhasználónév" type="text"
								id="user" name="Username"
								title="Kérlek add meg a felhasználóneved"></td>
							<td><span id="alreadyUser">Ez a felhaszálónév már
									foglalt!</span></td>
						</tr>
						<tr>
							<td><label for="passw" id="passwL">Jelszó:</label></td>
							<td><input placeholder="Jelszó" type="password" id="passw"
								name="Password" title="Kérlek add meg a jelszavad"></td>
						</tr>
						<tr>
							<td><label for="passwre" id="passwreL">Jelszó újra:</label></td>
							<td><input placeholder="Jelszó újra" type="password"
								id="passwre" name="Passwordre"
								title="Kérlek add meg a jelszavad újra"></td>
						</tr>
						<tr>
							<td><label for="fulln" id="fullnL">Teljes név:</label></td>
							<td><input placeholder="Teljes név" type="text" id="fulln"
								name="Fullname" title="Kérlek add meg a teljes neved"></td>
						</tr>
						<tr>
							<td><label for="e-mail" id="emailL">E-mail:</label></td>
							<td><input placeholder="E-mail" type="text" id="e-mail"
								name="E-mail" title="Kérlek add meg az e-mail címed"></td>
							<td><span id="alreadyEmail">Ezzel az e-mail címmel
									már regisztráltak!</span></td>
						</tr>
						<tr>
							<td><label for="dateId" id="dateIdL">Születési
									dátum:</label></td>
							<td><input placeholder="Születési dátum" type="text"
								id="dateId" name="Date"
								title="Kérlek add meg a születési dátumod"></td>
						</tr>
						<tr>
							<td><label for="birthplace">Születési hely:</label></td>
							<td><input placeholder="Születési hely" type="text"
								id="birthplace" name="Birth"
								title="Kérlek add meg a születési helyed"></td>
						</tr>

					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="Küldés!"></td>
						</tr>
						<tr>
							<td colspan="2"><a href="userlist.jsp" id="toUsers">Felhasználók
									listája</a></td>
						</tr>
					</tfoot>
				</table>
			</form>

			<%
				String state = (String) request.getAttribute("state");
				if (state != null && state.equals("OK")) {
			%>
			<div class="messageAfterReg">
				<font color="green" size="6"> Sikeres regisztráció! </font>
				<script>
					setTimeout(function() {
						document.location.href = "userlist.jsp"
					}, 2000);
				</script>
			</div>
			<%
				} else if (state != null) {
			%>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="red" size="6"> Hiba
					történt a regisztráció közben! </font>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
