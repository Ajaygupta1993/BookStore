package com.bookstore.controler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/")
public class AdminHomeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminHomeControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String homePage="index.jsp";
		System.out.println("Admin servlet");
		RequestDispatcher requestdispatcher=request.getRequestDispatcher(homePage);
		requestdispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}
	

}
