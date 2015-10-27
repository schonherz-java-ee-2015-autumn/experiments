package hu.schonherz.webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("usrnm");
		String password=request.getParameter("pwd");
		String password2=request.getParameter("pwdc");
		String email=request.getParameter("mail");
		String date=request.getParameter("date");
		String Friendname=request.getParameter("friend");
		
		boolean validun=UserValidator.isValidUsername(username);
		boolean validpwd=UserValidator.isValidPass(password, password2);
		boolean validmail = UserValidator.isValidEmail(email);
		boolean validdate = UserValidator.isValidDate(date);
		if( validun && validpwd && validmail && validdate) {
			if(Friendname!="")
				User.AddUser(new User(username,password,date,email,Friendname));
			else
				User.AddUser(new User(username,password,date,email));
			response.sendRedirect("index.jsp");
		}
			response.getWriter().write("unsuccesful registration\nusername: "+validun
					+"\npasswd: "+ validpwd +"\nmail: "+validmail+"\ndate: "+validdate);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
