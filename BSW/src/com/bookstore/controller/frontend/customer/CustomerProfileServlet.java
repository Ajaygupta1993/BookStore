package com.bookstore.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.customer.CustomerService;

@WebServlet("/view_profile")
public class CustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerProfileServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService customerService= new CustomerService(request, response);
		customerService.showCustomerProfile();

	}

}
