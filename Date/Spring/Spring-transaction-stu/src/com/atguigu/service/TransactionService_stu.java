package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.dao.BookDao_stu;
import com.atguigu.dao.UserDao_stu;

@Service
public class TransactionService_stu {

	@Autowired
	private UserDao_stu userDao_stu;
	
	@Autowired
	private BookDao_stu bookDao_stu;
	
	public void updateTwoTable(){
		
		userDao_stu.updateUser();
		bookDao_stu.updateBook();
	}
	
	
}
