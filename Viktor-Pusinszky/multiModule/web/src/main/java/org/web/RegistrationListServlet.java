package org.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.core.RegistrationUtilImpl;

/**
 * Servlet implementation class RegistrationListServlet
 */
@WebServlet("/RegistrationListServlet")
public class RegistrationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationUtilImpl regUtil = new RegistrationUtilImpl();
		request.getSession().setAttribute("userList", regUtil.getAllUser());
		response.sendRedirect("userList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RegistrationUtilImpl regUtil = new RegistrationUtilImpl();
//		 String Mennyit = request.getParameter("length");
//		 String Honnan = request.getParameter("start");
//		 System.out.println(Mennyit + " : " + Honnan +" MENNYIT HONNAN " );
//		request.getSession().setAttribute("userList", regUtil.getUserLimit(Honnan,Mennyit));
//		String nextPage = "/userList.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
//		rd.forward(request, response);
	}

}
