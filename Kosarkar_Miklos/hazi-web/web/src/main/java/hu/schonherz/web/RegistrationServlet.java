package hu.schonherz.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.schonherz.common.User;
import hu.schonherz.common.UserManager;
import hu.schonherz.web.core.StrongEncryptor;
import hu.schonherz.web.core.validation.DateValidator;
import hu.schonherz.web.core.validation.EmailValidator;
import hu.schonherz.web.core.validation.Validator;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    public static Map<String, User> users;
	private UserManager userManager;
	
	@Autowired(required=true)
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}

	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
	}
    public RegistrationServlet() {
        super();
        
//        users = new HashMap<>();
       // dbUtil = new UserManagerImpl();
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String birthDate = request.getParameter("birth");
		Date date = new Date();
		
		
//		if(userName==null || userName.isEmpty()){
//			request.setAttribute("state", "FAILURE");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			return;
//		}
//		
//		
//		if(password==null || password.isEmpty()){
//			request.setAttribute("state", "FAILURE");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			return;
//		}
//			
//		if(Validator.isValidDate(request.getParameter("birth"), Validator.DATEFORMAT)){
//			SimpleDateFormat dateF = new SimpleDateFormat(Validator.DATEFORMAT);
//			dateF.setLenient(false);
//			try {
//				date = dateF.parse(request.getParameter("birth"));
//			} catch (ParseException e) {
//				request.setAttribute("state", "FAILURE");
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//				return;
//			}	
//		}else{
//			request.setAttribute("state", "FAILURE");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			return;
//		}
//		if(!Validator.isValidEmailAddress(email)){
//			request.setAttribute("state", "FAILURE");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			return;
//		}
		if(Validator.isValidInput(userName) &&
				Validator.isValidInput(password) &&
				new DateValidator(birthDate).validate() &&
				new EmailValidator(email).validate()){
			
			if(userManager.findUserByName(userName)==null){
				StrongEncryptor encryption = new StrongEncryptor();
				String encryptedPassword = encryption.encrypt(password);
				 userManager.saveUser(new User(userName, firstName, lastName, encryptedPassword, email, date));
				 request.setAttribute("state", "SUCCESS");
			}else{
				 request.setAttribute("state", "FAILURE");	
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("state", "FAILURE");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
			
		
	
		
	}

}
