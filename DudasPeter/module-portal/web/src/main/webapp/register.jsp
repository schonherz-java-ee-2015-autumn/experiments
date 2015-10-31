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
			<c:if test="${sessionScope.result != null }">
				<div id="result">

					<c:set var="colr" value="red" />
					<c:choose>
						<c:when test="${sessionScope.result.getResult() == 'SUCCESS' }">
							<c:set var="colr" value="green" />
							<font color="${colr }">${sessionScope.result.getMessage() }</font>
						</c:when>

						<c:otherwise>
							<font color="${colr }">${sessionScope.result.getMessage() }</font>
							<c:if test="${not sessionScope.result.getCauses().isEmpty() }">
								<ul class="violationList">
									<c:forEach var="violation" items="${sessionScope.result.getCauses() }">
										<li class="violationListElement">
										<font color="${colr }">
										<c:out value="${ violation }"></c:out>
										</font>
										</li>
									</c:forEach>
								</ul>
							</c:if>
							<c:remove var="violations" />
						</c:otherwise>
					</c:choose>


					<c:remove var="result" />

				</div>
			</c:if>

			<tg:registerForm />

			<c:remove var="registerInfo" />
		</div>
		<div id="footer">
			<%@include file="footer.jsp"%>
		</div>
	</div>

</body>
</html>
