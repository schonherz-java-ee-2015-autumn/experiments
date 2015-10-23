<html>
<head>
<meta charset="utf-8">

<jsp:include page="header.jsp"></jsp:include>

<script>
	$(function() {
		$("#accordion").accordion();
		$("#datepicker" ).datepicker({
		      changeMonth: true,
		      changeYear: true,
		       minDate: "-120y", 
		       maxDate: -1 
		    });
		$( "input[type=submit], a, button" )
	      .button();
	      
	});
	
</script>
</head>
<body>
<div id="main">

	<div id="accordion">

		<h2>Registration</h2>
		<div>
			<form action="RegistrationServlet" method="post" class="cmxform">
					<p><label for="username"> User name:<span>*</span> </label>
					<input type="text" name="username" minlength="4" required></p> 
					<p><label for="firstname">First name:</label> <input type="text" name="firstname"> </p>
					<p><label for="latsname">Last name:</label> <input type="text" name="lastname"></p>
					<p><label for="email">E-mail:</label><input type="email" name="email"></p>
					<p> <label for="pass">Password:<span>**</span></label><input type="password" name="pass" required minlength="6"></p>
					<p><label for="birth">Birth date:</label><input type="text" name="birth" id="datepicker"></p>
					<p> <input type="submit" value="Register"></p>
					<div id="tooltip">
					<p>* - required, minimum 4 characters long.<p>
					<p>**- required, minimum 6 characters long.<p>
					</div>
			</form>
		</div>

		<h2>Login</h2>
		<div>
			<form action="LoginServlet" method="post" class="cmxform">
					<p><label for="username">User name:</label> <input type="text" name="username" required></p>
					<p><label for="pass">Password:</label> <input type="password" name="pass" required></p>
					<p><input type="submit" value="Login"><p>
			</form>
		</div>
	</div>
	<%
String state = (String) request.getAttribute("state");
 if(state !=null && state.equals("SUCCESS")){
	 request.removeAttribute("state");
	for (java.util.Enumeration<String> e = request.getAttributeNames(); e.hasMoreElements();)
		       request.removeAttribute(e.nextElement());
	%>
	<div class="success">Successful registration! </div>
	
	<script>
		//javascript redirection
		
		setTimeout(function(){document.location.replace("UserList.jsp")}, 1200);
</script>
	<%
}else if(state!=null && state.equals("FAILURE")){
	request.removeAttribute("state");
	for (java.util.Enumeration<String> e = request.getAttributeNames(); e.hasMoreElements();)
	       request.removeAttribute(e.nextElement());
	%>
	<div class="failure">Registration failed. </div>
	<%
}
%>
	</div>
</body>
</html>
