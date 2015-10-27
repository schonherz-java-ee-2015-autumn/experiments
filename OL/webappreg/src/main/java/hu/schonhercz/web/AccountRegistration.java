package hu.schonhercz.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountRegistration
 */
@WebServlet("/AccountRegistration")
public class AccountRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegistration() {
        super();
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
		String userName = request.getParameter("Username");
		String passWord = request.getParameter("Password");
		String FullName = request.getParameter("Fullname");
		String eMail = request.getParameter("E-mail");
		String birthPlace = request.getParameter("Birth");
		String birthDate = request.getParameter("Date");
		System.out.println(userName + passWord + FullName + eMail + birthPlace + birthDate);
		try{
			new Account(userName,passWord,FullName,eMail,birthPlace,birthDate);
			request.getSession().setAttribute("userList",Account.getAccountDB());
			request.setAttribute("state", "OK");
		} catch(Exception e) {
			request.setAttribute("state", "ERROR");
		}
		
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
