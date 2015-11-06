<html>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	function validatecolor(clazz){
		$("tr"+clazz+"[violated=\"true\"]").animate({
			backgroundColor : "#fa0000"
		});
		$("tr"+clazz+"[violated=\"false\"]").animate({
			backgroundColor : "#00ff00"
		});
	}

	$(function() {

		$("#datepicker").datepicker({
			minDate : new Date(1900, 1 - 1, 1),
			maxDate : new Date()
		}, "option", "dateFormat", "yy-mm-dd");
		$("#datepicker").datepicker("option", "dateFormat", "mm-dd-yy");

		$("#dialog-message").dialog({
			modal : true,
			autoOpen : false
		});

		$("select").selectmenu();

		$("input, a, button").button()

		$("button#submitbutton").click(
				function() {
					$.ajax({
						url : "SubmitServlet",
						method : "POST",
						data : {
							"username" : $("input[name=\"username\"]").val().trim(),
							"title" : $(
									"select[name=\"title\"] option:selected")
									.text(),
							"firstname" : $("input[name=\"firstname\"]").val(),
							"lastname" : $("input[name=\"lastname\"]").val(),
							"password" : $("input[name=\"password\"]").val(),
							"confirmpassword" : $(
									"input[name=\"confirmpassword\"]").val(),
							"email" : $("input[name=\"email\"]").val(),
							"city" : $("input[name=\"city\"]").val(),
							"phonenumber" : $("input[name=\"phonenumber\"]")
									.val(),
							"dateofbirth" : $("input[name=\"dateofbirth\"]")
									.val(),
						},
						success : function(result) {
							console.log(JSON.stringify(result))

							$.each($("tr[violated]"), function(key, value) {
								$(value).attr("violated", "false")
							});

							if (result.length !== 0) {

								$.each(result, function(i, val) {

									$("." + val.error).attr("violated", "true")

								});

							} else {

								$("div#dialog-message").dialog('open')
								console.log("")

								setTimeout(function() {
									window.location.href = "RegistredUsers";
								}, 2000);

							}

							validatecolor("")

						},
						error : function(result) {
							console.log(result)
						},
						dataType : "json"
					});
				});

		$("input[name=\"username\"]").blur(function() {
			if ($("input[name=\"username\"]").val().trim() !== "") {
				$.ajax({
					url : "ValidatorServlet",
					method : "POST",
					data : {
						"username" : $("input[name=\"username\"]").val().trim()
					},
					success : function(result) {
						if (result === "ok") {
							$("tr.username").attr("violated", "false")
						} else {
							$("tr.username").attr("violated", "true")
						}
					},
					error : function(result) {
						console.log(result)
					},
					dataType : "text"
				});
			}
			validatecolor(".username")
		});

		$("input[name=\"confirmpassword\"], input[name=\"password\"]")
				.blur(
						function() {
							if ($("input[name=\"confirmpassword\"]").val()
									.trim() !== "") {
								if ($("input[name=\"password\"]").val().trim() === $(
										"input[name=\"confirmpassword\"]")
										.val().trim()) {
									$("tr.confirmpassword").attr("violated",
											"true")
								} else {
									$("tr.confirmpassword").attr("violated",
											"false")
								}
							} 
						});

		$("#datepicker").change(function() {
			if ($("#datepicker").val().trim() != "") {
				var date = new Date($("#datepicker").val().trim())
				if (date == "Invalid Date") {
					$("tr.dateofbirth").attr("violated", "true")
				} else {
					$("tr.dateofbirth").attr("violated", "false")
				}
			}
			validatecolor(".dateofbirth")
		});
		
		$.each($("tr[violated]>td[name]"),function(key,value){
			if ($(value).val().trim() == ""){
				$(this + ":parent").attr("violated","none")
			}
		});
		

	});
</script>
<jsp:include page="includeStyle.jsp"></jsp:include>

<title>Registration</title>
</head>
<body>
	<form action="RegistrationServlet" method="post">
		<table class="formtable" align="center">
			<thead>
				<tr>
					<th colspan="3">Registration</th>
				</tr>
			</thead>
			<tbody>
				<tr class="title" violated="false">
					<td>Title:</td>
					<td><select name="title">
							<option>Mr.</option>
							<option>Mrs.</option>
							<option>Miss</option>
					</select>
				</tr>
				<tr class="firstname" violated="false">
					<td>First name:</td>
					<td><input name="firstname" placeholder="First name"></td>

				</tr>
				<tr class="lastname" violated="false">
					<td>Last name:</td>
					<td><input name="lastname" placeholder="Last name"></td>

				</tr>
				<tr class="username" violated="false">
					<td>Username:</td>
					<td><input name="username" placeholder="Username"></td>

				</tr>
				<tr class="password" violated="false">
					<td>Password:</td>
					<td><input type="password" name="password"
						placeholder="Password"></td>

				</tr>
				<tr class="confirmpassword" violated="false">
					<td>Confirm password:</td>
					<td><input type="password" name="confirmpassword"
						placeholder="Confrim Password"></td>

				</tr violated="false">

				<tr class="email" violated="false">
					<td>Email:</td>
					<td><input name="email" placeholder="Email"></td>

				</tr>
				<tr class="phonenumber" violated="false">
					<td>Phone number:</td>
					<td><input name="phonenumber" placeholder="Phone number"></td>

				</tr>
				<tr class="dateofbirth" violated="false">
					<td>Date of birth:</td>
					<td><input id="datepicker" name="dateofbirth"
						placeholder="MM-DD-YYYY"></td>

				</tr>
				<tr class="city" violated="false">
					<td>Location:</td>
					<td><input name="city" placeholder="Location"></td>

				</tr>
				<tr>
					<td colspan="2">
						<button id="submitbutton" type="button">Submit</button>
					</td>
			</tbody>
		</table>
	</form>


	<div class="result">
		<div id="registrationresult">
			<div id="dialog-message" title="Registration successful.">
				<img src="tick.png">
			</div>
		</div>
	</div>
</body>
</html>
