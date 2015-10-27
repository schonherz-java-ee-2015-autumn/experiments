package hu.schonherz.web.reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.common.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		ArrayList<Helper> arrayList = new ArrayList<>();
		if(RegistrationServlet.users!=null)
		for(String k: RegistrationServlet.users.keySet()){
			User u = RegistrationServlet.users.get(k);
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
		private String firstName;
		private String lastName;
		private String email;
		private Date dateOfBirth;
		public Helper(String firstName, String lastName, String email, Date dateOfBirth) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.dateOfBirth = dateOfBirth;
		}
		
		public Helper(){
			
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
	}

}
