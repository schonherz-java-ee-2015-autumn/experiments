<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Portal</title>
<link rel="stylesheet" type="text/css" href="style/site.css" >
<link rel="stylesheet" type="text/css" href="style/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="style/jquery.dataTables.min.css">

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.js"></script>
<script type="text/javascript" src="scripts/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="scripts/site.js"></script>
</head>
<body>

	<div id="container">
	<c:import url="topnav.jsp" />
	<c:import url="content.jsp" />
	<c:import url="footer.jsp" />
	</div>

	<c:import url="register.jsp"/>
</body>
</html>
