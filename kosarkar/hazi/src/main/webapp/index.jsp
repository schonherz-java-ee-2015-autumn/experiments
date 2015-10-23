<html>
<head>
<meta charset="utf-8">
<title>jQuery UI Accordion - Default functionality</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="/resources/default.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="jquery.validate.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
	$("form").validate();
</script>
</head>
<body>
<div id="main">

	<div id="accordion">

		<h2>Registration</h2>
		<div>
			<form action="RegistrationServlet" method="post" class="cmxform">
				<fieldset>
					<p><label for="username"> User name: <span>Required minimum 4 characters</span> </label>
					<input type="text" name="username" minlength="4" required></p> 
					<p><label for="firstname">First name:</label> <input type="text" name="firstname"> </p>
					<p><label for="latsname">Last name:</label> <input type="text" name="lastname"></p>
					<p> <label for="pass">Password:<span>Required minimum 4 characters</span></label><input type="password" name="pass" required minlength="4"></p>
					<p> <label for="motto">Motto:</label><input type="text" name="motto" value="Insert awesome quote here..."></p>
					<p> <input type="submit" value="Register"></p>
				</fieldset>
			</form>
		</div>

		<h2>Login</h2>
		<div>

			<form action="LoginServlet" method="post" class="cmxform">
				<fieldset>
					<p><label for="username">User name:</label> <input type="text" name="username" required></p>
					<p><label for="pass">Password:</label> <input type="password" name="pass" required></p>
					<p><input type="submit" value="Login"><p>
				</fieldset>
			</form>



		</div>
	</div>
	</div>
</body>
</html>
