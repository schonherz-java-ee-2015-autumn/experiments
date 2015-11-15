package hu.schonherz.kepzes.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.ServiceException;
import hu.schonherz.kepzes.java.core.UserService;
import hu.schonherz.kepzes.java.web.GetUsers.Response;

/**
 * Servlet implementation class Login
 */
@Configurable
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Autowired
    private UserService userService;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String userName = request.getParameter("Username");
		String password = request.getParameter("Password");
		String nextPage = "index.jsp";
		UserDTO user;
		HttpSession session = request.getSession();
		try {
			user = userService.loginUser(userName, password);
			if(user!= null) {
				session.setAttribute("state", "LOGGEDIN");
				session.setAttribute("id", request.getSession().getId());
				session.setAttribute("userId",user.getUserId().toString());
				nextPage = "showuser.jsp";
			} else {
				session.setAttribute("state", "NOTLOGGEDIN");
				nextPage = "index.jsp";
			}
		} catch (ServiceException e) {
			session.setAttribute("state", "ERROR");
		}finally {
			//RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			//rd.include(request, response);
			response.sendRedirect(nextPage);
		}
	}
	
	class Response {
		UserDTO data;
		public Response(UserDTO data) {
			this.data = data;
		}
	}
	
	

}
