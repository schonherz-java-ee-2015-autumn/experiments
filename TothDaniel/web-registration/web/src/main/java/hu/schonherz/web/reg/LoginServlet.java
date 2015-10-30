package hu.schonherz.web.reg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

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
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		// if(RegistrationServlet.users!=null && userName!=null &&
		// password!=null){
		// if(RegistrationServlet.users.containsKey(userName) &&
		// RegistrationServlet.users.get(userName).getPass().equals(password)){
		// response.sendRedirect("UserList.jsp");
		// }else{
		// request.setAttribute("state", "LOGIN_FAILURE");
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		// }
		// }else{
		// request.setAttribute("state", "LOGIN_FAILURE");
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		// }
	}

}
