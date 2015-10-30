package hu.schonherz.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.common.RegistrationUtil;
import hu.schonherz.common.User;
import hu.schonherz.web.core.RegistrationUtilImpl;
import hu.schonherz.web.core.validation.Validator;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    public static Map<String, User> users;
	private RegistrationUtil dbUtil;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
//        users = new HashMap<>();
        dbUtil = new RegistrationUtilImpl();
  
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
		Date date = new Date();
		
		if(userName==null || userName.isEmpty()){
			request.setAttribute("state", "FAILURE");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		
		if(password==null || password.isEmpty()){
			request.setAttribute("state", "FAILURE");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
			
		if(Validator.isValidDate(request.getParameter("birth"), Validator.DATEFORMAT)){
			SimpleDateFormat dateF = new SimpleDateFormat(Validator.DATEFORMAT);
			dateF.setLenient(false);
			try {
				date = dateF.parse(request.getParameter("birth"));
			} catch (ParseException e) {
				request.setAttribute("state", "FAILURE");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}	
		}else{
			request.setAttribute("state", "FAILURE");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		if(!Validator.isValidEmailAddress(email)){
			request.setAttribute("state", "FAILURE");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		
			
		
		if(dbUtil.findUserByName(userName)==null){
			
			dbUtil.saveUser(new User(userName, firstName, lastName, password, email, date));
			
		
			 request.setAttribute("state", "SUCCESS");
		}else{
			
			request.setAttribute("state", "FAILURE");	
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
