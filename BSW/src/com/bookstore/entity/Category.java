package com.bookstore.entity;
// Generated 25 Jan, 2020 4:13:21 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */

@Entity

@NamedQueries({ @NamedQuery(name = "Category.findAll", query = "SELECT c FROM  Category c ORDER BY c.categoryName"),
		@NamedQuery(name = "Category.countAll", query = "SELECT COUNT(*) FROM Category ")

})

@Table(name = "category", catalog = "boobkstore")
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String categoryName;
	private Set<Book> books = new HashSet<Book>(0);

	public Category() {
	}

	public Category(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category(String categoryName, Set<Book> books) {
		this.categoryName = categoryName;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CATEGORY_NAME", nullable = false, length = 30)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
