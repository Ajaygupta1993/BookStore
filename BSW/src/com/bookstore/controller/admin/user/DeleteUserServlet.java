package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.user.UserServices;

@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("==========userId========="+userId);
		UserServices userservices = new UserServices(request,response);
		userservices.deleteUser();

	}

}
