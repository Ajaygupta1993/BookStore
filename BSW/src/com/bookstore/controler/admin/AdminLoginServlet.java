package com.bookstore.controler.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.base.controller.BaseServlet;
import com.bookstore.service.user.UserServices;

@WebServlet("/admin/login")
public class AdminLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserServices userservices = new UserServices(request,response);
		userservices.login();
		
		
	}

}
