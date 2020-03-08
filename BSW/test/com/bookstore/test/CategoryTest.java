package com.bookstore.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryTest {
	public static void main(String[] args) {
		Category category = new Category("Core java");
		
		
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("BSW");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(category);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		entitymanagerfactory.close();
		System.out.println("Inserted");
		
		
		
	}

}
