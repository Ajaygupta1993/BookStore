package com.bookstore.base.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected EntityManagerFactory entitymanagerfactory;
	protected EntityManager entitymanager;
	
	public void init()throws ServletException {
		entitymanagerfactory =Persistence.createEntityManagerFactory("BSW");
		entitymanager=entitymanagerfactory.createEntityManager();
		
	}
	public void destroy() {
		entitymanager.close();
		entitymanagerfactory.close();
	}

}
