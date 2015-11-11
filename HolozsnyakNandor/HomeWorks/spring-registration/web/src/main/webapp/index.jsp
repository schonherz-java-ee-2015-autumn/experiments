<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/site.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/site.js"></script>
<title>Föoldal</title>
</head>
<body>
	<div id="web_body">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="loginTable">
			<form method="post" action="Login">
				<table>
					<thead>
						<tr>
							<td colspan="2"><h3>Bejelentkezés</h3></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="user" id="userL">Felhasználónév:</label></td>
							<td><input placeholder="Felhasználónév" type="text"
								id="user" name="Username"
								title="Kérlek add meg a felhasználóneved"></td>
						</tr>
						<tr>
							<td><label for="passw" id="passwL">Jelszó:</label></td>
							<td><input placeholder="Jelszó" type="password" id="passw"
								name="Password" title="Kérlek add meg a jelszavad"></td>
						</tr>

					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="Küldés!"></td>
						</tr>
					</tfoot>
				</table>
			</form>
			<%
				String state = (String) session.getAttribute("state");
				if (state != null && state.equals("LOGGEDIN")) {
			%>
			<div class="messageAfterReg">
				<font color="green" size="6"> Sikeres bejelentkezés! </font>
				<script>
					setTimeout(function() {
						document.location.href = "userlist.jsp"
					}, 2000);
				</script>
			</div>
			<%
				} else if (state != null && state.equals("NOTLOGGEDIN")) {
			%>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="red" size="6"> Hibás
					felhasználónév vagy jelszó </font>
			</div>
			<%
				} else if (state != null && state.equals("LOGGEDOUT")) {
			%>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="green" size="6"> Sikeres
					kijelentkezés! </font>
			</div>
			<%
				} else if (state != null) {
			%>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="red" size="6"> Hiba
					történt! </font>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
