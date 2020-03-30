package com.bookstore.controller.frontend.shoppingcart;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;

public class ShoppingCartTest {
	private static ShoppingCart cart;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cart= new ShoppingCart();
		Book book= new Book(1);
		book.setBookPrice(10);
		cart.addItems(book);
		cart.addItems(book);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddItems() {
		Map<Book, Integer> items=cart.getItems();
		int quantity=items.get(new Book(1));
		assertEquals(2, quantity);
	}
	@Test
	public void testRemoveItem() {
		cart.removeItems(new Book(1));
		assertTrue(cart.getItems().isEmpty());
		
	}
	
	@Test
	public void testRemoveItem2() {
		Book book2= new Book(2);
		cart.addItems(book2);
		cart.removeItems(new Book(2));
		assertNull(cart.getItems().get(book2));
		
	}
	@Test
	public void trstGetTotalQuantity() {
		Book book3= new Book();
		cart.addItems(book3);
		cart.addItems(book3);
		cart.addItems(book3);
		assertEquals(5, cart.getTotalQuantity());
	}
	@Test
	public void testGetTotalQuantity1() {
		ShoppingCart cart= new ShoppingCart();
		assertEquals(0.0f, cart.getTotalAmount(),0.0f);
	}
	@Test
	public void testGetTotalQuantity2() {
		assertEquals(20.0f, cart.getTotalAmount(),20.0f);
	}
	@Test
	public void testClear() {
		cart.clear();
		assertEquals(0, cart.getTotalQuantity());
	}
	@Test
	public void testUpdate() {
		ShoppingCart cart= new ShoppingCart();
		Book book1= new Book();
		Book book2= new Book();
		cart.addItems(book1);
		cart.addItems(book2);
		int [] bookIds= {1,2};
		int [] quantites= {3,4};
		cart.update(bookIds, quantites);
		assertEquals(7, cart.getTotalQuantity());
		
	}

}
