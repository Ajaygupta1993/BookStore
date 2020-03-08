package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDaoTest extends BaseDAOTest {
	
	private static UserDao userdao;

	@BeforeClass
	public static void setUpClass() {
		BaseDAOTest.setUpClass();
		userdao = new UserDao();
	}

	@Test
	public void testCreateUsers() {
		Users users = new Users();
		users.setUserEmail("manu@mail.com");
		users.setUserName("Manukumar");
		users.setUserPassword("abcdef");

		users = userdao.create(users);

		assertTrue(users.getUserId() > 0);
	}

	@Test
	public void testCeateUserWithoutData() {
		Users users = new Users();
		userdao = new UserDao();
		users = userdao.create(users);

	}
	@Test
	public void updateUser() {
		Users users = new Users();
		users.setUserId(1);
		users.setUserEmail("update@mail.com");
		users.setUserName("Update");
		users.setUserPassword("56789");
		users=userdao.update(users);
		String excepted="56789";
		String actual=users.getUserPassword();
		assertEquals(excepted, actual);
		
		
		
	}
	@Test
	public void testUserFound() {
		Integer id=1;
		Users users=userdao.get(id);
		assertNotNull(users);
	}
	
	@Test
	public void testUserNotFound() {
		Integer id=99;
		Users users=userdao.get(id);
		
		assertNotNull(users);
	}
	@Test
	public void testDeleteUser() {
		Integer userId=16;
		userdao.delete(userId);
		Users users = userdao.get(userId);
		assertNull(users);
		
	}
	@Test(expected =EntityNotFoundException.class)
	public void testDeleteUserNotExist() {
		Integer id=99;
		userdao.delete(id);
	}
	@Test
	public void testcheckLoginSucess() {
		String email="ritik@mail.com";
		String password="ritu";
		boolean loginResult=userdao.checkLogin(email, password);
		assertTrue(loginResult);
		
		
	}
	
	@Test
	public void testcheckLoginFail() {
		String email="ri@mail.com";
		String password="ritu";
		boolean loginResult=userdao.checkLogin(email, password);
		assertFalse(loginResult);
		
		
	}
	
	
	
	
	@Test
	public void testListAllUser() {
		List<Users> users=userdao.listAll();
		assertTrue(users.size()>0);
	}
	
	@Test
	public void testExistingMail() {
		String email="finaluser@mail.com";
		Users users=userdao.findByEmail(email);
		assertNotNull(users);
	}

	@AfterClass
	public static void setDownClass() {
		BaseDAOTest.setDownClass();

	}

}
