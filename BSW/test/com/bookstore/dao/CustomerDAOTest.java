package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;

public class CustomerDAOTest {
	private static CustomerDAO customerDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDao = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDao.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerEmail("tom@gmail.com");
		customer.setCustomerFullName("Tom Eager");
		customer.setCustomerCity("NewYork");
		customer.setCustomerCountry("United States");
		customer.setCustomerAddress("1000 North Avenue");
		customer.setCustomerPassword("12345");
		customer.setCustomerPhone("180009000");
		customer.setCustomerZipCode(63103);
		Customer savedCustomer = customerDao.create(customer);
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDao.get(customerId);
		assertNotNull(customer);

	}

	@Test
	public void testDeleteCustomer() {
		Integer custId = 2;
		customerDao.delete(custId);
		Customer customer = customerDao.get(2);
		assertNull(customer);

	}

	@Test
	public void testUpdate() {
		Customer customer = customerDao.get(1);
		String fullName = "Tom Test";
		customer.setCustomerFullName(fullName);
		Customer updatedCustomer = customerDao.update(customer);
		assertTrue(updatedCustomer.getCustomerFullName().equals(fullName));
	}
	@Test
	public void testListAllCustomer() {
		List<Customer >customer=customerDao.listAll();
		assertTrue(customer.size()>0);
	}
	@Test
	public void testCount() {
		long count=customerDao.count();
		assertEquals(1, count);
	}
	@Test
	public void testFindByEmail() {
		String email="tom@gmail.com";
		Customer customer=customerDao.findByEmail(email);
		assertNotNull(customer);
	}

}
