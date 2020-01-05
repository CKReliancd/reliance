package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.dao.BookDao_stu;

@Service
public class BookService_stu {
	
	@Autowired
	private BookDao_stu bookDao_stu;
	
	public void updateBook(){
		bookDao_stu.updateBook();
	}

}
