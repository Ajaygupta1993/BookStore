package com.bookstore.service.book;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookService {
	private EntityManagerFactory entitymanagerfactory;
	private EntityManager entitymanager;
	private BookDAO bookdao;
	private CategoryDAO categorydao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/*public BookService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entitymanagerfactory = Persistence.createEntityManagerFactory("BSW");
		entitymanager = entitymanagerfactory.createEntityManager();
		bookdao = new BookDAO();
	}*/

	public BookService( HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entitymanagerfactory = Persistence.createEntityManagerFactory("BSW");
		entitymanager = entitymanagerfactory.createEntityManager();
		bookdao = new BookDAO();
		categorydao = new CategoryDAO();
	}

	public void bookList() throws ServletException, IOException {
		listbook(null);
	}

	public void listbook(String message) throws ServletException, IOException {
		List<Book> listBook = bookdao.listAll();
		request.setAttribute("listBook", listBook);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String catogrPage = "book_list.jsp";
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(catogrPage);
		requestdispatcher.forward(request, response);

	}

	public void showNewBookForm() throws ServletException, IOException {
		List<Category> listCategory = categorydao.listAll();

		request.setAttribute("listCategory", listCategory);

		String newPage = "book_form.jsp";
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(newPage);
		requestdispatcher.forward(request, response);

	}

	public void createBook() throws IOException, ServletException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		Book existBook = bookdao.findByTitle(title);
		if (existBook != null) {
			String message = "Could not create the book because   " + title + " Title is already exist";
			listbook(message);
			return;
		}

		String auther = request.getParameter("auther");
		String isbn = request.getParameter("isbn");
		String descreption = request.getParameter("descreption");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date publishDate = null;
		try {
			publishDate = dateformat.parse(request.getParameter("pblishDate"));
		} catch (ParseException e) {
			new ServletException("Error parsing in publish date");
		}
		Book newBook = new Book();
		// readBookfileds(newBook);

		newBook.setBookTitle(title);
		newBook.setBookAuther(auther);
		newBook.setBookIsbn(isbn);
		newBook.setBookDescription(descreption);
		newBook.setBookPrice(price);
		newBook.setBookPublishDate(publishDate);
		Category category = categorydao.get(categoryId);
		newBook.setCategory(category);

		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageByte = new byte[(int) size];
			InputStream inputstream = part.getInputStream();
			inputstream.read(imageByte);
			inputstream.close();
			newBook.setBookImage(imageByte);
		}
		Book createdBook = bookdao.create(newBook);
		if (createdBook.getBookId() > 0) {
			String message = "A new Book created Sucessfully";
			listbook(message);

		}

	}

	public void editBook() throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookdao.get(bookId);
		List<Category> listCategory = categorydao.listAll();
		request.setAttribute("listCategory", listCategory);
		String editbook = "book_form.jsp";
		request.setAttribute("book", book);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(editbook);
		requestdispatcher.forward(request, response);

	}

	/*public void readBookfileds(Book newBook) throws IOException, ServletException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String auther = request.getParameter("auther");
		String isbn = request.getParameter("isbn");
		String descreption = request.getParameter("descreption");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date publishDate = null;
		try {
			publishDate = dateformat.parse(request.getParameter("pblishDate"));
		} catch (ParseException e) {
			new ServletException("Error parsing in publish date");
		}
		
		newBook.setBookTitle(title);
		newBook.setBookAuther(auther);
		newBook.setBookIsbn(isbn);
		newBook.setBookDescription(descreption);
		newBook.setBookPrice(price);
		newBook.setBookPublishDate(publishDate);
		Category category = categorydao.get(categoryId);
		newBook.setCategory(category);

		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageByte = new byte[(int) size];
			InputStream inputstream = part.getInputStream();
			inputstream.read(imageByte);
			inputstream.close();
			newBook.setBookImage(imageByte);
		}
		Book createdBook = bookdao.create(newBook);
		if (createdBook.getBookId() > 0) {
			String message = "A new Book created Sucessfully";
			listbook(message);

		}
	}*/

	public void updateBook() throws IOException, ServletException {
		Integer bookId = Integer.parseInt(request.getParameter("bookid"));
		Book existBook = bookdao.get(bookId);
		String title = request.getParameter("title");
		Book existBookBytitle = bookdao.findByTitle(title);
		if (!existBook .equals(existBookBytitle)) {
			String message = "Could not Update this because bcz this title is already exist   " ;//Title is already exist";
			listbook(message);
			return;
		}
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String auther = request.getParameter("auther");
		String isbn = request.getParameter("isbn");
		String descreption = request.getParameter("descreption");
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date publishDate = null;
		try {
			publishDate = dateformat.parse(request.getParameter("pblishDate"));
		} catch (ParseException e) {
			new ServletException("Error parsing in publish date");
		}

		existBook.setBookTitle(title);
		existBook.setBookAuther(auther);
		existBook.setBookIsbn(isbn);
		existBook.setBookDescription(descreption);
		existBook.setBookPrice(price);
		existBook.setBookPublishDate(publishDate);
		Category category = categorydao.get(categoryId);
		existBook.setCategory(category);

		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageByte = new byte[(int) size];
			InputStream inputstream = part.getInputStream();
			inputstream.read(imageByte);
			inputstream.close();
			existBook.setBookImage(imageByte);
		}
		bookdao.update(existBook);

		String message = "A  Book Updated Sucessfully";
		listbook(message);

	}

	public void deleteBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		bookdao.delete(bookId);
		String message = "This  Book is  Deleted Sucessfully";
		listbook(message);
		
		
		
	}
	
	public void listBookByCategory() throws ServletException, IOException {
		Integer catId = Integer.parseInt(request.getParameter("id"));
		System.out.println("=========catId==============="+catId);
		List<Book> listBook=bookdao.listByCategory(catId);
		Category category=categorydao.get(catId);
		List<Category> listCategory=categorydao.listAll();
		
		request.setAttribute("listBook", listBook);
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("category", category);
		String newPage="frontend/book_list_category.jsp";
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(newPage);
		requestdispatcher.forward(request, response);
	}

	public void viewBookDetail() throws ServletException, IOException {
		System.out.println("====================RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr");
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book=bookdao.get(bookId);
		List<Category> listCategory=categorydao.listAll();
		String viewBookPage="frontend/book_detail.jsp";
		request.setAttribute("book", book);
		request.setAttribute("listCategory", listCategory);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(viewBookPage);
		requestdispatcher.forward(request, response);
		
		
		
	}

	public void searchBook() throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		List<Book> result=null;
		String searchResultPage="frontend/search_result.jsp";
		
		if(keyword=="") {
			result=bookdao.listAll();
		}
		else {
			result=bookdao.search(keyword);
			
		}
		request.setAttribute("result", result);
		request.setAttribute("keyword", keyword);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(searchResultPage);
		requestdispatcher.forward(request, response);
		
	}
}
