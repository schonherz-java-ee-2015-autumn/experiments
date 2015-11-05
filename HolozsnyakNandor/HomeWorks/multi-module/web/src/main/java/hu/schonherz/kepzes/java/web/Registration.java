package hu.schonherz.kepzes.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.UserService;
import hu.schonherz.kepzes.java.core.UserServiceImpl;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		UserDTO user;
		String userName = request.getParameter("Username");
		String passWord = request.getParameter("Password");
		String FullName = request.getParameter("Fullname");
		String eMail = request.getParameter("E-mail");
		String birthPlace = request.getParameter("Birth");
		String birthDate = request.getParameter("Date");
		try{
			user = new UserDTO(userName,passWord,FullName,eMail,birthPlace,birthDate);
			service.saveUser(user);
			request.setAttribute("state", "OK");
		} catch(Exception e) {
			System.out.println("Exception in RegistrationServlet: " + e);
			request.setAttribute("state", "ERROR");
		}
		
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
