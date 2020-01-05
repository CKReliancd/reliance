package com.atguigu.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private int id;
	private String name;
	private String phone;
	private int age;
	private Car car;
	private List<Object> list;
	private Map<String, Object> map;
	private Properties prop;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String phone, int age, Car car,
			List<Object> list, Map<String, Object> map, Properties prop) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.car = car;
		this.list = list;
		this.map = map;
		this.prop = prop;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", age=" + age + ", car=" + car + ", list=" + list + ", map="
				+ map + ", prop=" + prop + "]";
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
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	

}
