package hu.schonherz.kepzes.java.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regi.hazi.RegistrationUtil;
import regi.hazi.RegistrationUtilImpl;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		RegistrationUtilImpl registrationU = new RegistrationUtilImpl();
		boolean foundUser = registrationU.alreadyUser(userName);		
		if(foundUser == true) {
			response.getWriter().write("true");
			System.out.println("Van már ilyen user!");
		} else {
			response.getWriter().write("false");
			System.out.println("Nincs még ilyen user");
		}
		
	}

}
