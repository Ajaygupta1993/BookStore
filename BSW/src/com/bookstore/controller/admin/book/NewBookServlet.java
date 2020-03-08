package com.bookstore.controller.admin.book;

import com.bookstore.base.controller.BaseServlet;
import com.bookstore.service.book.BookService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/new_book")
public class NewBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public NewBookServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService  bookservice = new BookService(request,response);
		bookservice.showNewBookForm();
		
	}

}
