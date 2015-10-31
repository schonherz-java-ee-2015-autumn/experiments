<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<div class="login-wrapper">
	<div class="login-content">
		<h3>Register</h3>
		<form method="post" action="RegistrationServlet">
			<label for="username"> Username: <input value="${sessionScope.registerInfo.getUsername() }" type="text"
				name="username" id="username" required="required" />
			</label> <label for="password"> Password: <input type="password"
				name="password" id="password" required="required" />
			</label> <label for="password2"> Password again: <input
				type="password" name="password2" id="password2" required="required" />
			</label> <label for="email"> E-mail: <input type="text" name="email"
				id="email" value="${sessionScope.registerInfo.getEmail()}" required="required"
				placeholder="name@organization.com"
				pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$" />
			</label>
			<label for="dob">DoB:
			<input type="text" name="dob" id="dob" value="${sessionScope.registerInfo.getDateOfBirth() }"/>
			</label>
			<button id = "submitButton" type="submit">Register</button>
		</form>
	</div>
</div>