package com.cybage.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String address;
	private int salary;

//	constructor - for constructor injection
	public Employee() {
		
	}
	
	public Employee(int id, String name, String email, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}
	
	
//	getter and setter - forsetter injection
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

//	generating toString method
	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getAddress()=" + getAddress() + ", getSalary()=" + getSalary() + "]";
	}
	
//	life cycle events
	@PostConstruct
	public void init() {
		System.out.println("after construction of Object...");
	}
	
	@PreDestroy
	public void BeforeDestroy() {
		System.out.println("Before destroying of Object...");

	}
	
}