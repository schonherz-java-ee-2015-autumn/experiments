package hu.schonherz.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authentication.Authentication;
import hu.schonherz.common.UserManager;
import hu.schonherz.common.User;
import hu.schonherz.web.core.UserManagerImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager dbUtil;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		dbUtil = new UserManagerImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("pass");

		if (Authentication.isSuccessfulAuthentication(username, password)) {
			response.sendRedirect("UserList.jsp");
		} else {
			request.setAttribute("state", "LOGIN_FAILURE");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		// if (username != null && password != null) {
		// User user = dbUtil.findUserByName(username);
		// if (user != null && user.getPass().equals(password)) {
		// response.sendRedirect("UserList.jsp");
		// } else {
		// request.setAttribute("state", "LOGIN_FAILURE");
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		// }
		//
		// } else {
		// request.setAttribute("state", "LOGIN_FAILURE");
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		// }

	}

}
