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

import com.mysql.jdbc.UpdatableResultSet;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.ServiceException;
import hu.schonherz.kepzes.java.core.UserService;

/**
 * Servlet implementation class ModUser
 */
@Configurable
@WebServlet("/ModUser")
public class ModUser extends HttpServlet {
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
	public ModUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDTO updatableUser = new UserDTO();
		String userName = request.getParameter("Username");
		String FullName = request.getParameter("Fullname");
		String eMail = request.getParameter("E-mail");
		String birthPlace = request.getParameter("Birth");
		String birthDate = request.getParameter("Date");
		Integer userId = Integer.valueOf(new String(request.getParameter("userId")));
		String nextPage = "showuser.jsp";
		updatableUser.setUserName(userName);
		updatableUser.setFullName(FullName);
		updatableUser.seteMail(eMail);
		updatableUser.setBirthPlace(birthPlace);
		updatableUser.setBirthDate(birthDate);
		updatableUser.setUserId(userId);
		
		try {
			System.out.println("Trying to mod user:" + updatableUser.toString());
			userService.updateUser(updatableUser);
			
		} catch (ServiceException e) {
			System.out.println("Error while modding user!");
		}finally{
			response.sendRedirect(nextPage);
		}

	}

}
