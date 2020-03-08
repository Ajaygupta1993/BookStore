package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest extends BaseDAOTest {
	private static BookDAO bookdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpClass();
		bookdao = new BookDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.setDownClass();
		
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book book = new Book();
		Category category = new Category("JAVA8");

		category.setCategoryId(5);
		book.setCategory(category);
		book.setBookTitle("Java 8 in Action: ");
		book.setBookAuther("Joshua Bloch");
		book.setBookDescription(
				"Java 8 in Action is a clearly written guide to the new features of Java 8. The book covers lambdas, streams, and functional-style programming. With Java 8's functional features you can now write more concise code in less time, and also automatically benefit from multicore architectures. It's time to dig in!");
				
		book.setBookIsbn("1617291994");
		book.setBookPrice(36.72f);
		DateFormat dateformat = new SimpleDateFormat("MM/dd/YYYY");
		Date publishDate = dateformat.parse("08/28/2014");
		book.setBookPublishDate(publishDate);
		String imagePath = "C:\\Users\\AJAY\\Desktop\\book\\books\\Java 8 in Action.jpg";
		byte[] imageByte = Files.readAllBytes(Paths.get(imagePath));
		book.setBookImage(imageByte);
		Book createdBook = bookdao.create(book);
		assertTrue(createdBook.getBookId() > 0);

	}

	@Test
	public void testUpdate() throws ParseException, IOException {
		Book existbook = new Book();
		existbook.setBookId(2);
		Category category = new Category("PYTHON2");
		category.setCategoryId(5);
		existbook.setCategory(category);
		existbook.setBookTitle("Effective PYTHON (4th Edition)");
		existbook.setBookAuther("Ajay Bloch");
		existbook.setBookDescription(
				"Are you looking for a deeper understanding of the Python™ programming language so that you can write code that is clearer, more correct, more robust, and more reusable? Look no further! Effective Python™, Second Edition, brings together seventy-eight indispensable programmer’s rules of thumb: working, best-practice solutions for the programming challenges you encounter every day.");
		existbook.setBookIsbn("0321356683");
		existbook.setBookPrice(38.8f);
		DateFormat dateformat = new SimpleDateFormat("MM/dd/YYYY");
		Date publishDate = dateformat.parse("05/06/2010");
		existbook.setBookPublishDate(publishDate);
		String imagePath = "C:\\Users\\AJAY\\Desktop\\book\\books\\Effective Java.jpg";
		byte[] imageByte = Files.readAllBytes(Paths.get(imagePath));
		existbook.setBookImage(imageByte);
		Book updatedBook = bookdao.update(existbook);
		assertEquals(existbook.getCategory().getCategoryId(), updatedBook.getCategory().getCategoryId());

	}
	@Test
	public void testGet() {
    	Integer bookId=4;
    	Book book= bookdao.get(bookId);
    	assertNotNull(book);
    }
    @Test(expected = EntityNotFoundException.class)
    public void testDelete() {
    	Integer bookId=100;
    	bookdao.delete(bookId);
    	assertTrue(true);
    	
    }
    @Test
    public void testListAllBook() {
    	List<Book >book=bookdao.listAll();
		assertTrue(book.size()>0);
    }
    @Test
    public void testFindByTitle() {
    	String title="Java 8 in Action:";
    	Book resultBook=bookdao.findByTitle(title);
    	assertNotNull(resultBook);
    }
    @Test
    public void testFindByTitleNotExist() {
    	String title="PHP CORE:";
    	Book resultBook=bookdao.findByTitle(title);
    	assertNull(resultBook);
    }
    @Test
    public void testListNewBook() {
    	List<Book> listNewBook= bookdao.newBookList();
    
    	assertEquals(listNewBook.size(),4);
    }
    @Test
    public void count() {
    	long count=bookdao.count();
		assertEquals(2, count);
    }
    @Test
    public void testFindByCategory() {
    	int categgoryId=5;
    	List<Book> booklist=bookdao.listByCategory(categgoryId);
    	assertTrue(booklist.size()>0);
    }
    @Test
    public void testSearchBookByTitle() {
    	String keyword="spring";
    	List<Book> searchResult=bookdao.search(keyword);
    	assertEquals(1, searchResult.size());
    	
    }
    @Test
    public void testSearchBookByAuther() {
    	String keyword="Riru";
    	List<Book> searchResult=bookdao.search(keyword);
    	assertEquals(1, searchResult.size());
    	
    }
    @Test
    public void testSearchBookByDescription() {
    	String keyword="this is basic bok for IIT";
    	List<Book> searchResult=bookdao.search(keyword);
    	assertEquals(1, searchResult.size());
    	
    }
    
}
