package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;


@WebFilter("/*")
public class CommanFilter implements Filter {
    
	private final CategoryDAO categoryDAO;
    
    public CommanFilter() {
    	categoryDAO= new CategoryDAO();
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		String path=httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		System.out.println("CommanFilter:::Path===="+path);
		if(!path.startsWith("/admin/")) {
		List<Category> listCategory=categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		System.out.println(":::CommanFilter::");
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
