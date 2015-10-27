<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<form action="SubmitServlet" method="post">
		<input name="title">
		<input name="firstname">
		<input name="surname">
		<input name="email">
		<input type="text" id="datepicker">
		<input name="phonenumber">
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>
