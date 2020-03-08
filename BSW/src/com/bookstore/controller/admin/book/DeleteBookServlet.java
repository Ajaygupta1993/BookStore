package com.bookstore.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.base.controller.BaseServlet;
import com.bookstore.service.book.BookService;


@WebServlet("/admin/delete_book")
public class DeleteBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteBookServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		System.out.println("=========bookId========="+bookId);
       BookService bookservice = new BookService(request, response);
		
		bookservice.deleteBook();
		
	}

}
