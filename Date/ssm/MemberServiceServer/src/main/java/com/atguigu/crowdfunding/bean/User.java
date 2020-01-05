package com.atguigu.crowdfunding.bean;

public class User {

	private Integer id;
	private String author;
	private Integer price;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String author, Integer price) {
		super();
		this.id = id;
		this.author = author;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", author=" + author + ", price=" + price + "]";
	}
	
}
