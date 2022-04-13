package com.quickstart.webservice.users;

public class User {
	
	private String firstName;
	private String secondName;
	private String address;
	
	public User() {
		
	}
	
	public User(String firstName, String secondName, String address) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
