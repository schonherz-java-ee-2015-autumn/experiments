package hu.dupetya.web.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.dupetya.dao.AccountContextDAO;
import hu.dupetya.register.validation.ProgressResult;
import hu.dupetya.register.validation.Result;
import hu.dupetya.register.validation.UniqueUserNameRule;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.ViolationException;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;

/**
 * Servlet implementation class CheckUserNameAjax
 */
@WebServlet("/CheckUserNameAjax")
public class CheckUserNameAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserNameAjax() {
		super();
		// TODO Auto-generated constructor stub
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
		List<String> usernames = new ArrayList<>();
		AccountDAO dao = new AccountContextDAO(getServletContext());
		for (Account acc : dao.getAccounts()) {
			usernames.add(acc.getUsername());
		}

		Validator<AccountRegistrationRequest> validator = new RuleValidator<>(
				Arrays.asList(new UniqueUserNameRule(usernames)));

		AccountRegistrationRequest aRequest = new AccountRegistrationRequest();
		aRequest.setUsername(request.getParameter("username"));
		Gson gson = new Gson();
		ProgressResult result = new ProgressResult();
		result.setResult(Result.SUCCESS);
		try {
			validator.validate(aRequest);
		} catch (ViolationException e) {
			result.setResult(Result.FAIL);
			result.setMessage("Usernam already exists");
		} finally {
			gson.toJson(result, response.getWriter());
		}
	}

}
