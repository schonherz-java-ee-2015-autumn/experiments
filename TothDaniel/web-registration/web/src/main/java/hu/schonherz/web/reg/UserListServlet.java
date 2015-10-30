package hu.schonherz.web.reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.common.RegistrationUtil;
import org.common.User;
import org.core.ConnectionUtil;
import org.core.RegistrationUtilImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegistrationUtil registrationUtil = new RegistrationUtilImpl(ConnectionUtil.getConnection());

		List<User> userList = new ArrayList<User>();

		userList = registrationUtil.getAllUser();

		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		gson.toJson(new Response(userList), response.getWriter());
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
		private List<User> data;

		public Response(List<User> data) {
			super();
			this.data = data;
		}

		public List<User> getData() {
			return data;
		}

		public void setData(List<User> data) {
			this.data = data;
		}

	}

}
