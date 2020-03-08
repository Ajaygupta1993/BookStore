package com.bookstore.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.base.controller.BaseServlet;
import com.bookstore.service.book.BookService;


@WebServlet("/admin/edit_book")
public class EditBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	
	public EditBookServlet() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
BookService bookservice = new BookService( request, response);
		
		bookservice.editBook();
		
		
		
	}

}
