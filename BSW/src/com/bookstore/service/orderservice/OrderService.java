package com.bookstore.service.orderservice;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.base.constants.JspPageConstantsForAdmin;
import com.bookstore.controller.frontend.shoppingcart.ShoppingCart;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.BookOrderDetail;
import com.bookstore.entity.Customer;

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

	public void showCheckOutForm() throws ServletException, IOException {
		String checkoutPage="frontend/checkout.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(checkoutPage);
		requestDispatcher.forward(request, response);
		
	}

	public void placeOrder() throws ServletException, IOException {
		String recipientName=request.getParameter("recipientName");
		String recipientPhone=request.getParameter("recipientPhone");
		String recipientAddress=request.getParameter("recipientAddress");
		String recipientCity=request.getParameter("recipientCity");
		String recipientZipCode=request.getParameter("recipientZipCode");
		String recipientCountry=request.getParameter("recipientCountry");
		String paymentMethod=request.getParameter("paymentMethod");
		String shippingAddress=recipientAddress+", "+recipientCity+", "+recipientZipCode+", "+recipientCountry+"";
		
		BookOrder order= new BookOrder();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("customerLogedin");
		order.setCustomer(customer);
		ShoppingCart shoppingCart=(ShoppingCart) session.getAttribute("cart");
		
		Map<Book, Integer> items=shoppingCart.getItems();
		Iterator<Book> iterator=items.keySet().iterator();
		Set<BookOrderDetail> orderDetail=new HashSet<>();
		
		while(iterator.hasNext()) {
			Book book=iterator.next();
			Integer quantity=items.get(book);
			float subTotal=quantity*book.getBookPrice();
			BookOrderDetail bookOrderDetail=new BookOrderDetail();
			bookOrderDetail.setBook(book);
			bookOrderDetail.setBookOrder(order);
			bookOrderDetail.setQuantity(quantity);
			bookOrderDetail.setSubtotal(subTotal);
			orderDetail.add(bookOrderDetail);
			
		}
		
		order.setOrderDetails(orderDetail);
		order.setTotal(shoppingCart.getTotalAmount());
		orderDAO.create(order);
		shoppingCart.clear();
		String message="Thanku You, Your Order has been Recivied";
		request.setAttribute("message", message);
		String messagePage="frontend/message.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(messagePage);
		requestDispatcher.forward(request, response);
		
	}

	public void orderHistoryOfCustomer() throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("customerLogedin");
		Integer customerID=customer.getCustomerId();
		List<BookOrder> listOrder=orderDAO.listByCustomer(customerID);
		System.out.println("==================listOrderSIZE================="+listOrder.size());
		request.setAttribute("listOrder", listOrder);
		String historyPage="frontend/order_list.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(historyPage);
		requestDispatcher.forward(request, response);
		
		
	}

	public void showOrderDetailForCustomer() throws ServletException, IOException {
		Integer orderId=Integer.parseInt(request.getParameter("orderId"));
		HttpSession session= request.getSession();
		Customer customer=(Customer) session.getAttribute("customerLogedin");
		Integer customerId=customer.getCustomerId();
		
		
		BookOrder order=orderDAO.findByCustomerIdAndOrderId(orderId, customerId);
		request.setAttribute("order", order);
		String orderDetail="frontend/view_order_detail.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(orderDetail);
		requestDispatcher.forward(request, response);
		
	}

}
