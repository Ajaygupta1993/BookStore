package com.bookstore.service.orderservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.base.constants.JspPageConstantsForAdmin;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.BookOrder;

public class OrderService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private OrderDAO orderDAO;
	
	public OrderService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.orderDAO= new OrderDAO();
	}

	public void listAllOrder() throws ServletException, IOException {
	List<BookOrder>	listOrder=orderDAO.listAll();
	 request.setAttribute("listOrder", listOrder);
	 String listPage=JspPageConstantsForAdmin.ORDER_LIST;
	 RequestDispatcher requestDispatcher=request.getRequestDispatcher(listPage);
	 requestDispatcher.forward(request, response);
		
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		Integer orderId=Integer.parseInt(request.getParameter("orderId"));
		BookOrder order=orderDAO.get(orderId);
		request.setAttribute("order", order);
		String orderDetail=JspPageConstantsForAdmin.ORDER_DETAIL;
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(orderDetail);
		requestDispatcher.forward(request, response);
		
	}

}
