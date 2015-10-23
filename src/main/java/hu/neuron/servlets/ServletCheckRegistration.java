package hu.neuron.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.data.RegisteredUsers;
import hu.neuron.data.User;

/**
 * Servlet implementation class ServletCheckRegistration
 */
@WebServlet("/ServletCheckRegistration")
public class ServletCheckRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<User> registeredUsers = new ArrayList<User>();
	RequestDispatcher reqDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCheckRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (checkIfUserExists(request.getParameter("email"))) {
			request.setAttribute("state", "ERROR");
			request.setAttribute("email", request.getParameter("email"));
		} else {
			request.setAttribute("state", "OK");
			saveUser(request);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

	protected void saveUser(HttpServletRequest request) {
		RegisteredUsers.addUser(new User(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("email"), request.getParameter("phone"), request.getParameter("location"),
				request.getParameter("password"), request.getParameter("gender").equals("1") ? "male" : "female",
				request.getParameter("day") + "-" + request.getParameter("month") + "-"
						+ request.getParameter("year")));
	}

	protected boolean checkIfUserExists(String email) {
		registeredUsers = RegisteredUsers.getUsers();

		boolean match = false;
		int index = 0;
		int size = registeredUsers.size();

		if (registeredUsers.size() > 0) {
			while (index < size && match == false) {
				if (registeredUsers.get(index).getEmail().matches(email))
					match = true;
				else
					index++;
			}
		}
		return match;

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
