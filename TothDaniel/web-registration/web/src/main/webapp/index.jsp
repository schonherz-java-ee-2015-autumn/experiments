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
	
	  $( "form" ).submit(function( event ) {
		  
    	  var d = validateDate($("#dateId").val(),"MM/dd/yyyy");
    	  
    	  if(d != "true") {
   	 		 $('#dateIdL').addClass('warning');   
   	 		  event.preventDefault();   	 		  
   	 	  } else {
   	 		 $('#dateIdL').removeClass('warning');  
   	 	  }
    
    	});
    
   
  function validateDate(inputDate,inputDateFormat) {
		var reValue = 0;
		$.ajax({
			url : 'ValidateDate',
			method : "POST",
			data : {
				date : inputDate,
				dateFormat : inputDateFormat
			},
			success : function(data) {
				reValue = data;
			},
			error : function(data) {
				reValue = data;
			},
			dataType : "html",
			async:false
		});
		return reValue;
	}
   
	
</script>
</head>
<body>
<div id="main">

	<div id="accordion">

		<h2>Registration</h2>
		<div>
			<form action="RegistrationServlet" method="post" class="cmxform">
					<p><label for="username" id="usernameLabel"> User name:<span>**</span> </label>
					<input type="text" name="username" minlength="4" required></p> 
					<p><label for="firstname" id="firstNameLabel">First name:</label> <input type="text" name="firstname"> </p>
					<p><label for="latsname" id="lastNameLabel">Last name:</label> <input type="text" name="lastname"></p>
					<p><label for="email" id="emailLabel">E-mail:<span>*</span></label><input type="email" name="email" required></p>
					<p> <label for="pass" id="passwordLabel">Password:<span>***</span></label><input type="password" name="pass" required minlength="6"></p>
					<p><label for="birth" id="dateOfBirthLabel">Birth date:<span>*</span></label><input type="text" name="birth" id="datepicker" required></p>
					<p> <input type="submit" value="Register"></p>
					<div id="tooltip">
					<p>*- required<p>
					<p>** - required, minimum 4 characters long.<p>
					<p>***- required, minimum 6 characters long.<p>
					
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
}else if(state!=null && state.equals("LOGIN_FAILURE")){
	%>
	<div class="failure">Login failed. </div>
	<%
}
%>
	</div>
</body>
</html>
