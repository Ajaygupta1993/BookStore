package com.bookstore.entity;
// Generated 25 Jan, 2020 4:13:21 PM by Hibernate Tools 5.2.12.Final

import java.beans.Transient;
import java.util.Base64;
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
@NamedQueries({
	@NamedQuery(name = "Book.findAll", query = "SELECT B FROM  Book B ORDER BY B.bookTitle"),
	 @NamedQuery(name = "Book.findBytitle", query = "SELECT B FROM  Book B where B.bookTitle=:bookTitle"),
	 @NamedQuery(name = "Book.countAll", query = "SELECT COUNT(*) FROM Book "),
	 @NamedQuery(name = "Book.findByCategory", query = "SELECT b FROM Book b JOIN Category c ON b.category.categoryId = c.categoryId AND c.categoryId = :catId"),
	 @NamedQuery(name = "Book.listNewBook", query = "SELECT B FROM  Book B ORDER BY B.bookPublishDate DESC"),
	 @NamedQuery(name = "Book.search", query = "SELECT B FROM  Book B WHERE B.bookTitle LIKE '%' ||  :keyword || '%'" 
	 +"OR B.bookAuther LIKE '%' ||  :keyword || '%'"
	  +" OR B.bookDescription LIKE '%' ||  :keyword || '%'")
	 
	

})
@Table(name = "book", catalog = "boobkstore")
public class Book implements java.io.Serializable {

	private Integer bookId;
	private Category category;
	private String bookTitle;
	private String bookAuther;
	private String bookDescription;
	private String bookIsbn;
	private byte[] bookImage;
	private String base64Image;
	private float bookPrice;
	private Date bookPublishDate;
	private Date bookLastUpdated;
	private Set<BookOrderDetail> bookOrderDetails = new HashSet<BookOrderDetail>(0);
	private Set<Review> reviews = new HashSet<Review>(0);

	public Book() {
	}

	public Book(String bookTitle, String bookAuther, String bookDescription, String bookIsbn, byte[] bookImage,
			float bookPrice, Date bookPublishDate) {
		this.bookTitle = bookTitle;
		this.bookAuther = bookAuther;
		this.bookDescription = bookDescription;
		this.bookIsbn = bookIsbn;
		this.bookImage = bookImage;
		this.bookPrice = bookPrice;
		this.bookPublishDate = bookPublishDate;
	}

	public Book(Category category, String bookTitle, String bookAuther, String bookDescription, String bookIsbn,
			byte[] bookImage, float bookPrice, Date bookPublishDate, Date bookLastUpdated,
			Set<BookOrderDetail> bookOrderDetails, Set<Review> reviews) {
		this.category = category;
		this.bookTitle = bookTitle;
		this.bookAuther = bookAuther;
		this.bookDescription = bookDescription;
		this.bookIsbn = bookIsbn;
		this.bookImage = bookImage;
		this.bookPrice = bookPrice;
		this.bookPublishDate = bookPublishDate;
		this.bookLastUpdated = bookLastUpdated;
		this.bookOrderDetails = bookOrderDetails;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "BOOK_ID", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_CATEGORY_ID")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "BOOK_TITLE", nullable = false, length = 50)
	public String getBookTitle() {
		return this.bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Column(name = "BOOK_AUTHER", nullable = false, length = 30)
	public String getBookAuther() {
		return this.bookAuther;
	}

	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}

	@Column(name = "BOOK_DESCRIPTION", nullable = false, length = 16777215)
	public String getBookDescription() {
		return this.bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	@Column(name = "BOOK_ISBN", nullable = false, length = 20)
	public String getBookIsbn() {
		return this.bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	@Column(name = "BOOK_IMAGE", nullable = false)
	public byte[] getBookImage() {
		return this.bookImage;
	}

	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}

	@Column(name = "BOOK_PRICE", nullable = false, precision = 12, scale = 0)
	public float getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BOOK_PUBLISH_DATE", nullable = false, length = 10)
	public Date getBookPublishDate() {
		return this.bookPublishDate;
	}

	public void setBookPublishDate(Date bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOK_LAST_UPDATED", length = 19)
	public Date getBookLastUpdated() {
		return this.bookLastUpdated;
	}

	public void setBookLastUpdated(Date bookLastUpdated) {
		this.bookLastUpdated = bookLastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<BookOrderDetail> getBookOrderDetails() {
		return this.bookOrderDetails;
	}

	public void setBookOrderDetails(Set<BookOrderDetail> bookOrderDetails) {
		this.bookOrderDetails = bookOrderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	@javax.persistence.Transient
	public String getBase64Image() {
		this.base64Image=Base64.getEncoder().encodeToString(this.bookImage);
		return this.base64Image;
	}
	@javax.persistence.Transient
	public void setBase64Image(String base64Image) {
		this.base64Image=base64Image;
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

}
