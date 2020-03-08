package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookstore.entity.Book;

public class BookDAO  extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO() {
		/*super(entitymanager);*/
		// TODO Auto-generated constructor stub
	}
	@Override
	public Book create(Book book) {
		book.setBookLastUpdated(new Date());
		return super.create(book);
	}
	@Override
	public Book update(Book book) {
		book.setBookLastUpdated(new Date());
		return super.update(book);	
		
		}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object id) {
		super.delete(Book.class, id);
		
	}

	@Override
	public List<Book> listAll() {	
		return super.findWithNamedQuery("Book.findAll");
	}
	public List<Book> listByCategory(int catId){
		return super.findWithNamedQuery("Book.findByCategory", "catId", catId);
		
	}
    
	public List<Book> newBookList(){
		/*Query query=entitymanager.createNamedQuery("Book.listNewBook);
				//createQuery();
		query.setFirstResult(0);
		query.setMaxResults(4);*/
		return super.findWithNamedQuery("Book.listNewBook", 0, 4);
		
	}
	
	@Override
	public long count() {
		return super.counWithNamedQuery("Book.countAll");
	}
	
	public Book findByTitle(String bookTitle) {
		List<Book> bookResult=super.findWithNamedQuery("Book.findBytitle", "bookTitle", bookTitle);
		
		if(!bookResult.isEmpty()){
			return bookResult.get(0);
		}
		return null;
		
		
	}
	
	public List<Book> search(String keyword){
		return super.findWithNamedQuery("Book.search", "keyword", keyword);
	}

}
