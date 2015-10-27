<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<html>
<head>
<title>Facebook 2 - Register</title>
<%@ include file="header.jsp"%>
<script src="scripts/register.js"></script>
</head>
<body>

	<div id="container">
		<div id="topnav">
			<%@ include file="topnav.jsp"%>
		</div>
		<div id="content">
			<div id="result">
				<c:if test="${sessionScope.result != null }">
					<c:set var="colr" value="red" />
					<c:choose>
					<c:when test="${sessionScope.result.getResult() == 'SUCCESS' }">
						<c:set var="colr" value="green" />
						<font color = "${colr }">${sessionScope.result.getMessage() }</font>
						<script>
							setTimeout(function(){ window.location.replace("users.jsp"); }, 3000);
						</script>
					</c:when>
					
					<c:otherwise>
						<font color = "${colr }">${sessionScope.result.getMessage() }</font>
						<ul class="violationList">
							<c:forEach var="violation" items="${sessionScope.violations }">
								<li class="violationListElement">
								<font color = "${colr }">${violation.getError() }</font>
								</li>
							</c:forEach>
						</ul>
						<c:remove var="violations"/>
					</c:otherwise>
					</c:choose>
					
					
					<c:remove var="result"/>
				</c:if>
			</div>

			<tg:registerForm />

			<c:remove var="registerInfo"/>
		</div>
		<div id="footer">
			<%@include file="footer.jsp"%>
		</div>
	</div>

</body>
</html>
