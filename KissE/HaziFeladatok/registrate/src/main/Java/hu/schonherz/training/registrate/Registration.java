package hu.schonherz.training.registrate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Title = request.getParameter("Title");
		String UserName = request.getParameter("Username");
		String FullName = request.getParameter("Fullname");
		String Password = request.getParameter("Password");
		String DateOfBirth = request.getParameter("Date");
		String PlaceOfBirth = request.getParameter("PlaceOfBirth");
		String Email = request.getParameter("E-mail");
		String PhoneNumber = request.getParameter("PhoneNumber");
		try{
			Data.newUser(new RegData(Title, UserName, FullName, Password, DateOfBirth, PlaceOfBirth, Email, PhoneNumber));
			request.getSession().setAttribute("regUsers", Data.users);
			request.setAttribute("state", "OK");
			UsernameVerification.usernames.add(UserName);
		}catch(Exception e){
			request.setAttribute("state", "ERROR");
		}
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
