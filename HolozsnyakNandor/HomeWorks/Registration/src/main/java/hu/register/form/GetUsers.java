package hu.register.form;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at with Get: ").append(request.getContextPath()).append("\n");
		ArrayList<RegisterData> users = Data.getUsers();
		for(RegisterData r: users) {
			response.getWriter().write(r.getFullName());
			response.getWriter().write("\n");
		}*/
		//a requstnek át kell adni hogy milyen néven fogja nekünk továbaddni az objektumunkat :)
		request.getSession().setAttribute("userList",Data.users);
		//következő oldal
		String nextPage = "userlist.jsp";
		//DiszPÉCSER (nem tudom még mikre is jó még :D)
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		//laza forward
		response.sendRedirect(nextPage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at with Post: ").append(request.getContextPath());
		Data.getUsers();
	}

}
