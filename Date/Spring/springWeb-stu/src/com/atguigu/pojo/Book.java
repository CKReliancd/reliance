package com.atguigu.pojo;

public class Book {

	private Integer id;
	private String name;
	private int stock;

	public Book(Integer id, String name, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", stock=" + stock + "]";
	}

}
