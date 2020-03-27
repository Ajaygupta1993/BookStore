package com.bookstore.service.Review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.ReviewDAO;
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
	

}
