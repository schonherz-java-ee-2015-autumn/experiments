package hu.schonherz.kepzes.java.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.schonherz.kepzes.java.core.ServiceException;
import hu.schonherz.kepzes.java.core.UserService;

/**
 * Servlet implementation class CheckUser
 */
@Configurable
@WebServlet("/CheckEmail")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
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
		String eMail = request.getParameter("eMail");
		boolean alreadyeMail;
		try {
			alreadyeMail = userService.checkUserByEmail(eMail);
			if(alreadyeMail == true) {
				response.getWriter().write("true");
			} else {
				response.getWriter().write("false");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		/*	
		if(foundUser == true) {
			response.getWriter().write("true");
		} else {
			response.getWriter().write("false");
		}*/
		
	}

}
