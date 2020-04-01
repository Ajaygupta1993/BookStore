package com.bookstore.controller.frontend.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.orderservice.OrderService;

@WebServlet("/view_detail")
public class ViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderService= new OrderService(request, response);
		orderService.showOrderDetailForCustomer();

	}

}
