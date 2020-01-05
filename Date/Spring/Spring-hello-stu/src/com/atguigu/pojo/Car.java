package com.atguigu.pojo;

public class Car {

	private int id;
	private String name;

	public Car(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + "]";
	}

}
