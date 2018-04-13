package com.ashwin.myapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mytable1")
public class User {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="age")
	private int age;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_name")
	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", password="
				+ password + ", username=" + username + "]";
	}

	public User(String firstname, String lastname, int age, String password, String username) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.password = password;
		this.username = username;
	}

	public User() {
		
	}
	
	
	
	
	
}
