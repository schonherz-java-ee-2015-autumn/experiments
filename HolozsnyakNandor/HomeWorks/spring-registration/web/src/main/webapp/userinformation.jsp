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
						<td colspan="2"><h3>Felhaszn�l� adatai</h3></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="user" id="userL">Felhaszn�l�n�v:</label></td>
						<td><input placeholder="Felhaszn�l�n�v" type="text" id="user"
							name="Username" title="K�rlek add meg a felhaszn�l�neved"></td>
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
					</tr>
					<tr>
						<td><label for="dateId" id="dateIdL">Sz�let�si d�tum:</label></td>
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
						<td colspan="1"><input type="submit" value="K�ld�s!"></td>
					</tr>
				</tfoot>
			</table>
		</form>
</body>
</html>