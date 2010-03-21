package com.wheelersoftware.demos.hibernatevalidator;

import javax.validation.Valid;

import org.hibernate.validator.constraints.*;



public class User {
	private String username;
	private String firstName;
	private String lastName;
	private Address address;
	private String email;
	private String password;

	@NotEmpty
	@Length(max = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty
	@Length(max = 20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotEmpty
	@Length(max = 20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Valid
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@NotEmpty
	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty
	@Length(max = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
