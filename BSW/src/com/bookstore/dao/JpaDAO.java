package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO<E> {
	private static EntityManagerFactory entitymanagerfactory;
	static {
		entitymanagerfactory =Persistence.createEntityManagerFactory("BSW");
	}

	public JpaDAO() {
		
	}

	public E create(E entity) {
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(entity);
		entitymanager.flush();
		entitymanager.refresh(entity);
		entitymanager.getTransaction().commit();
		return entity;
	}

	public E update(E entity) {
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entity = entitymanager.merge(entity);
		entitymanager.getTransaction().commit();
		return entity;
	}

	public E find(Class<E> type, Object id) {
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		E entity = entitymanager.find(type, id);
		if(entity !=null) {
		entitymanager.refresh(entity);
		}
		return entity;

	}

	public void delete(Class<E> type, Object id) {
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Object refernce = entitymanager.getReference(type, id);
		entitymanager.remove(refernce);
		entitymanager.getTransaction().commit();

	}
	public List<E> findWithNamedQuery(String queryName){
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		Query query=entitymanager.createNamedQuery(queryName);
		return query.getResultList();
		
		
	}
	
	
	public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResult){
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		Query query=entitymanager.createNamedQuery(queryName);
		return query.getResultList();
		
		
	}
	
	
	
	
	public List<E> findWithNamedQuery(String queryName,Map<String, Object> parameter){
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		Query query=entitymanager.createNamedQuery(queryName);
		Set<Entry<String,Object>> setParems=     parameter.entrySet();
		
		for(Entry<String,Object> entry: setParems) {
			query.setParameter(entry.getKey(), entry.getValue());
			
		}
		return query.getResultList();
		
	
	}
	
	public List<E> findWithNamedQuery(String queryName,String paramName,Object paramValue ){
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		Query query=entitymanager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		
		return query.getResultList();
		
	
	}
	
	
	public long counWithNamedQuery(String query) {
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		Query queryName=entitymanager.createNamedQuery(query);
		long result= (long)  queryName.getSingleResult();
		
		return result;
		
	}
	public void close() {
		if(entitymanagerfactory !=null) {
			System.out.println("===============ssssssssssssssssss");
			entitymanagerfactory.close();
			
		}
		System.out.println("===entitymanagerfactory===="+entitymanagerfactory.hashCode());
	}

}
