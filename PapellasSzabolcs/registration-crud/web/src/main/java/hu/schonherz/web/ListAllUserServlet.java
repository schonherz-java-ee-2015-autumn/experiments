package hu.schonherz.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import hu.schonherz.common.dto.UserDTO;
import hu.schonherz.common.service.ServiceException;
import hu.schonherz.common.service.UserService;

/**
 * Servlet implementation class ListAllUserServlet
 */
@WebServlet("/ListAllUserServlet")
public class ListAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext ctx = WebApplicationContextUtils.findWebApplicationContext(config.getServletContext());

		this.service = ctx.getBean("userService", UserService.class);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAllUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<UserDTO> users = null;
		try {
			users = this.service.getAllUser();

		} catch (ServiceException e) {
			// response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		Gson gson = new Gson();

		response.setContentType("application/json");
		// response.setCharacterEncoding("UTF-8");
		// response.getWriter().write(gson.toJson(users));
		response.setCharacterEncoding("UTF-8");
		// Gson gson = new Gson();
		gson.toJson(new Response(users), response.getWriter());
		// gson.toJson(new Response(users), response.getWriter());
		// request.getSession().setAttribute("users", users);
		// request.getRequestDispatcher("listAllUser.jsp").forward(request,
		// response);
		// request.setAttribute("users", gson.toJson(users));
		// response.sendRedirect("listAllUser.jsp");

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

	public static class Response {
		private List<UserDTO> data;

		public Response(List<UserDTO> data) {
			super();
			this.data = data;
		}

		public List<UserDTO> getData() {
			return data;
		}

		public void setData(List<UserDTO> data) {
			this.data = data;
		}

	}
}
