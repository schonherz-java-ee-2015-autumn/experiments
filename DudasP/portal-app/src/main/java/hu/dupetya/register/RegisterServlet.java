package hu.dupetya.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.training.java.solid.account.AccountRegistrationException;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.validator.ViolationException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountRegistrationRequest registerRequest = accountRegistrationRequestFromHTTPRequest(request);

		RegistrationFactory regFactory = new RegistrationFactory(this);

		try {
			regFactory.getAccountService().register(registerRequest);
		} catch (ViolationException e) {
			e.printStackTrace();
		} catch (AccountRegistrationException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/WebApp/");
	}

	protected AccountRegistrationRequest accountRegistrationRequestFromHTTPRequest(HttpServletRequest request) {
		AccountRegistrationRequest res = new AccountRegistrationRequest();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		res.setUsername(username);
		res.setPassword(password);
		res.setPasswordConfirmation(password);
		res.setEmail(email);

		return res;
	}

}
