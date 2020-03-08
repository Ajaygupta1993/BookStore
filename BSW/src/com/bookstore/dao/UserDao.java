package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDao extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDao() {
		/*super(entitymanager);*/
	}
	@Override
	public Users create(Users users) {
		return super.create(users);

	}

	@Override
	public Users update(Users users) {
		return super.update(users);
	}

	@Override
	public Users get(Object userId) {
		
		return super.find(Users.class, userId);
	}
      public Users findByEmail(String email) {
    	  List<Users>  listUsers=super.findWithNamedQuery("Users.findByEmail","userEmail",email);
    	  
    	  if(listUsers !=null && listUsers.size()>0) {
    		  return  listUsers.get(0);
    	  }
    	 return null;
      }
	@Override
	public void delete(Object id) {
		super.delete(Users.class, id);

	}

	@Override
	public List<Users> listAll() {
		
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean checkLogin(String email,String password) {
		Map<String, Object> parameter= new HashMap<>();
		parameter.put("email", email);
		parameter.put("password", password);
		List<Users> userList=super.findWithNamedQuery("Users.checkLogin", parameter);
		if(userList.size() == 1) {
			return true;
		}
		
		return false;
		
	}

}
