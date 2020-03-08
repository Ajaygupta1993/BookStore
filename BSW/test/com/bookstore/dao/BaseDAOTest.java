package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
	protected static EntityManagerFactory entitymanagerfactory;
	protected static EntityManager entitymanager;

	public static void setUpClass() {
		entitymanagerfactory = Persistence.createEntityManagerFactory("BSW");
		entitymanager = entitymanagerfactory.createEntityManager();
	}
	
	public static void setDownClass() {
		entitymanager.clear();
		entitymanagerfactory.close();

	}
}
