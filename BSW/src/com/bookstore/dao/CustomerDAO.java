package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Customer;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	@Override
	public Customer create(Customer customer) {
		customer.setCustomerRegisterDate(new Date());
		return super.create(customer);
	}

	@Override
	public Customer get(Object customerId) {

		return super.find(Customer.class, customerId);
	}

	@Override
	public void delete(Object customerId) {
		super.delete(Customer.class, customerId);

	}

	@Override
	public List<Customer> listAll() {

		return super.findWithNamedQuery("Customer.findAll");
	}

	@Override
	public long count() {

		return super.counWithNamedQuery("Customer.countAll");
	}
	public Customer findByEmail(String email) {
		
		List<Customer> result=super.findWithNamedQuery("Customer.findByCustomerEmail", "email", email);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return  null;
		
	}
	
	public Customer checkLogin(String email,String password) {
		Map<String, Object> parameter=new HashMap<>();
		parameter.put("email", email);
		parameter.put("password", password);
		List<Customer> result=super.findWithNamedQuery("Customer.checkLogin", parameter);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
