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
<title>Regisztr�ci�</title>
</head>
<body>
	<div id="web_body">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="regTable">
			<form method="post" action="Registration">
				<table>
					<thead>
						<tr>
							<td colspan="2"><h3>Regisztr�ci�</h3></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="user" id="userL">Felhaszn�l�n�v:</label></td>
							<td><input placeholder="Felhaszn�l�n�v" type="text"
								id="user" name="Username"
								title="K�rlek add meg a felhaszn�l�neved"></td>
							<td><span id="alreadyUser">Ez a felhasz�l�n�v m�r
									foglalt!</span></td>
						</tr>
						<tr>
							<td><label for="passw" id="passwL">Jelsz�:</label></td>
							<td><input placeholder="Jelsz�" type="password" id="passw"
								name="Password" title="K�rlek add meg a jelszavad"></td>
						</tr>
						<tr>
							<td><label for="passwre" id="passwreL">Jelsz� �jra:</label></td>
							<td><input placeholder="Jelsz� �jra" type="password"
								id="passwre" name="Passwordre"
								title="K�rlek add meg a jelszavad �jra"></td>
						</tr>
						<tr>
							<td><label for="fulln" id="fullnL">Teljes n�v:</label></td>
							<td><input placeholder="Teljes n�v" type="text" id="fulln"
								name="Fullname" title="K�rlek add meg a teljes neved"></td>
						</tr>
						<tr>
							<td><label for="e-mail" id="emailL">E-mail:</label></td>
							<td><input placeholder="E-mail" type="text" id="e-mail"
								name="E-mail" title="K�rlek add meg az e-mail c�med"></td>
							<td><span id="alreadyEmail">Ezzel az e-mail c�mmel
									m�r regisztr�ltak!</span></td>
						</tr>
						<tr>
							<td><label for="dateId" id="dateIdL">Sz�let�si
									d�tum:</label></td>
							<td><input placeholder="Sz�let�si d�tum" type="text"
								id="dateId" name="Date"
								title="K�rlek add meg a sz�let�si d�tumod"></td>
						</tr>
						<tr>
							<td><label for="birthplace">Sz�let�si hely:</label></td>
							<td><input placeholder="Sz�let�si hely" type="text"
								id="birthplace" name="Birth"
								title="K�rlek add meg a sz�let�si helyed"></td>
						</tr>

					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="K�ld�s!"></td>
						</tr>
						<tr>
							<td colspan="2"><a href="userlist.jsp" id="toUsers">Felhaszn�l�k
									list�ja</a></td>
						</tr>
					</tfoot>
				</table>
			</form>

			<%
				String state = (String) request.getAttribute("state");
				if (state != null && state.equals("OK")) {
			%>
			<div class="messageAfterReg">
				<font color="green" size="6"> Sikeres regisztr�ci�! </font>
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
					t�rt�nt a regisztr�ci� k�zben! </font>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
