package hu.dupetya.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.dupetya.register.validation.ProgressResult;
import hu.dupetya.register.validation.Result;
import hu.schonherz.training.java.solid.account.AccountRegistrationException;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		HttpSession session = request.getSession();
		AccountService regService = (AccountService) session.getAttribute("accountService");
		ProgressResult regRes = new ProgressResult();
		regRes.setResult(Result.SUCCESS);
		regRes.setMessage("Successfully registered");
		session.setAttribute("result", regRes);
		try {
			regService.register((AccountRegistrationRequest) session.getAttribute("registerInfo"));
		} catch (AccountRegistrationException e) {

			regRes.setResult(Result.FAIL);
			regRes.setMessage(e.getMessage());
		} finally {
			session.removeAttribute("registerInfo");
			response.sendRedirect("register.jsp");
		}
	}

}
