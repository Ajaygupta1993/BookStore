package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.category.CategoryService;

@WebServlet("/admin/update_category")
public class UpdateServletCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UpdateServletCategory() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 CategoryService categoryservice = new CategoryService(request,response);
			
			categoryservice.updateCategory();

	}

}
