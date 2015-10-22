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
$(function() {
    $( "#date" ).datepicker();
    
    var places = [ "Ny�regyh�za","Debrecen","Budapest" ];
    $( "#birthplace" ).autocomplete({
      source: places
    });
    
    $( "input[type=submit]" ).button();
    $( "#toUsers" ).button();
    $( "form" ).submit(function( event ) {
    	
    	  if(!$("#user").val()) {
    		  alert("A felhaszn�lonev mezo kitoltese kotelezo!");
    		  $("#userL").addClass("warning");
    	  	  event.preventDefault();
    	  }    	  
    	  if(!$("#passw").val()) {
    		  alert("A jelszo mezo kitoltese kotelezo!");
    		  $("#passwL").addClass("warning");
    	  	  event.preventDefault();
    	  }
    	  if(!$("#fulln").val()) {
    		  alert("A teljes nev mezo kitoltese kotelezo!");
    		  $("#fullnL").addClass("warning");
    	  	  event.preventDefault();
    	  }
    	  if(!$("#e-mail").val()) {
    		  alert("Az email mezo kitoltese kotelezo!");
    		  $("#emailL").addClass("warning");
    	  	  event.preventDefault();
    	  }
    	 
    	});
    
    var tooltips = $( "[title]" ).tooltip({
        position: {
          my: "left top",
          at: "right+5 top-5"
        }
      });
    
});
</script>
<title>Regisztr�ci�</title>
</head>
<body>
	<form method="post" action="Registration">
		<table>
			<thead>
				<tr>
					<td colspan="2"><h3>Regiszt�ci�</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label for="user" id="userL">Felhaszn�l�n�v:</label></td>
					<td><input type="text" id="user" name="Username" title="K�rlek add meg a felhaszn�l�neved"></td>
				</tr>
				<tr>
					<td><label for="passw" id="passwL">Jelsz�:</label></td>
					<td><input type="password" id="passw" name="Password" title="K�rlek add meg a jelszavad"></td>
				</tr>
				<tr>
					<td><label for="fulln" id="fullnL">Teljes n�v:</label></td>
					<td><input type="text" id="fulln" name="Fullname" title="K�rlek add meg a teljes neved"></td>
				</tr>
				<tr>
					<td><label for="e-mail" id="emailL">E-mail:</label></td>
					<td><input type="text" id="e-mail" name="E-mail" title="K�rlek add meg az e-mail c�med"></td>
				</tr>
				<tr>
					<td><label for="date">Sz�let�si d�tum:</label></td>
					<td><input type="text" id="date" name="Date" title="K�rlek add meg a sz�let�si d�tumod"></td>
				</tr>
				<tr>
					<td><label for="birthplace">Sz�let�si hely:</label></td>
					<td><input type="text" id="birthplace" name="Birth" title="K�rlek add meg a sz�let�si helyed"></td>
				</tr>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="K�ld�s!"></td>
				</tr>
				<tr>
					<td colspan="2"><a href="GetUsers" id="toUsers">Felhaszn�l�k list�ja</a></td>	
				</tr>
			</tfoot>
		</table>
	</form>
	
</body>
</html>
