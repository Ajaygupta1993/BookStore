package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import com.bookstore.entity.BookOrder;

public class OrderDAO extends JpaDAO<BookOrder> implements GenericDAO<BookOrder>{
   @Override
   public BookOrder create(BookOrder bookOrder) {
	   
	   bookOrder.setOrderDate(new Date());
	   bookOrder.setPaymentMethod("Cash On Delivery");
	   bookOrder.setStatus("Processing");
	   return super.create(bookOrder);
   }
   
   @Override
   public BookOrder update(BookOrder bookOrder) {
	  return super.update(bookOrder);
   }
   
   
	@Override
	public BookOrder get(Object orderId) {
		
		return super.find(BookOrder.class, orderId);
	}

	@Override
	public void delete(Object orderId) {
	  super.delete(BookOrder.class, orderId);
		
	}

	@Override
	public List<BookOrder> listAll() {
	
		return super.findWithNamedQuery("BookOrder.findAll");
	}

	@Override
	public long count() {
		
		return super.counWithNamedQuery("BookOrder.countAll");
	}

}