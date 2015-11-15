package hu.schonherz.kepzes.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.UserService;

/**
 * Servlet implementation class Registration
 */
@Configurable
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO user;
		String userName = request.getParameter("Username");
		String passWord = request.getParameter("Password");
		String FullName = request.getParameter("Fullname");
		String eMail = request.getParameter("E-mail");
		String birthPlace = request.getParameter("Birth");
		String birthDate = request.getParameter("Date");
		Integer roleid = 1;
		
		try {
			
			if (!userService.checkUserByEmail(eMail) && !userService.checkUserByUserName(userName)) {
				user = new UserDTO(userName, passWord, FullName, eMail, birthPlace, birthDate,roleid);
				userService.saveUser(user);
				request.getSession().setAttribute("state", "OK");
			} else {
				request.getSession().setAttribute("state", "ALREADYUSER");
			}
		} catch (Exception e) {
			System.out.println("Exception in RegistrationServlet: " + e);
			request.getSession().setAttribute("state", "ERROR");
		}

		String nextPage = "/registration.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
