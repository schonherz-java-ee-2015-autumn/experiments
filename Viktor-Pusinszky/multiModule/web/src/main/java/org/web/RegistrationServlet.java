package org.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.common.IRegistration;
import org.common.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
/**
 * Servlet implementation class RedirectWithAttribute
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IRegistration dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	public RegistrationServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name,password, email, date;	
		name = request.getParameter("user");
		password = request.getParameter("password");
		email = request.getParameter("email");
		date = request.getParameter("date");
		try{
			dao.saveRegistration(new UserDTO(name, password, email, date));
			request.setAttribute("state", "OK");
		}catch(Exception e) {
			request.setAttribute("state", "ERROR");
			System.out.println("NOs " + e.getMessage());
		}
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
