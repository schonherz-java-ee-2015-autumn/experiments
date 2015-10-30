<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="style.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style>
.warning {
	border-color: red;
}
</style>
<script>
$(document).ready(function(){
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

	$(function() {
		$("#date").datepicker();

		$("input[type=submit]").button();
		$("#toUsers").button();

		$("form").submit(
				function(event) {
					if (!$("#userName").val()) {
						$("#userName").addClass("warning");
						$("#userName").attr("placeholder",
								"Please type Your correct Username");
						event.preventDefault();

					}
					if (!$("#fullName").val()) {
						$("#fullName").addClass("warning");
						$("#fullName").attr("placeholder",
								"Please type Your Fullname")
						event.preventDefault();
					}
					if (!$("#password").val()) {
						$("#password").addClass("warning");
						$("#password").attr("placeholder",
								"Please type Your password")
						event.preventDefault();
					}
					if (!$("#passwordVer").val()) {
						$("#passwordVer").addClass("warning");
						$("#passwordVer").attr("placeholder",
								"Please repeat your password")
						event.preventDefault();
					}
					var a = $("#password").val();
					var b = $("#passwordVer").val();

					if (a != b) {
						$("#passwordVer").addClass("warning");
						$("#password").addClass("warning");
						$("#password").attr("placeholder",
								"the two passwords are not equals");
						$("#passwordVer").attr("placeholder",
								"the two passwords are not equals");
						event.preventDefault();
					}

					if (!$("#placeOfBirth").val()) {
						$("#placeOfBirth").addClass("warning");
						$("#placeOfBirth").attr("placeholder",
								"Please type Your Place Of Birth");
						event.preventDefault();
					}
					if (!$("#Email").val()) {
						$("#Email").addClass("warning");
						$("#Email").attr("placeholder",
								"Please type Your e-mail address")
						event.preventDefault();
					}
					if (!$("#PhoneNumber").val()) {
						$("#PhoneNumber").addClass("warning");
						$("#PhoneNumber").attr("placeholder",
								"Please type Your phone number");
						event.preventDefault();
					}

					if (!$("#date").val()) {
						$("#date").addClass("warning");
						$("#date").attr("placeholder",
								"Please type Your date of birth");
						event.preventDefault();
					}
					
					

					var c = validateDate($("#date").val(), "MM/dd/YYYY");
						console.log(c);
					if (c != "true") {
						$("#date").addClass("warning");

						event.preventDefault();

					} else {
						$("#date").removeClass("warning");
					}
				});
		$("#userName").blur(function() {

			var isUserExists = "";
			$.ajax({
				url : 'UserNameValidator',
				method : "POST",
				data : {
					message : $("#userName").val()
				},
				success : function(data) {
					isUserExists = data;
					console.log(data);
				},
				dataType : "text",
				async :false
			});
			
			if (isUserExists == "true") {
				
				$("#userName").addClass("warning");
				$("#userName").val("");
				$("#userName").attr("placeholder", "This username exists");

			}else {if($("#userName.warning"))
				$("#userName").removeClass("warning");}

		});
	});
});
</script>
<title>Registration</title>
</head>

<body>

	<form action="Registration" method="post">
		<table id="uTable">
			<thead id="uTableHead">
				<tr>
					<td colspan=2>Registration</td>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label for="title">Title</label></td>
					<td><select id="title" name="Title"
						class="ui-selectmenu-button ui-widget ui-state-default ui-corner-all">
							<option value="Mr.">Mr.</option>
							<option value="Mrs.">Mrs.</option>
							<option value="Miss">Miss</option>
							<option value="Dr.">Dr</option>

					</select></td>
				</tr>
				<tr>
					<td><label for="userName">Username</label></td>
					<td><input type="text" id="userName" name="Username"
						placeholder="Please type your Username"></td>
				</tr>
				<tr>
					<td><label for="fullName">Full Name</label></td>
					<td><input type="text" id="fullName" name="Fullname"
						placeholder="Please type your fullrname"></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" id="password" name="Password"
						placeholder="Please type your password"></td>

				</tr>
				<tr>
					<td><label for="passwordVer">Verify Your Password</label></td>
					<td><input type="password" id="passwordVer" name="PasswordVer"
						placeholder="Please type your password again"></td>

				</tr>
				<tr>
					<td><label for="date">Date Of Birth</label></td>
					<td><input type="text" id="date" name="Date"
						placeholder="Please select your date Of birth"></td>

				</tr>
				<tr>
					<td><label for="placeOfBirth">Place Of Birth</label></td>
					<td><input type="text" id="placeOfBirth" name=PlaceOfBirth
						placeholder="Please enter your place Of birth"></td>
				</tr>
				<tr>
					<td><label for="Email">Email Address</label></td>
					<td><input type="text" id="Email" name="E-mail"
						placeholder="Please enter your email address"></td>
				</tr>
				<tr>
					<td><label for="PhoneNumber">Phone Number</label></td>
					<td><input type="text" id="PhoneNumber" name="PhoneNumber"
						placeholder="Please select your phone number"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td><input id="subbut" type="submit"
						class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"></td>
					<td><a id="toUsers" href="GetUsres"
						class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only">Rgistered
							Users</a></td>

				</tr>

			</tfoot>
		</table>
	</form>

	<%
		String state = (String) request.getAttribute("state");
		if (state != null && state.equals("OK")) {
	%>
	<div>
		<h3 id = "font"> Succcess!!! Your registration is
			complete </h3>
		 		<script> 
		 setTimeout(function() { document.location.href = "GetUsres" 
		}, 1000);
		 		</script>
	</div>
	<%
		} else if (state != null) {
	%>
	<div>
		<font color="red" size=26>Error!!! Your registration is failed
		</font>

	</div>
	<%
		}
	%>

</body>
</html>
