<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!-- <link rel="stylesheet" href="jquery-ui.css"> -->
<!-- <script src="jquery.js"></script> -->
<!-- <script src="jquery-ui.js"></script> -->
<style>

body {
/* 	background-color: transparent; */
/*   	background-image: url(resources/bg.png); */
/*  	background-repeat: repeat; */
/*   	background-position: left top; */
/* 	font-family: cursive; */
/* 	color: #3ed651; */
background:rgb(226,226,226);
	font-family: cursive;
}

table {
	border: 1px solid gray;
	border-radius: 10px;
	padding: 15px;
	margin: auto;
}

thead td {
	text-align:center;
}
tfoot td {
	margin:auto;
	text-align:center;
}
h2 {
	text-align:center;
}
.warning {
	color:red;
	font-weight: bold;
}
label {
   display: inline-block; width: 10em;
 }
.ui-tooltip {
   width: 25%;
 }
#dialog-confirm {
	display:none;
}
</style>

<script>

function validateDate(inputDate,inputDateFormat) {
	var reValue = 0;
	$.ajax({
		url : 'ValidateDate',
		method : "POST",
		data : {
			//message : $("#message").val()
			date : inputDate,
			dateFormat : inputDateFormat
		},
		success : function(data) {
			//$("#result").html(data);
			//alert(data);
			reValue = data;
		},
		error : function(data) {
			//alert(data);
			reValue = data;
		},
		dataType : "html",
		async:false
	});
	//alert("return");
	return reValue;
}

$(function() {
	
	
    $( "#dateId" ).datepicker();
    
    var places = [ "Nyíregyháza","Debrecen","Budapest" ];
    $( "#birthplace" ).autocomplete({
      source: places
    });
   
    
    $( "input[type=submit]" ).button();
    $( "#toUsers" ).button();
    $( "form" ).submit(function( event ) {
    	
    	  if(!$("#user").val()) {
    		  
    		  $("#userL").addClass("warning");
    	  	  event.preventDefault();
    	  }    	  
    	  if(!$("#passw").val()) {
    		  
    		  $("#passwL").addClass("warning");
    	  	  event.preventDefault();
    	  }
 		  if(!$("#passwre").val()) {
    		  
    		  $("#passwreL").addClass("warning");
    	  	  event.preventDefault();
    	  }
    	  if(!$("#fulln").val()) {
    		  
    		  $("#fullnL").addClass("warning");
    	  	  event.preventDefault();
    	  }
    	  if(!validateEmail($("#e-mail").val())) {
    		  
    		  $("#emailL").addClass("warning");
    	  	  event.preventDefault();
    	  }
    	  var a = $("#passw").val();
    	  var b = $("#passwre").val();
    	  if(a != b){
    		  
    		  $("#passwL").addClass("warning");
    		  $("#passwreL").addClass("warning");
    		  event.preventDefault();
    	  }
    	  
    	  var d = validateDate($("#dateId").val(),"MM/dd/yyyy");
    	  
    	  if(d != "true") {
   	 		 $('#dateIdL').addClass('warning');   
   	 		  event.preventDefault();   	 		  
   	 	  } else {
   	 		 $('#dateIdL').removeClass('warning');  
   	 	  }
    
    	});
    
    var tooltips = $( "[title]" ).tooltip({
        position: {
          my: "left top",
          at: "right+5 top-5"
        }
      });
    
    function validateEmail(email) {
        var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        return re.test(email);
    }
    
   
    
});
</script>
<title>Regisztráció</title>
</head>
<body>
	<form method="post" action="Registration">
		<table>
			<thead>
				<tr>
					<td colspan="2"><h3>Regisztáció</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label for="user" id="userL">Felhasználónév:</label></td>
					<td><input type="text" id="user" name="Username" title="Kérlek add meg a felhasználóneved"></td>
				</tr>
				<tr>
					<td><label for="passw" id="passwL">Jelszó:</label></td>
					<td><input type="password" id="passw" name="Password" title="Kérlek add meg a jelszavad"></td>
				</tr>
				<tr>
					<td><label for="passwre" id="passwreL">Jelszó újra:</label></td>
					<td><input type="password" id="passwre" name="Passwordre" title="Kérlek add meg a jelszavad újra"></td>
				</tr>
				<tr>
					<td><label for="fulln" id="fullnL">Teljes név:</label></td>
					<td><input type="text" id="fulln" name="Fullname" title="Kérlek add meg a teljes neved"></td>
				</tr>
				<tr>
					<td><label for="e-mail" id="emailL">E-mail:</label></td>
					<td><input type="text" id="e-mail" name="E-mail" title="Kérlek add meg az e-mail címed"></td>
				</tr>
				<tr>
					<td><label for="dateId" id="dateIdL">Születési dátum:</label></td>
					<td><input type="text" id="dateId" name="Date" title="Kérlek add meg a születési dátumod"></td>
				</tr>
				<tr>
					<td><label for="birthplace">Születési hely:</label></td>
					<td><input type="text" id="birthplace" name="Birth" title="Kérlek add meg a születési helyed"></td>
				</tr>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="Küldés!"></td>
				</tr>
				<tr>
					<td colspan="2"><a href="GetUsers" id="toUsers">Felhasználók listája</a></td>	
				</tr>
			</tfoot>
		</table>
	</form>
	
	<%
	String state = (String) request.getAttribute("state");
	if(state != null && state.equals("OK")) {
		%>
		<div>
		 <font color="green" size="26">
		 	Sikeres regisztráció!
		 	
		 </font>
		 <script>
		 setTimeout(function(){ document.location.href="GetUsers" }, 3000);
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
