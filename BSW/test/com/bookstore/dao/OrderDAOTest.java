package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.BookOrderDetail;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetailId;

public class OrderDAOTest {
    private static OrderDAO OrderDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		OrderDAO= new OrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		OrderDAO.close();
	}

	@Test
	public void testCreateBookOrder() {
		BookOrder Order=new BookOrder();
		Customer customer= new Customer();
		customer.setCustomerId(4);
		Order.setCustomer(customer);
		Order.setRecipientName("Ajay");
		Order.setRecipientPhone("9113349729");
		Order.setShippingAddress("Hydrabad");
		
		Set<BookOrderDetail> ordeDetails= new HashSet<>();
		BookOrderDetail OrderDetail= new BookOrderDetail();
		Book book = new Book(4);
		OrderDetail.setBook(book);
		OrderDetail.setQuantity(1);
		OrderDetail.setSubtotal(25.0f);
		OrderDetail.setBookOrder(Order);
		ordeDetails.add(OrderDetail);
		Order.setOrderDetails(ordeDetails);
		
		
		OrderDAO.create(Order);
		assertTrue(Order.getOrderId()>0);
	
	}

	@Test
	public void testUpdateBookOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Integer orderId=13;
		BookOrder bookOrder=OrderDAO.get(orderId);
		assertEquals(1, bookOrder.getOrderDetails().size());
	}
	@Test
	public void testUpdateBookOrderShippingAddress() {
		Integer orderId=13;
		BookOrder bookOrder=OrderDAO.get(orderId);
		bookOrder.setShippingAddress("New Shipping Address");
		OrderDAO.update(bookOrder);
		BookOrder updatedOrder=OrderDAO.get(orderId);
		assertEquals(bookOrder.getShippingAddress(), updatedOrder.getShippingAddress());
	}

	@Test
	public void testDeleteObject() {
		int orderId=13;
		OrderDAO.delete(orderId);
		BookOrder bookOrder=OrderDAO.get(orderId);
		assertNull(bookOrder);
		
	}

	@Test
	public void testListAll() {
		List<BookOrder> orderList=OrderDAO.listAll();
		assertTrue(orderList.size()>0);
	}

	@Test
	public void testCount() {
		long totalOrder=OrderDAO.count();
		assertEquals(2, totalOrder);
	}

}
