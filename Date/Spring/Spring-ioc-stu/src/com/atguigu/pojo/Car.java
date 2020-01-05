package com.atguigu.pojo;

public class Car {
	private String name;
	private String carNo;

	public String fun1() {
		return "这是非静态方法的返回值";
	}
	
	public static String staticFun() {
		return "这是**静态方法**的值";
	}
	
	public Car(String name, String carNo) {
		super();
		this.name = name;
		this.carNo = carNo;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", carNo=" + carNo + "]";
	}

}
