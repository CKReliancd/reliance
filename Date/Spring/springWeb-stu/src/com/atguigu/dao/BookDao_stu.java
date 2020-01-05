package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao_stu {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int updateBook(){
		String sql = "update book set name = `我被修改了` where id = 1";
		return jdbcTemplate.update(sql);
	}

}
