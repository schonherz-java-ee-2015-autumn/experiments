<html>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {

		$("#datepicker").datepicker({
			minDate : new Date(1900, 1 - 1, 1),
			maxDate : new Date()
		}, "option", "dateFormat", "yy-mm-dd");
		$("#datepicker").datepicker("option", "dateFormat", "mm-dd-yy");

		$("select").selectmenu();

		$("input, a, button").button()

		$("button#submitbutton").click(
				function() {
					$.ajax({
						url : "SubmitServlet",
						method : "POST",
						data : {
							"username" : $("input[name=\"username\"]").val(),
							"title" : $(
									"select[name=\"title\"] option:selected")
									.text(),
							"firstname" : $("input[name=\"firstname\"]").val(),
							"lastname" : $("input[name=\"lastname\"]").val(),
							"password" : $("input[name=\"password\"]").val(),
							"confirmpassword" : $(
									"input[name=\"confirmpassword\"]").val(),
							"email" : $("input[name=\"email\"]").val(),
							"phonenumber" : $("input[name=\"phonenumber\"]")
									.val(),
							"dateofbirth" : $("input[name=\"dateofbirth\"]")
									.val(),
						},
						success : function(result) {
							console.log(JSON.stringify(result))

							if (result.length !== 0) {
								$.each($("td[violated]"), function(key, value) {
									$(value).attr("violated", "false")
								});

								$.each(result, function(i, val) {

									//	 								console.log($(val.error).parent())
									$("." + val.error).attr("violated", "true")

								});
							} else {

								setTimeout(function() {
									window.location.href = "RegistredUsers";
								}, 2000);

								$("#dialog-message").dialog({
									modal : true
								});
							}

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
						"username" : $("input[name=\"username\"]").val()
					},
					success : function(result) {
						if (result === "ok") {
							$("#usercheck").attr("status", "valid")
							$("#usercheck").html("&#10004;")
						} else {
							$("#usercheck").attr("status", "invalid")
							$("#usercheck").html("&#10008;")
						}
					},
					error : function(result) {
						console.log(result)
					},
					dataType : "text"
				});
			} else {
				$("#usercheck").attr("status", "none")
				$("#usercheck").html("")
			}
		});

		$("input[name=\"confirmpassword\"], input[name=\"password\"]")
				.blur(
						function() {
							if ($("input[name=\"confirmpassword\"]").val()
									.trim() !== "") {
								if ($("input[name=\"password\"]").val().trim() === $(
										"input[name=\"confirmpassword\"]")
										.val().trim()) {
									$("td#passwordcheck").attr("status",
											"valid")
									$("td#passwordcheck").html("&#10004;")
								} else {
									$("td#passwordcheck").attr("status",
											"invalid")
									$("td#passwordcheck").html("&#10008;")
								}
							} else {
								$("td#passwordcheck").attr("status", "none")
								$("td#passwordcheck").html("")
							}
						});

		$("#datepicker").change(function() {
			if ($("#datepicker").val().trim() != "") {
				var date = new Date($("#datepicker").val().trim())
				if (date != "Invalid Date") {
					$("td#datecheck").attr("status", "valid")
					$("td#datecheck").html("&#10004;")
				} else {
					$("td#datecheck").attr("status", "invalid")
					$("td#datecheck").html("&#10008;")
				}
			} else {
				$("td#datecheck").attr("status", "none")
				$("td#datecheck").html("")
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
			<tbody>
				<tr class="title" violated="false">
					<td>Title:</td>
					<td><select name="title">
							<option>Mr.</option>
							<option>Mrs.</option>
							<option>Miss</option>
					</select>
					<td />
				</tr>
				<tr class="firstname" violated="false">
					<td>First name:</td>
					<td><input name="firstname" placeholder="First name"></td>
					<td />
				</tr>
				<tr class="lastname" violated="false">
					<td>Last name:</td>
					<td><input name="lastname" placeholder="Last name"></td>
					<td />
				</tr>
				<tr class="username" violated="false">
					<td>Username:</td>
					<td><input name="username" placeholder="Username"></td>
					<td id="usercheck" class="result" status="none"></td>
				</tr>
				<tr class="password" violated="false">
					<td>Password:</td>
					<td><input type="password" name="password"
						placeholder="Password"></td>
					<td />
				</tr>
				<tr class="confirmpassword" violated="false">
					<td>Confirm password:</td>
					<td><input type="password" name="confirmpassword"
						placeholder="Confrim Password"></td>
					<td id="passwordcheck" class="result" status="none"></td>
				</tr violated="false">

				<tr class="email" violated="false">
					<td>Email:</td>
					<td><input name="email" placeholder="Email"></td>
					<td />
				</tr>
				<tr class="phonenumber" violated="false">
					<td>Phone number:</td>
					<td><input name="phonenumber" placeholder="Phone number"></td>
					<td />
				</tr>
				<tr class="dateofbirth" violated="false">
					<td>Date of birth:</td>
					<td><input id="datepicker" name="dateofbirth"
						placeholder="MM-DD-YYYY"></td>
					<td id="datecheck" class="result" status="none"></td>
				</tr>
				<tr class="city" violated="false">
					<td>Location:</td>
					<td><input name="city" placeholder="Location"></td>
					<td />
				</tr>
				<tr>
					<td colspan="2">
						<button id="submitbutton" type="button">Submit</button>
					</td>
			</tbody>
		</table>
	</form>

	<div id="registrationresult">
		<div id="dialog-message" title="Registration successful.">
			<center>
				<img src="tick.png">
			</center>
		</div>
	</div>
</body>
</html>
