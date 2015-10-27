package hu.register.form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		String userName = request.getParameter("Username");
		String passWord = request.getParameter("Password");
		String FullName = request.getParameter("Fullname");
		String eMail = request.getParameter("E-mail");
		String birthPlace = request.getParameter("Birth");
		String birthDate = request.getParameter("Date");
		try{
			Data.newUser(new RegisterData(userName,passWord,FullName,eMail,birthPlace,birthDate));
			request.getSession().setAttribute("userList",Data.users);
			request.setAttribute("state", "OK");
		} catch(Exception e) {
			request.setAttribute("state", "ERROR");
		}
		
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
