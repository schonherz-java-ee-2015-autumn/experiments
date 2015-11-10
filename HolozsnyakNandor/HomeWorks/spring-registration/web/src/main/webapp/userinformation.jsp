<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/site.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/site.js"></script>
<script>
$(function(){
	$.ajax({ 
	    type: 'POST', 
	    url: '/Login', 
	    dataType: 'json',
	    data:data
	});
});
</script>
</head>
<body>
	<div id="regTable">
		<form method="post" action="Logout">
			<table>
				<thead>
					<tr>
						<td colspan="2"><h3>Felhasználó adatai</h3></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="user" id="userL">Felhasználónév:</label></td>
						<td><input placeholder="Felhasználónév" type="text" id="user"
							name="Username" title="Kérlek add meg a felhasználóneved"></td>
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
					</tr>
					<tr>
						<td><label for="dateId" id="dateIdL">Születési dátum:</label></td>
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
						<td colspan="1"><input type="submit" value="Küldés!"></td>
					</tr>
				</tfoot>
			</table>
		</form>
</body>
</html>