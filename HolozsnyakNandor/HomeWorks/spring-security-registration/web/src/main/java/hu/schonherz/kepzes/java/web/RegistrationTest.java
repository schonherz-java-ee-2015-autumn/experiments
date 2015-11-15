package hu.schonherz.kepzes.java.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.ServiceException;
import hu.schonherz.kepzes.java.core.UserService;
import hu.schonherz.kepzes.java.core.UserServiceImpl;

/**
 * Servlet implementation class RegistrationTest
 */
@WebServlet("/RegistrationTest")
public class RegistrationTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserService service = new UserServiceImpl();
		UserDTO user = new UserDTO("Nandi", "asd", "Lolka", "myemail@mail.com", "Bp", "1995/10/20",1);
		
		try {
			service.saveUser(user);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
