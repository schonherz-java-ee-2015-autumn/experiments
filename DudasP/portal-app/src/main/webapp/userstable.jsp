<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="table-wrapper">
	<table class="usertable">
		<thead>
			<tr>
				<th>Name</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${applicationScope.users}">
				<tr>
					<td><c:out value="${user.getUsername()}" />
					<td><c:out value="${user.getEmail()}" />
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>