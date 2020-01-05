package com.atguigu.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(value="prototype")
@Repository(value="bookDao_stu")
public class BookDao_stu {
	public BookDao_stu(){
		System.out.println("初始化BookDao_stu");
	}
}
