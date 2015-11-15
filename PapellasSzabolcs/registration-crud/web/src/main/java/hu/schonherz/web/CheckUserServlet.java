package hu.schonherz.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import hu.schonherz.common.dto.UserDTO;
import hu.schonherz.common.service.ServiceException;
import hu.schonherz.common.service.UserService;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	private UserService service;
	private UserDTO user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext ctx = WebApplicationContextUtils.findWebApplicationContext(config.getServletContext());

		this.service = ctx.getBean("userService", UserService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			user = this.service.isUserExists(request.getParameter("userName"));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
		if (user != null) {
			if (bCryptPasswordEncoder.matches(request.getParameter("password"), user.getPassword())) {
				request.getSession().setAttribute("user", user);
				request.setAttribute("state", "OK");
			} else {
				request.setAttribute("state", "The password you’ve entered is incorrect!");
			}
		} else
			request.setAttribute("state", "The username you’ve entered doesn’t match any account!");
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
