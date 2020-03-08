package com.bookstore.service.user;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;

public class UserServices {
	private EntityManagerFactory entitymanagerfactory;
	private EntityManager entitymanager;
	private UserDao userdao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/*public UserServices(HttpServletRequest request, HttpServletResponse responce) {
		this.request = request;
		this.response = responce;
		entitymanagerfactory = Persistence.createEntityManagerFactory("BSW");
		entitymanager = entitymanagerfactory.createEntityManager();
		userdao = new UserDao();
	}*/
	
	
	public UserServices(HttpServletRequest request, HttpServletResponse responce) {
		this.request = request;
		this.response = responce;
		/*this.entitymanager=entitymanager;*/
		entitymanagerfactory = Persistence.createEntityManagerFactory("BSW");
		entitymanager = entitymanagerfactory.createEntityManager();
		userdao = new UserDao();
	}
	
	

	/* New USer Created sucessfully */
	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	/* Getting all user */
	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUser = userdao.listAll();
		request.setAttribute("listUser", listUser);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String listPage = "user_list.jsp";
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(listPage);
		requestdispatcher.forward(request, response);

	}

	/* Creating new user */
	public void createUSer() throws ServletException, IOException {
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Users existUser = userdao.findByEmail(email);
		if (existUser != null) {
			String message = "Could not create new user Email  :" + email + " is already exist";
			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");

			dispatcher.forward(request, response);

		} else {
			Users users = new Users(email, userName, password);
			userdao.create(users);
			listUser("New USer Created sucessfully");
		}

	}

	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userdao.get(userId);
		String editUSer = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(editUSer);
		requestdispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int userId = Integer.parseInt(request.getParameter("userId"));
		Users users = new Users(userId, email, password, userName);
		Users userById = userdao.get(userId);
		Users userByEmail = userdao.findByEmail(email);
		if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update this emial " + email + "is already exist";
			request.setAttribute("message", message);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("message.jsp");
			requestdispatcher.forward(request, response);
		} else {
			userdao.update(users);
			String message = "User Updated sucessfully";
			listUser(message);
		}

	}

	public void deleteUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
	    userdao.delete(userId);
	    String message = "User deleted sucessfully";
		listUser(message);
	}

	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean loginResult=userdao.checkLogin(email, password);
		if(loginResult) {
			System.out.println("VAlid user");
			request.getSession().setAttribute("userEmail", email);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/admin/");
			requestdispatcher.forward(request, response);
		}else {
			System.out.println("Invalid  user");
			String message="Login Failed";
			request.setAttribute("message", message);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");
			requestdispatcher.forward(request, response);
		}
	}

}
