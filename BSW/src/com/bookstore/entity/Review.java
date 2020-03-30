package com.bookstore.entity;
// Generated 25 Jan, 2020 4:13:21 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "review", catalog = "boobkstore")
@NamedQueries({
	@NamedQuery(name="Review.listAll",query="SELECT R FROM Review R ORDER BY R.reviewDate DESC"),
	@NamedQuery(name="Review.countAll",query="SELECT COUNT(R) FROM Review R"),
	@NamedQuery(name="Review.findByCustomerAndBook",query="SELECT R FROM Review R WHERE R.customer.customerId =:customerId AND R.book.bookId=:bookId ")
	
	
})
public class Review implements java.io.Serializable {

	private Integer reviewId;
	private Book book;
	private Customer customer;
	private Review review;
	private String reviewComment;
	private int reviewRating;
	private Date reviewDate;
	private String reviewHeadline;
	private Set<Review> reviews = new HashSet<Review>(0);

	public Review() {
	}

	public Review(Book book,Customer customer, Review review, String reviewComment, int reviewRating, Date reviewDate,
			String reviewHeadline, Set<Review> reviews) {
		this.book = book;
		this.customer=customer;
		this.review = review;
		this.reviewComment = reviewComment;
		this.reviewRating = reviewRating;
		this.reviewDate = reviewDate;
		this.reviewHeadline = reviewHeadline;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "REVIEW_ID", unique = true, nullable = false)
	public Integer getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REVIEW_BOOK_ID")
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REVIEW_CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "REVIEW_COMMENT", length = 65535)
	public String getReviewComment() {
		return this.reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	@Column(name = "REVIEW_RATING", precision = 12, scale = 0)
	public int getReviewRating() {
		return this.reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REVIEW_DATE", length = 19)
	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	@Column(name = "REVIEW_HEADLINE", length = 128)
	public String getReviewHeadline() {
		return this.reviewHeadline;
	}

	public void setReviewHeadline(String reviewHeadline) {
		this.reviewHeadline = reviewHeadline;
	}
	
	
	/*public Review getReview() {
		return this.review;
	}

	public void setReview(Review review) {
		this.review = review;
	}


	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "review")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	*/
	
}
