<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Register</h1>
	
	<form action="UserRegister" method="post">
	
		Username:<input type="text" name="usrnm">*<br>
		password:<input type="text" name="pwd">*<br>
		password confirmation:<input type="text" name="pwdc">*<br>
		Date of Birth(YYYY.MM.DD):<input type="text" name="date">*<br>
		e-mail:<input type="text" name="mail">*<br>
		Refer your friend:<input type="text" name="friend"><br>
		<input type="submit">
	</form>
	fields marked with a "*" must be filled in.
</body>
</html>