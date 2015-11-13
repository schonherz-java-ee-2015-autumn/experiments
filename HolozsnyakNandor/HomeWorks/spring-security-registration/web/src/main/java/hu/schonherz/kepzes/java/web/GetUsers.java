package hu.schonherz.kepzes.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.core.ServiceException;
import hu.schonherz.kepzes.java.core.dao.UserDAOImpl;
import hu.schonherz.kepzes.java.core.UserService;

/**
 * Servlet implementation class GetUsers
 */
@Configurable
@WebServlet("/GetUsers")
public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	

	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RegistrationUtilImpl userListClass = new RegistrationUtilImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext("/datasource-with-transaction.xml",
				UserDAOImpl.class);
		String Mennyit = request.getParameter("length");
		String Honnan = request.getParameter("start");
		String Keres = request.getParameter("search[value]");
		String Rendezes = request.getParameter("order[0][column]");
		String RendezesMod = request.getParameter("order[0][dir]");

		System.out.println(
				"Adatok beolvasása - from " + Integer.parseInt(Honnan) + " mennyit:" + Integer.parseInt(Mennyit)
						+ " keresnivaló:" + Keres + " rendezes: " + Rendezes + " rendezesmod:" + RendezesMod);

		List<UserDTO> userList;
		try {
			userList = userService.getUsers(Rendezes, RendezesMod);
			response.setCharacterEncoding("UTF-8");
			Gson json = new Gson();
			json.toJson(new Response(userList, Integer.valueOf(Mennyit).intValue()), response.getWriter());
		} catch (ServiceException e) {
			System.out.println("Exception in GetUsers");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at with Post:
		// ").append(request.getContextPath());
		doGet(request, response);
	}
	//a DataTables megjelenítéséhez szükséges osztály ami majd az adatok adja vissza számára.
	public static class Response {
		private List<UserDTO> data;
		private int recordsTotal;
		private int recordsFiltered;

		public Response(List<UserDTO> userList, int countRows) {
			super();
			this.data = userList;
			recordsTotal = userList.size();
			recordsFiltered = countRows;
		}

		public List<UserDTO> getData() {
			return data;
		}

		public void setData(ArrayList<UserDTO> data) {
			this.data = data;
		}

		public void setRecordsTotal(int recordsTotal) {
			this.recordsTotal = recordsTotal;
		}

		public int getRecordsTotal() {
			return recordsTotal;
		}

		public void setRecordsFiltered(int recordsFiltered) {
			this.recordsFiltered = recordsFiltered;
		}

		public int getRecordsFiltered() {
			return recordsFiltered;
		}

	}

}
