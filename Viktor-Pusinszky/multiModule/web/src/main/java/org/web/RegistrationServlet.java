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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Servlet implementation class RedirectWithAttribute
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("spring.xml");
		RegistrationImpl dao = ctx.getBean("registrationImpl", RegistrationImpl.class);
		
		name = request.getParameter("user");
		password = request.getParameter("password");
		email = request.getParameter("email");
		date = request.getParameter("date");
		try{
			dao.saveRegistration(new UserDAO(name, password, email, date));
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
