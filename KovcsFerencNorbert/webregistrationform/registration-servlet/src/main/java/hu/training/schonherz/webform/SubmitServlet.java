package hu.training.schonherz.webform;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.person.BeanParser;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.registration.PersonRegistrationRequestFactory;
import hu.schonherz.training.usermanager.UserManager;
import hu.schonherz.training.usermanager.UserProvider;

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

		PersonRegistrationRequestFactory factory = new PersonRegistrationRequestFactory(
				new BeanParser<PersonRegistrationRequest>() {

					@Override
					public PersonRegistrationRequest parse() {
						PersonRegistrationRequest registrationRequest = new PersonRegistrationRequest();
						registrationRequest.setCity(request.getParameter("city"));
						registrationRequest.setPasswordConfirmation(request.getParameter("confirmpassword"));
						registrationRequest.setEmail(request.getParameter("email"));
						registrationRequest.setPhoneNumber(request.getParameter("phonenumber"));
						registrationRequest.setTitle(request.getParameter("title"));
						registrationRequest.setFirstName(request.getParameter("firstname"));
						registrationRequest.setLastName(request.getParameter("lastname"));
						registrationRequest.setPassword(request.getParameter("password"));
						registrationRequest.setDateOfBirth(request.getParameter("dateofbirth"));
						registrationRequest.setUserName(request.getParameter("username"));

						return registrationRequest;
					}
				});

		Gson gson = new Gson();
		try {
			UserProvider manager = new UserManager();
			manager.registratePerson(factory.getInstance());
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
