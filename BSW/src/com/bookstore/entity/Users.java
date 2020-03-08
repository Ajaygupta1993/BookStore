package com.bookstore.entity;
// Generated 25 Jan, 2020 4:13:21 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity

@NamedQueries({
	@NamedQuery(name = "Users.findAll" , query="SELECT u FROM  Users u ORDER BY u.userId"),
	@NamedQuery(name = "Users.findByEmail" , query="SELECT u FROM  Users u where u.userEmail = :userEmail"),
	//@NamedQuery(name = "Users.countAll" , query="SELECT count(*) from Users u "),
	@NamedQuery(name = "Users.checkLogin" , query="SELECT u FROM  Users u where u.userEmail = :email and u.userPassword=:password"),
	
	
})
		
		

@Table(name = "users", catalog = "boobkstore")
public class Users implements java.io.Serializable {

	private Integer userId;
	private String userEmail;
	private String userPassword;
	private String userName;

	public Users() {
	}

	public Users(String userEmail, String userPassword, String userName) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
	}
	public Users(Integer userid,String userEmail, String userPassword, String userName) {
		this(userEmail,userPassword,userName);
		this.userId=userid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "USER_EMAIL", length = 30)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_PASSWORD", length = 16)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "USER_NAME", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
