package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
    @Override
    public Review create(Review review) {
    	review.setReviewDate(new Date());
    	return super.create(review);
    }
	
	
	@Override
	public Review get(Object id) {
		
		return super.find(Review.class, id);
	}

	@Override
	public void delete(Object id) {
	  
		super.delete(Review.class, id);
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.counWithNamedQuery("Review.countAll");
	}
	public Review findByCustomerAndBookId(Integer customerId,int bookId) {
		Map<String, Object> parameter= new HashMap<>();
		parameter.put("customerId", customerId);
		parameter.put("bookId", bookId);
		List<Review> result=super.findWithNamedQuery("Review.findByCustomerAndBook",  parameter);
		if(!result.isEmpty()) {
			return result.get(0);
		}	
		return null;
	}

}
