package com.example.demo;

public class User {
	
	private String name,family;
	private int age;
	public User(String name, String family, int age) {
		super();
		this.name = name;
		this.family = family;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
