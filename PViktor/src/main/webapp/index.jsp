<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.warning {
	color: red;
	font-weight: bold;
	border: 34;
}
</style>
<script>
$(function() {
 
	 $( "#registr" ).submit(function( event ) {
		 
		 if(!$("#user").val()) {
   		 	 $("#userL").addClass("warning");
   	  	 	 event.preventDefault();
		 }else {
   	 		 $('#userL').removeClass('warning');  
  	 	  }
		 if(!$("#passwd").val() || $("#passwd").val() != $("#passwd2").val() ) {
   		 	 $("#passwdL").addClass("warning");
   		 	 $("#passwd2L").addClass("warning");
   	  	  	event.preventDefault();
		 }else {
   	 		 $('#passwdL').removeClass('warning');  
   	 		$('#passwd2L').removeClass('warning');  
  	 	  }
		
		 if(!$("#email").val()) {
   		 	 $("#emailL").addClass("warning");
   	  	  event.preventDefault();
		 }else {
   	 		 $('#emailL').removeClass('warning');  
  	 	  }
		 
	 });
	
});

</script>

<title>Registration</title>
</head>
<body>
	<div align="center" id="registration">
		<form action="RegistrationServlet" method="post" id="registr">
		
			<label id="userL">Felhasználónév: </label> <br/> 
			<input type="text" name="user" id="user"> <br/> 
			
			<label id="passwdL">Jelszó: </label> <br />
			<input type="password" name="password" id="passwd"> <br/> 
			
			<label id="passwd2L">Jelszó ismétlés: </label> <br/> 
			<input type="password" name="password2" id="passwd2"> <br/> 
			
			<label id="emailL">E-mail cím: </label> <br/> 
			<input type="email"  name="email" id="email"> <br/> 
			
			<input type="submit" value="Küldés">
		</form>
	</div>

	<div align="center" id="registrationlist">
		<form action="RegistrationListServlet" method="get">
			<input type="submit" value="Regisztráltak listája">
		</form>
		
	</div>
	<%
	String state = (String) request.getAttribute("state");
	log(state);
	if(state != null && state.equals("OK")) {
		%>
		<div>
		 <font color="green" size="26">
		 	Sikeres regisztráció!	
		 </font>
		 <script>
		 setTimeout(function(){ 
			 document.location.href="result.jsp" }, 3000);
		 </script>
		</div>
		<%
	} else if(state != null) {
		%>
		<div>
		 <font color="red" size="26">
		 	Hiba történt a  regisztráció közben!
		 </font>
		</div>
		<%
	}
	%>
</body>
</html>