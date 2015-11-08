package hu.training.schonherz.webform;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import hu.schonherz.training.person.PublicPerson;
import hu.schonherz.training.refresher.RefreshRequest;
import hu.schonherz.training.refresher.RefreshRequestFactory;
import hu.schonherz.training.refresher.RefresherRequestGetter;
import hu.schonherz.training.usermanager.ManipulatedRequestException;
import hu.schonherz.training.usermanager.UserManager;
import hu.schonherz.training.usermanager.UserProvider;

/**
 * Servlet implementation class UserProviderServlet
 */
@WebServlet("/UserProviderServlet")
public class UserProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProviderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		response.setCharacterEncoding("utf-8");
		
		RefreshRequestFactory factory = new RefreshRequestFactory(new RefresherRequestGetter() {
			@Override
			public RefreshRequest parseFromParameters() {
				int length = Integer.parseInt(request.getParameter("length"));
				int start = Integer.parseInt(request.getParameter("start"));
				String searchExpression = request.getParameter("search[value]");
				int orderBy = Integer.parseInt(request.getParameter("order[0][column]"));
				String orderByName = request.getParameter("columns[" + orderBy + "][data]");
				String orderType = request.getParameter("order[0][dir]");

				return new RefreshRequest(start, length, searchExpression, orderByName, orderType);
			}
		});

		RefreshRequest refreshRequest = factory.getInstance();

		UserProvider provider = new UserManager();
		
		
		try {
			List<PublicPerson> result = provider.getUsers(refreshRequest);
			gson.toJson(result, response.getWriter());
		} catch (JsonIOException e) {
			Logger.getLogger("RegistrationLogger").info("JsonIOException");
		} catch (ManipulatedRequestException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
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
