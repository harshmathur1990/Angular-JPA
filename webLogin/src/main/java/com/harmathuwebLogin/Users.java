package com.harmathuwebLogin;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Users {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	
	public Users() {
		super();
	}

	public Users(String firstName, String lastName, String userName,
			String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
	}

	private String firstName;
	
	
	private String lastName;
	
	@Column (unique = true)
	private String userName;
	
	
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
	
	@Override
	public java.lang.String toString() {
		String result = "{ \"firstName\" : \"" + this.firstName + "\" }";
		return result;
	}
}
