<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="result"></div>

	<ul>
		<li>
			<button type="button" onclick="getObjects()">getObjects</button>
		</li>

	</ul>
	<script>
		function getObjects() {
			$.ajax({
				method : "POST",
				url : 'GetUsers',
				success : function(data) {
					$("#result").html(JSON.stringify(data));

				},
				error : function(e) {

					console.log(e);

				},
				dataType : "json"
			});

		}
	</script>
</body>
</html>