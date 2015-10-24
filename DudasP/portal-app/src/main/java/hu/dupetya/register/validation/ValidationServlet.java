package hu.dupetya.register.validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.dupetya.dao.AccountContextDAO;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.account.impl.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.impl.AccountServiceImpl;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.account.validation.EmailFormatRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryEmailRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordConfirmationRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryUsernameRule;
import hu.schonherz.training.java.solid.account.validation.PasswordAndConfirmationAreEqualRule;
import hu.schonherz.training.java.solid.account.validation.PasswordFormatRule;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.impl.CipherServiceImpl;
import hu.schonherz.training.java.solid.converter.Converter;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.ViolationException;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountRegistrationRequest aRequest = accountRegRequestFromRequest(request);
		HttpSession session = request.getSession();

		session.setAttribute("registerInfo", aRequest);

		AccountDAO dao = new AccountContextDAO(getServletContext());
		List<String> usernames = getUserNames(dao);

		Validator<AccountRegistrationRequest> validator = new RuleValidator<>(
				Arrays.asList(new MandatoryEmailRule(), new MandatoryUsernameRule(), new MandatoryPasswordRule(),
						new MandatoryPasswordConfirmationRule(), new PasswordAndConfirmationAreEqualRule(),
						new EmailFormatRule(), new PasswordFormatRule(), new UniqueUserNameRule(usernames)));

		try {
			validator.validate(aRequest);

			String next = "RegistrationServlet";
			CipherService cipherService = new CipherServiceImpl("+d/Hd+CIMj/ochQmEcLGTg==", "WVyENBxRsmHQyYJWWahmfg==");
			Converter<AccountRegistrationRequest, Account> converter = new AccountRegistrationRequestToAccountConverter(
					cipherService);

			AccountService regService = new AccountServiceImpl(dao, converter);

			session.setAttribute("accountService", regService);

			request.getRequestDispatcher(next).forward(request, response);

		} catch (ViolationException e) {
			aRequest.setPassword("");
			aRequest.setPasswordConfirmation("");
			ProgressResult valRes = new ProgressResult();
			valRes.setResult(Result.FAIL);
			valRes.setMessage("Validation error");
			session.setAttribute("violations", e.getViolations());
			session.setAttribute("result", valRes);
			response.sendRedirect("register.jsp");
		}
	}

	private List<String> getUserNames(AccountDAO dao) {
		List<String> res = new ArrayList<>();

		for (Account account : dao.getAccounts()) {
			res.add(account.getUsername());
		}

		return res;
	}

	private AccountRegistrationRequest accountRegRequestFromRequest(HttpServletRequest request) {
		AccountRegistrationRequest res = new AccountRegistrationRequest();

		res.setEmail(request.getParameter("email"));
		res.setPassword(request.getParameter("password"));
		res.setPasswordConfirmation(request.getParameter("password2"));
		res.setUsername(request.getParameter("username"));

		return res;
	}

}
