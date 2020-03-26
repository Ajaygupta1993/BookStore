package com.bookstore.service.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Customer;

public class CustomerService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDAO customerDAO;
	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDAO=new CustomerDAO();
	}
	 public void listCustomers() throws ServletException, IOException {
		 listCustomers(null);
	 }
	
	public void listCustomers(String message) throws ServletException, IOException {
		List<Customer> customerList=customerDAO.listAll();
		if(message !=null) {
			request.setAttribute("message", message);
		}
		String listPage="customer_list.jsp";
		request.setAttribute("customerList", customerList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
		
	}
	public void createCustomer() throws ServletException, IOException {
		String email=request.getParameter("email");
		Customer existCustomer=customerDAO.findByEmail(email);
		if(existCustomer !=null) {
			String message="Could not create customer this email  "+email+"  id is already exist";
			listCustomers(message);
		}
		else {
			String fullName=request.getParameter("fullName");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			int zipCode=Integer.parseInt(request.getParameter("zipCode"));
			String country=request.getParameter("country");
			
			Customer customer= new Customer();
			customer.setCustomerEmail(email);
			customer.setCustomerFullName(fullName);
			customer.setCustomerAddress(address);
			customer.setCustomerCity(city);
			customer.setCustomerCountry(country);
			customer.setCustomerZipCode(zipCode);
			customer.setCustomerPassword(password);
			customer.setCustomerPhone(phone);
			customerDAO.create(customer);
			String message="New Customer Registered sucessfully";
			listCustomers(message);
		
		}
		
	}
    public void editCustomer() throws ServletException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));
    	System.out.println("====================ID Of Customer====="+id);
    	Customer editCustomer=customerDAO.get(id);
        String editPage="customer_form.jsp";
    	request.setAttribute("customer", editCustomer);
    	RequestDispatcher requestDispatcher=request.getRequestDispatcher(editPage);
    	requestDispatcher.forward(request, response);
    }
	public void updateCustomer() throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("customerId"));
		String email=request.getParameter("email");
    	
    	Customer existCustomerByEmail=customerDAO.findByEmail(email);
    	if(existCustomerByEmail !=null && existCustomerByEmail.getCustomerId() !=id) {
    		String message="Could not Update this because bcz this Email is already exist";
    		listCustomers(message);
    		return;
    	}
    	else {
    		String fullName=request.getParameter("fullName");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			int zipCode=Integer.parseInt(request.getParameter("zipCode"));
			String country=request.getParameter("country");
			Customer existCustomerById=customerDAO.get(id);
			existCustomerById.setCustomerId(id);
			existCustomerById.setCustomerEmail(email);
			existCustomerById.setCustomerFullName(fullName);
			existCustomerById.setCustomerAddress(address);
			existCustomerById.setCustomerCity(city);
			existCustomerById.setCustomerCountry(country);
			existCustomerById.setCustomerZipCode(zipCode);
			existCustomerById.setCustomerPassword(password);
			existCustomerById.setCustomerPhone(phone);
			customerDAO.update(existCustomerById);
			String message = "A  Customer Updated Sucessfully";
			listCustomers(message);
    		
    	}
		
	}
	
	public void deleteCustomer() throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("customerId"));
		customerDAO.delete(id);
		String message="Customer Deleted Successfully";
		listCustomers(message);
		
		
	}
}
