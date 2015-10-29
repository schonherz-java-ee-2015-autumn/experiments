<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
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
	background: rgb(226, 226, 226);
	font-family: cursive;
}

#regTable {
	border: 1px solid gray;
	border-radius: 10px;
	padding: 15px;
	margin: auto;
	width: 50%;
}

table {
	margin: auto;
}

thead td {
	text-align: center;
}

tfoot td {
	margin: auto;
	text-align: center;
}

h2 {
	text-align: center;
}

.warning {
	color: red;
	font-weight: bold;
}

label {
	display: inline-block;
	width: 10em;
}

.ui-tooltip {
	width: 25%;
}

#dialog-confirm {
	display: none;
}

#alreadyUser, #alreadyEmail {
	display: none;
	color: red;
}
.messageAfterReg {
	margin:auto;
	text-align: center;
}
</style>

<script>
	function validateDate(inputDate, inputDateFormat) {
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
			async : false
		});
		//alert("return");
		return reValue;
	}
	function checkUser(inputUser) {
		var reValue = 0;
		$.ajax({
			url : 'CheckUser',
			method : "POST",
			data : {
				userName : inputUser
			},
			success : function(data) {
				reValue = data;
			},
			error : function(data) {
				reValue = data;
			},
			dataType : "html",
			async : false
		});
		return reValue;
	}
	function checkEmail(inputEmail) {
		var reValue = 0;
		$.ajax({
			url : 'CheckEmail',
			method : "POST",
			data : {
				eMail : inputEmail
			},
			success : function(data) {
				reValue = data;
			},
			error : function(data) {
				reValue = data;
			},
			dataType : "html",
			async : false
		});
		return reValue;
	}

	function userChecker() {
		if (checkUser($("#user").val()) == "true") {
			//$("#user").attr("title","Ez a felhasz�l�n�v m�r l�tezik!");
			//$("#user").css("color","red");
			//$(".ui-helper-hidden-accessible").css("color","red");
			$("#alreadyUser").show();
		} else {
			//$("#user").attr("title","K�rlek add meg a felhaszn�l�neved");
			//$("#user").css( "color","black");
			//$(".ui-helper-hidden-accessible").css("color","black");
			$("#alreadyUser").hide();
		}
	}

	function eMailChecker() {
		if (checkEmail($("#e-mail").val()) == "true") {
			//$("#e-mail").attr("title","Ezzel az e-mail c�mmel m�r regisztr�ltak felhaszn�l�t!");
			//$("#e-mail").css("color","red");
			$("#alreadyEmail").show();
		} else {
			//$("#e-mail").attr("title","K�rlek add meg az e-mail c�med");
			//$("#e-mail").css( "color","black");
			$("#alreadyEmail").hide();
		}
	}

	$(function() {

		$("#dateId").datepicker();

		var places = [ "Ny�regyh�za", "Debrecen", "Budapest" ];
		$("#birthplace").autocomplete({
			source : places
		});

		$("#user").keyup(function(event) {
			userChecker();
		}).focus(function(event) {
			userChecker();
		}).focusout(function(event) {
			userChecker();
		});

		$("#e-mail").keyup(function(event) {
			eMailChecker();
		}).focus(function(event) {
			eMailChecker();
		}).focusout(function(event) {
			eMailChecker();
		});

		$("input[type=submit]").button();

		$("#toUsers").button();

		$("form").submit(function(event) {

			if (!$("#user").val() || checkUser($("#user").val()) == "true") {
				$("#userL").addClass("warning");
				event.preventDefault();
			}
			if (!$("#passw").val()) {

				$("#passwL").addClass("warning");
				event.preventDefault();
			}
			if (!$("#passwre").val()) {

				$("#passwreL").addClass("warning");
				event.preventDefault();
			}
			if (!$("#fulln").val()) {

				$("#fullnL").addClass("warning");
				event.preventDefault();
			}
			if (!validateEmail($("#e-mail").val())) {

				$("#emailL").addClass("warning");
				event.preventDefault();
			}

			var a = $("#passw").val();
			var b = $("#passwre").val();
			if (a != b) {

				$("#passwL").addClass("warning");
				$("#passwreL").addClass("warning");
				event.preventDefault();
			}

			var d = validateDate($("#dateId").val(), "MM/dd/yyyy");

			if (d != "true") {
				$('#dateIdL').addClass('warning');
				event.preventDefault();
			} else {
				$('#dateIdL').removeClass('warning');
			}

		});

		var tooltips = $("[title]").tooltip({
			position : {
				my : "left top",
				at : "right+5 top-5"
			}
		});

		function validateEmail(email) {
			var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			return re.test(email);
		}

	});
</script>
<title>Regisztr�ci�</title>
</head>
<body>
	<div id="regTable">
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
						<td><input placeholder="Felhaszn�l�n�v" type="text" id="user"
							name="Username" title="K�rlek add meg a felhaszn�l�neved">
						</td>
						<td><span id="alreadyUser">Ez a felhasz�l�n�v m�r foglalt!</span></td>
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
						<td><span id="alreadyEmail">Ezzel az e-mail c�mmel m�r
								regisztr�ltak!</span></td>
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
						<td colspan="2"><input type="submit" value="K�ld�s!"></td>
					</tr>
					<tr>
						<td colspan="2"><a href="userlist.jsp" id="toUsers">Felhaszn�l�k
								list�ja</a></td>
					</tr>
				</tfoot>
			</table>
		</form>
	
	<%
		String state = (String) request.getAttribute("state");
		if (state != null && state.equals("OK")) {
	%>
	<div class="messageAfterReg">
		<font color="green" size="26"> Sikeres regisztr�ci�! </font>
		<script>
			setTimeout(function() {
				document.location.href = "userlist.jsp"
			}, 2000);
		</script>
	</div>
	<%
		} else if (state != null) {
	%>
	<div class="messageAfterReg">
		<font class="messageAfterReg" color="red" size="26"> Hiba t�rt�nt a regisztr�ci�
			k�zben! </font>
	</div>
	<%
		}
	%>
</div>
</body>
</html>
