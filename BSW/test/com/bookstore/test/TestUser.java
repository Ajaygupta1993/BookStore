package com.bookstore.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class TestUser {
	public static void main(String[] args) {
		Users users= new Users();
		users.setUserEmail("ajay@mail.com");
		users.setUserName("Gupta");
		users.setUserPassword("password");
		
		
		
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("BSW");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(users);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		entitymanagerfactory.close();
		System.out.println("Inserted");
		
		
		
	}

}
