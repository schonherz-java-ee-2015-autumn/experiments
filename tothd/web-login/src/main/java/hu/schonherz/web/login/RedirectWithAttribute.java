package hu.schonherz.web.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectWithAttribute
 */
@WebServlet("/RedirectWithAttribute")
public class RedirectWithAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Map<String, String> users = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectWithAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		users.put(username, password);

		// request.getSession().setAttribute("sessionName", username);
		// request.getSession().setAttribute("sessionPwd", password);

		request.getSession().setAttribute("users", users);

		response.sendRedirect("result.jsp");
	}

}
