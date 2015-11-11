package hu.schonherz.kepzes.java.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.ServiceException;
import hu.schonherz.kepzes.java.core.UserService;
import hu.schonherz.kepzes.java.web.Login.Response;

/**
 * Servlet implementation class GetUserInformation
 */
@WebServlet("/GetUserInformation")
public class GetUserInformation extends HttpServlet {
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
    public GetUserInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1 - userId:" +request.getParameter("userId"));
		Integer userId = Integer.valueOf(new String(request.getParameter("userId")));
		System.out.println("userId:"+ userId);
		
		String nextPage = "index.jsp";
		UserDTO user;
		HttpSession session = request.getSession();
		try {
			
			user = userService.getUserById(userId.intValue());
			if(user!= null) {
				System.out.println("User Visszaadva!");
				Gson json = new Gson();
				json.toJson(new Response(user), response.getWriter());
			} else {
				System.out.println("Nincs visszaadva!!");
			}
			
		} catch (ServiceException e) {
			session.setAttribute("state", "ERROR");
		}
	}
	
	class Response {
		UserDTO data;
		public Response(UserDTO data) {
			this.data = data;
		}
	}
}
