import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.User;
import core.RegistrationUtilImpl;

/**
 * Servlet implementation class GetUsers
 */
@WebServlet("/GetUsers")
public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		RegistrationUtilImpl userListClass = new RegistrationUtilImpl();
		
		 String Mennyit = request.getParameter("length");
		 String Honnan = request.getParameter("start");
		 String Keres = request.getParameter("search[value]");
		 String Rendezes = request.getParameter("order[0][column]");
		 String RendezesMod = request.getParameter("order[0][dir]");
		 
		 System.out.println("Adatok beolvasása - from " + Integer.parseInt(Honnan) +
		 " mennyit:" + Integer.parseInt(Mennyit) + " keresnivaló:" + Keres +  " rendezes: " + Rendezes + " rendezesmod:" + RendezesMod);
		 
		 ArrayList<User> userList = userListClass.getAllUsertoJSON(Integer.parseInt(Honnan), Integer.parseInt(Mennyit),Keres.isEmpty()?"":Keres,Rendezes,RendezesMod);
		response.setCharacterEncoding("UTF-8");
		Gson json = new Gson();
		json.toJson(new Response(userList), response.getWriter());
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at with Post: ").append(request.getContextPath());
		doGet(request, response);
	}
	
	public static class Helper {
		private String name;
		private Date age;
		
		public Helper(String name, Date age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getAge() {
			return age;
		}

		public void setAge(Date age) {
			this.age = age;
		}

	}
	public static class Response {
		private ArrayList<User> data;
		private int recordsTotal;
		private int recordsFiltered;
		public Response(ArrayList<User> data) {
			super();
			this.data = data;
			recordsTotal = data.size();
			recordsFiltered = data.size();
		}
		
		public ArrayList<User> getData() {
			return data;
		}

		public void setData(ArrayList<User> data) {
			this.data = data;
		}
		
		public void setRecordsTotal (int recordsTotal) {
			this.recordsTotal = recordsTotal;
		}
		
		public int getRecordsTotal () {
			return recordsTotal;
		}
		
		public void setRecordsFiltered (int recordsFiltered) {
			this.recordsFiltered = recordsFiltered;
		}
		
		public int getRecordsFiltered () {
			return recordsFiltered;
		}

	}

}
