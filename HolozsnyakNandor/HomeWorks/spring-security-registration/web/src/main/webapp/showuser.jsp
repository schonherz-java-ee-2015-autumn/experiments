<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/site.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resources/site.js"></script>
<title>Felhasználó információk</title>
</head>
<body>
	<div id="web_body">
		
			<%
				String id = (String) session.getAttribute("id");
				
				if (id != null ) {
			%>
		<jsp:include page="menu.jsp"></jsp:include>
		<jsp:include page="userinformation.jsp"></jsp:include>
			<%
				} else if (id == null) {
			%>
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="messageAfterReg">
				<font class="messageAfterReg" color="red" size="6"> Kérlek jelentkezz be! </font>
			</div>
			<%
				}
			%>
		</div>
</body>
</html>
