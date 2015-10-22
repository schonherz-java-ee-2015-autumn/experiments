package hu.dupetya.web.listener;

import java.util.LinkedList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import hu.schonherz.training.java.solid.account.model.Account;

/**
 * Application Lifecycle Listener implementation class Config
 *
 */
@WebListener
public class Config implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public Config() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute("users", new LinkedList<Account>());
	}

}
