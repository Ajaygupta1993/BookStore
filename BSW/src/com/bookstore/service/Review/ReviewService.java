package com.bookstore.service.Review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewService {
	private ReviewDAO reviewDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public ReviewService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		reviewDAO=new ReviewDAO();
	}
	public void listAllReview() throws ServletException, IOException {
		listAllReview(null);
	}
	
	public void listAllReview(String message) throws ServletException, IOException {
		List<Review> listReview=reviewDAO.listAll();
		request.setAttribute("listReview", listReview);
		if(message !=null) {
			request.setAttribute("message",message);
		}
		String listReviewPage="review_list.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(listReviewPage);
		requestDispatcher.forward(request, response);
		
	}
	public void editReview() throws ServletException, IOException {
		int reviewId=Integer.parseInt(request.getParameter("reviewId"));
		Review review=reviewDAO.get(reviewId);
		request.setAttribute("review", review);
		String editReviewFormpage="review_form.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(editReviewFormpage);
		requestDispatcher.forward(request, response);
		
		
	}
	public void updateReview() throws ServletException, IOException {
		int reviewId=Integer.parseInt(request.getParameter("reviewId"));
		
		String headLine=request.getParameter("reviewHeadline");
		String comment=request.getParameter("comment");
		Review review=reviewDAO.get(reviewId);
		review.setReviewHeadline(headLine);
		review.setReviewComment(comment);
		reviewDAO.update(review);
		String message="Review updated sucessfully";
		listAllReview(message);
		
		
	}
	public void deleteReview() throws ServletException, IOException {
		int reviewId=Integer.parseInt(request.getParameter("reviewId"));
		reviewDAO.delete(reviewId);
		String message="Review Deleted sucessfully";
		listAllReview(message);
		
	}
	public void showReviewForm() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("book_id"));
		BookDAO bookDao=new BookDAO();
		Book book=bookDao.get(bookId);
		HttpSession session=request.getSession();
		session.setAttribute("book", book);
		Customer customer=(Customer) session.getAttribute("customerLogedin");
		Review existReview=reviewDAO.findByCustomerAndBookId(customer.getCustomerId(), bookId);
		String writeReviewPage="frontend/review_form.jsp";
		if(existReview !=null) {
			request.setAttribute("review", existReview);
		 writeReviewPage="frontend/review_info.jsp";
			
		}
		RequestDispatcher requestDispatcher= request.getRequestDispatcher(writeReviewPage);
		requestDispatcher.forward(request, response);
		
		
	}
	public void submitReviewByCustomer() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		Integer rating=Integer.parseInt(request.getParameter("rating"));
		String headLine=request.getParameter("headline");
		String comment=request.getParameter("commenet");
		Review review= new Review();
		review.setReviewHeadline(headLine);
		review.setReviewComment(comment);
		review.setReviewRating(rating);
		Book book= new Book();
		book.setBookId(bookId);
		review.setBook(book);
		Customer customer=(Customer) request.getSession().getAttribute("customerLogedin");
		review.setCustomer(customer);
		reviewDAO.create(review);
		String messagePage="frontend/review_done.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(messagePage);
		requestDispatcher.forward(request, response);
		
		
		
		
	}
	

}
