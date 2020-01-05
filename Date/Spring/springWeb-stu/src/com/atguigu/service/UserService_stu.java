package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.dao.UserDao_stu;

@Service
public class UserService_stu {

	@Autowired
	private UserDao_stu userDao_stu;
	
	public void updateUser(){
		userDao_stu.updateUser();
	}

}
