package hu.schonherz.web.reg;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.web.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static Map<String, User> users;
    private String mutex = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        users = new HashMap<>();
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		Date date = new Date(request.getParameter("birth"));
		if(userName.isEmpty() || password.isEmpty())
			response.sendRedirect("index.jsp");
		
		if(!users.containsKey(userName)){
			 synchronized (mutex){
			users.put(userName, new User(userName, firstName, lastName, password, email, date));
			
			 }
			 request.setAttribute("state", "SUCCESS");
		}else{
			
			request.setAttribute("state", "FAILURE");	
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
