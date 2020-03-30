package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest {
	private static ReviewDAO reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao= new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	@Test
	public void testCreateReview() {
		Review review= new Review();
		Book book= new Book();
		book.setBookId(5);
		Customer customer= new Customer();
		customer.setCustomerId(4);
		review.setBook(book);
		review.setCustomer(customer);
		review.setReviewHeadline("This is very good book");
		review.setReviewRating(5);
		review.setReviewComment("I have just read this book it's good for experience");
		Review savedReview=reviewDao.create(review);
		assertTrue(savedReview.getReviewId()>0);
	}
	@Test
	public void testUpdate() {		
		Review review=reviewDao.get(1);
		String headline="This is very good Good book for fresher";	
		review.setReviewHeadline(headline);
		Review updatedreview=reviewDao.update(review);
		assertTrue(updatedreview.getReviewHeadline().equals(headline));
	}

	@Test
	public void testGet() {
		Integer id=1;
		Review review=reviewDao.get(id);
		assertNotNull(review);
		
	}

	@Test
	public void testDeleteObject() {
		int reviewId=3;
		reviewDao.delete(reviewId);
		Review review=reviewDao.get(reviewId);
		assertNull(review);
	}

	@Test
	public void testListAll() {
		List<Review> listReview=reviewDao.listAll();
		for(Review review:listReview) {
			System.out.println(review.getReviewId()+"     "+review.getBook().getBookTitle()+"    "+review.getCustomer().getCustomerFullName()+""
					+ "   "+review.getReviewHeadline()+"   "+review.getReviewRating());
		}
		assertTrue(listReview.size()>0);
		
	}

	@Test
	public void testCount() {
		long totalreview=reviewDao.count();
		assertTrue(totalreview>0);
	}
	@Test
	public void testfindByCustomerAndBookIdNotFound() {
		Integer customerId=100;
		Integer bookId=89;
		Review result=reviewDao.findByCustomerAndBookId(customerId, bookId);
		assertNull(result);
		
	}
	@Test
	public void testfindByCustomerAndBookId() {
		Integer customerId=4;
		Integer bookId=10;
		Review result=reviewDao.findByCustomerAndBookId(customerId, bookId);
		assertNotNull(result);
		
	}

}
