<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/registration.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<link href='http://fonts.googleapis.com/css?family=Roboto:400'
	rel='stylesheet' type='text/css'>
<script src="js/signInValidationRules.js"></script>
</head>
<body>
	<div class="tab">
		<h2>Sing in</h2>
		<form id="signInForm" action="CheckUserServlet" method="post">
			<input class="simple" type="text" id="userName" name="userName"
				placeholder="User name" value="papus89" required> <input
				class="simple" type="password" id="password" name="password"
				placeholder="Password" value="abcd" required>
			<button id="buttonSignIn">Submit</button>
		</form>
		<button class="href" onclick="window.location.href='signUp.jsp';">Sign
			up!</button>
	</div>
	<c:choose>
		<c:when test="${state == 'OK'}">
			<script>
				setTimeout(function() {
					document.location.href = "listAllUser.jsp"
				}, 2000);
			</script>
		</c:when>
		<c:otherwise>
			<c:out value="${state}!" />
		</c:otherwise>
	</c:choose>
</body>
</html>