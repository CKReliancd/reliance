package com.atguigu.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private int id;
	private String name;
	private String phone;
	private int age;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String phone, int age) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", age=" + age + "]";
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
