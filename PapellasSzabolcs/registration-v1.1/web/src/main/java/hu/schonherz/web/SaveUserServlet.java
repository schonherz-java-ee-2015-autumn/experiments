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
 * Servlet implementation class SaveUserServlet
 */
@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveUserServlet() {
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

			boolean userNameExists = this.service.checkUserByName(request.getParameter("userName"));
			boolean userMailExists = this.service.checkUserByMail(request.getParameter("email"));

			if (userNameExists)
				request.setAttribute("state", "The username you have entered is already registered!");
			else if (userMailExists) {
				request.setAttribute("state", "The email address you have entered is already registered!");
			} else {
				saveUser(request);
				request.setAttribute("state", "OK");
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String nextPage = "/signUp.jsp";
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

	protected Long saveUser(HttpServletRequest request) {

		UserDTO newUser = new UserDTO();
		newUser.setUserName(request.getParameter("userName"));
		newUser.setFirstName(request.getParameter("firstName"));
		newUser.setLastName(request.getParameter("lastName"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPhone(request.getParameter("phone"));
		newUser.setLocation(request.getParameter("location"));
		System.out.println("Saved password = " + bCryptPasswordEncoder.encode(request.getParameter("password")));
		newUser.setPassword(bCryptPasswordEncoder.encode(request.getParameter("password")));
		newUser.setGender(request.getParameter("gender"));
		newUser.setBirthday(
				request.getParameter("day") + "-" + request.getParameter("month") + "-" + request.getParameter("year"));

		Long savedId = -1L;
		try {
			savedId = this.service.saveUser(newUser);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return savedId;
	}

}
