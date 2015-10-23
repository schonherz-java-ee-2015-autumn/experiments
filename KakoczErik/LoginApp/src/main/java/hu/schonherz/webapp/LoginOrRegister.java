package hu.schonherz.webapp;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginOrRegister
 */
public class LoginOrRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOrRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subType=request.getParameter("submit");
		String name = request.getParameter("usrnm");
		String pwd = request.getParameter("pswd");
		User usertologin = User.findUser(name);
		if(subType.equals("login")) 
			if((usertologin != null) && pwd.equals(usertologin.getPassword()))
				response.sendRedirect("Contentpage.jsp");
			else
				response.getWriter().write("Wrong login credentials");
		if(subType.equals("register"))
			response.sendRedirect("Register.jsp");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
