package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.base.controller.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
@WebServlet("")
public class HomePageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HomePageServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO categorydao= new CategoryDAO();
		BookDAO bookdao = new BookDAO();
		List<Category> listCategory=categorydao.listAll();
		List<Book> listNewBook=bookdao.newBookList();
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listNewBook", listNewBook);
		String homePage="frontend/index.jsp";
		RequestDispatcher requestdispatcher=request.getRequestDispatcher(homePage);
		requestdispatcher.forward(request, response);
		
	}

}
