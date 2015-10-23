<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="content">
	<h1>Users</h1>
	<c:if test="${not empty applicationScope.users}">
		<%@ include file="userstable.jsp" %>
	</c:if>
</div>