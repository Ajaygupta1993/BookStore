package com.bookstore.test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Review;

public class BookRatingTest {

	@Test
	public void testAverageRating1() {
		Book book= new Book();
		Set<Review> reviews= new HashSet<>();
		Review reviews1=new Review();
		reviews1.setReviewRating(5.0f);
		reviews.add(reviews1);
		book.setReviews(reviews);
		float averageRating=book.getAverageRating();
		assertEquals(5.0, averageRating,0.0);
		
	}
	@Test
	public void testAverageRating2() {
		Book book= new Book();
		float averageRating=book.getAverageRating();
		assertEquals(0.0, averageRating,0.0);
		
	}
	@Test
	public void testAverageRating3() {
		Book book= new Book();
		Set<Review> reviews= new HashSet<>();
		Review reviews1=new Review();
		Review reviews2=new Review();
		Review reviews3=new Review();
		reviews1.setReviewRating(5.0f);
		reviews2.setReviewRating(4.0f);
		reviews3.setReviewRating(3.0f);
		reviews.add(reviews1);
		reviews.add(reviews2);
		reviews.add(reviews3);
		
		book.setReviews(reviews);
		float averageRating=book.getAverageRating();
		assertEquals(4.0, averageRating,0.0);
	}
	@Test
	public void testRatingString1() {
		float averageRating=0.0f;
		Book book= new Book();
		String actual=book.getRatingString(averageRating);
		String expected="off,off,off,off,off";
		assertEquals(expected, actual);
		
	}
	@Test
	public void testRatingString2() {
		float averageRating=5.0f;
		Book book= new Book();
		String actual=book.getRatingString(averageRating);
		String expected="on,on,on,on,on";
		assertEquals(expected, actual);
		
	}
	@Test
	public void testRatingString3() {
		float averageRating=3.0f;
		Book book= new Book();
		String actual=book.getRatingString(averageRating);
		String expected="on,on,on,off,off";
		assertEquals(expected, actual);
		
	}
	@Test
	public void testRatingString4() {
		float averageRating=4.5f;
		Book book= new Book();
		String actual=book.getRatingString(averageRating);
		String expected="on,on,on,on,half";
		assertEquals(expected, actual);
		
	}

}
