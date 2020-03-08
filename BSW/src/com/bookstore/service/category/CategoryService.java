package com.bookstore.service.category;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryService {
	private EntityManagerFactory entitymanagerfactory;
	private EntityManager entitymanager;
	private CategoryDAO categorydao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	

	public CategoryService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entitymanagerfactory = Persistence.createEntityManagerFactory("BSW");
		entitymanager = entitymanagerfactory.createEntityManager();
		categorydao = new CategoryDAO();
	}
	public void categoryList() throws ServletException, IOException {
		listCategory(null);
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categorydao.listAll();
		request.setAttribute("listCategory", listCategory);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String catogrPage = "category_list.jsp";
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(catogrPage);
		requestdispatcher.forward(request, response);

	}

	public void createCategory() throws ServletException, IOException {
		String categoryName = request.getParameter("category");
		Category category = new Category(categoryName);
		categorydao.create(category);
		listCategory("New Category Created sucessfully");

	}

	public void editCategory() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Category category = categorydao.get(userId);
		String editcategory = "category_form.jsp";
		request.setAttribute("category", category);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(editcategory);
		requestdispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("category");
		Category category = new Category(userId, categoryName);
		categorydao.update(category);
		String message = "category Updated sucessfully";
		listCategory(message);
	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		categorydao.delete(categoryId);
		String message = "Category deleted sucessfully";
		listCategory(message);

	}
}
