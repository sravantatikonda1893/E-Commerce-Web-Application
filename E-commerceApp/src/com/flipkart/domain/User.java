package com.flipkart.domain;

public class User {
	String firstname;
	String lastname;
	String email;
	String username;
	String password;
	String mobileno;
	public User(String firstname, String lastname, String email, String username, String password, String mobileno) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	
	}
	public String getMobileno() {
		return mobileno;
	}
	}

	

