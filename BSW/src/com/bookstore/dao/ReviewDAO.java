package com.bookstore.dao;

import java.util.Date;
import java.util.List;

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

}