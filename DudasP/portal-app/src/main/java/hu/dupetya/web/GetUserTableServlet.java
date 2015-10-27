package hu.dupetya.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.training.java.solid.account.model.Account;

/**
 * Servlet implementation class GetUserTableServlet
 */
@WebServlet("/GetUserTableServlet")
public class GetUserTableServlet extends HttpServlet {
	public static class UserTableEntry {
		private String name;
		private String email;

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public void setName(String user) {
			name = user;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserTableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Account> accounts = (List<Account>) getServletContext().getAttribute("users");
		List<UserTableEntry> entries = new ArrayList<>(accounts.size());

		for (Account account : accounts) {
			UserTableEntry newEntry = new UserTableEntry();
			newEntry.setEmail(account.getEmail());
			newEntry.setName(account.getUsername());
			entries.add(newEntry);
		}

		Gson gson = new Gson();
		gson.toJson(entries, response.getWriter());
	}

}
