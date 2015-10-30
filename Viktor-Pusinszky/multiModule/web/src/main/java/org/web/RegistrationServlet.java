package org.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.common.*;
import org.core.*;
/**
 * Servlet implementation class RedirectWithAttribute
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = null;
	
	public RegistrationServlet() {
		super();
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
		String name = request.getParameter("user");
		String password = request.getParameter("passwd");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		
		RegistrationUtilImpl regUtil = new RegistrationUtilImpl();
		try{
			regUtil.saveRegistration(new User(name, password, email, date));
			request.getSession().setAttribute("userList", regUtil.getAllUser());
			request.setAttribute("state", "OK");
		}catch(Exception e) {
			request.setAttribute("state", "ERROR");
		}
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
