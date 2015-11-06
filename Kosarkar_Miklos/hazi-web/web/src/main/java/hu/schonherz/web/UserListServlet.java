package hu.schonherz.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.common.User;
import hu.schonherz.common.UserManager;
import hu.schonherz.web.core.UserManagerImpl;



/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserManager dbUtil;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        dbUtil = new UserManagerImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		

		 int length = Integer.parseInt(request.getParameter("length"));
		 int from = Integer.parseInt(request.getParameter("start"));
		 String searchFor = request.getParameter("search[value]");
		 int orderBy = Integer.parseInt(request.getParameter("order[0][column]"));
		 String orderByName = request.getParameter("columns[" + orderBy +"][data]");
		 String orderDirection = request.getParameter("order[0][dir]");
		
		ArrayList<Helper> arrayList = new ArrayList<>();
		List<User> users =  dbUtil.getUsers(searchFor, from, length, orderByName, orderDirection);
//				dbUtil.getAllUser();
		for(User u: users){
			arrayList.add(new Helper(u.getFirstName(), u.getLastName(), u.getEmail(), u.getDateOfBirth()));
		}
		response.setCharacterEncoding("UTF-8");
		gson.toJson(new Response(arrayList), response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static class Response {
		private ArrayList<Helper> data;

		public Response(ArrayList<Helper> data) {
			super();
			this.data = data;
		}

		public ArrayList<Helper> getData() {
			return data;
		}

		public void setData(ArrayList<Helper> data) {
			this.data = data;
		}

	}
	
	public static class Helper{
		private String first_name;
		private String last_name;
		private String email;
		private Date birthdate;
		public Helper(String firstName, String lastName, String email, Date dateOfBirth) {
			super();
			this.first_name = firstName;
			this.last_name = lastName;
			this.email = email;
			this.birthdate = dateOfBirth;
		}
		
		public Helper(){
			
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String firstName) {
			this.first_name = firstName;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String lastName) {
			this.last_name = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(Date dateOfBirth) {
			this.birthdate = dateOfBirth;
		}
		
	}

}
