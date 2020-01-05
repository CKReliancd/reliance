package com.atguigu.pojo;

public class User {

	private Integer id;
	private String username;
	private int money;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String username, int money) {
		super();
		this.id = id;
		this.username = username;
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", money=" + money
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
