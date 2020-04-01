package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;

public class OrderDAO extends JpaDAO<BookOrder> implements GenericDAO<BookOrder>{
   @Override
   public BookOrder create(BookOrder bookOrder) {
	   
	   bookOrder.setOrderDate(new Date());
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
    
	//This method is define for check the order for specific customer
	
	public BookOrder findByCustomerIdAndOrderId(Integer orderId,Integer customerId) {
		
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("orderId", orderId);
		parameter.put("customerId", customerId);
		List<BookOrder> result=super.findWithNamedQuery("BookOrder.findByCustomerIdAndOrderId", parameter);
		  if(!result.isEmpty()) {
			  return result.get(0);
		  }
		return null;
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
	
	public List<BookOrder> listByCustomer(Integer customerId){
		return super.findWithNamedQuery("BookOrder.findByCustomer", "customerId", customerId);
	}

}
