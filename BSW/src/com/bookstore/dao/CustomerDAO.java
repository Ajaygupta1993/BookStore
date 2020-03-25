package com.bookstore.dao;

import java.util.Date;
import java.util.List;

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

}
