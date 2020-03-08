package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest extends BaseDAOTest {
	private static CategoryDAO categorydao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpClass();
		categorydao = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.setDownClass();
	}

	@Test
	public void testCreateCategory() {
		Category newCategory = new Category("python");
		Category category = categorydao.create(newCategory);
		assertTrue(category != null && category.getCategoryId() > 0);
	}
	@Test
	public void testupdate() {
		Category category = new Category("Advance java");
		category.setCategoryId(1);
		Category categoryforUpdate =	categorydao.update(category);
		assertEquals(category.getCategoryName(),categoryforUpdate.getCategoryName());
		
	}

	@Test
	public void testGet() {
		Integer id =2;
		Category category=categorydao.get(id);
		assertNotNull(category);
	}

	@Test
	public void testDeleteObject() {
		Integer catId=4;
		categorydao.delete(catId);
		Category category=categorydao.get(catId);
		
		
		assertNull(category);
		
	}
	

	@Test
	public void testListAll() {
		List<Category >category=categorydao.listAll();
		assertTrue(category.size()>0);

	}
		
	@Test
	public void testCount() {
		long count=categorydao.count();
		assertEquals(2, count);
	}

}
