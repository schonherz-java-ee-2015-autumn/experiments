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
<title>F�oldal</title>
</head>
<body>
	<div id="web_body">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="loginTable">
			<form method="post" action="Login">
				<table>
					<thead>
						<tr>
							<td colspan="2"><h3>Bejelentkez�s</h3></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="user" id="userL">Felhaszn�l�n�v:</label></td>
							<td><input placeholder="Felhaszn�l�n�v" type="text"
								id="user" name="Username"
								title="K�rlek add meg a felhaszn�l�neved"></td>
						</tr>
						<tr>
							<td><label for="passw" id="passwL">Jelsz�:</label></td>
							<td><input placeholder="Jelsz�" type="password" id="passw"
								name="Password" title="K�rlek add meg a jelszavad"></td>
						</tr>

					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="K�ld�s!"></td>
						</tr>
					</tfoot>
				</table>
			</form>
			<%
				String state = (String) session.getAttribute("state");
				if (state != null && state.equals("LOGGEDIN")) {
			%>
			<div class="messageAfterReg">
				<font color="green" size="6"> Sikeres bejelentkez�s! </font>
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
				<font class="messageAfterReg" color="red" size="6"> Hib�s
					felhaszn�l�n�v vagy jelsz� </font>
			</div>
			<%
				} else if (state != null && state.equals("LOGGEDOUT")) {
			%>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="green" size="6"> Sikeres
					kijelentkez�s! </font>
			</div>
			<%
				} else if (state != null) {
			%>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="red" size="6"> Hiba
					t�rt�nt! </font>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>
