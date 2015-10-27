package hu.training.schonherz.webform;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.training.validation.Violation;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.webform.core.PersonRegister;
import hu.schonherz.training.webform.core.PersonRegistrationRequest;
import hu.schonherz.training.webform.core.PersonRegistrationRequestBuilder;
import hu.schonherz.training.webform.core.PersonRegistrationRequestToPersonConverter;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PersonRegistrationRequestBuilder builder = new PersonRegistrationRequestBuilder();

		PersonRegistrationRequest registrationRequest = builder.setUserName((String) request.getParameter("username"))
				.setPassword((String) request.getParameter("password")).setTitle((String) request.getParameter("title"))
				.setPasswordConfirmation((String) request.getParameter("passwordconfirmation"))
				.setFirstName((String) request.getParameter("firstname")).setLastName(request.getParameter("lastname"))
				.setDateOfBirth((String) request.getParameter("dateofbirth"))
				.setEmail((String) request.getParameter("email"))
				.setPhoneNumber((String) request.getParameter("phonenumber"))
				.setPasswordConfirmation((String) request.getParameter("confirmpassword"))
				.setCity((String) request.getParameter("city")).build();

		PersonRegistrationRequestToPersonConverter converter = new PersonRegistrationRequestToPersonConverter(
				registrationRequest);
		Gson gson = new Gson();
		try {
			PersonRegister.register(converter.convert());
			gson.toJson(Collections.<Violation> emptyList(), response.getWriter());
		} catch (ViolationException e) {
			gson.toJson(e.getViolations(), response.getWriter());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
