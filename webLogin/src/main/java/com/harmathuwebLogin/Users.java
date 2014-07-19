package com.harmathuwebLogin;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Users")
public class Users {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column (name="firstname")
	private String firstName;
	
	@Column (name="lastname")
	private String lastName;
	
	@Column (name="username")
	private String userName;
	
	@Column (name="password")
	private String passWord;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
