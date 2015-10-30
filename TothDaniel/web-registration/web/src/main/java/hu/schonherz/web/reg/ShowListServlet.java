package hu.schonherz.web.reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.common.RegistrationUtil;
import org.common.User;
import org.core.ConnectionUtil;
import org.core.RegistrationUtilImpl;

/**
 * Servlet implementation class ShowListServlet
 */
@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegistrationUtil registrationUtil = new RegistrationUtilImpl(ConnectionUtil.getConnection());

		List<User> userList = new ArrayList<User>();

		userList = registrationUtil.getAllUser();

		if (userList != null) {
			for (User user : userList) {
				response.getWriter().append("<div>");
				response.getWriter().append(user.toString());
				response.getWriter().append("<div>");
				response.getWriter().append("<br>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// if (RegistrationServlet.users != null)
		// for (Entry<String, User> u : RegistrationServlet.users.entrySet()) {
		// response.getWriter().append("<div>");
		// response.getWriter().append(u.getValue().toString());
		// response.getWriter().append("<div>");
		// response.getWriter().append("<br>");
		// }

		RegistrationUtil registrationUtil = new RegistrationUtilImpl(ConnectionUtil.getConnection());

		List<User> userList = new ArrayList<User>();

		userList = registrationUtil.getAllUser();
		if (userList != null) {
			for (User user : userList) {
				response.getWriter().append("<div>");
				response.getWriter().append(user.toString());
				response.getWriter().append("<div>");
				response.getWriter().append("<br>");
			}
		}
	}

}
