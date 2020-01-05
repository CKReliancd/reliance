package com.atguigu.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import com.atguigu.service.TransactionService_stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest_stu {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TransactionService_stu TransactionService_stu;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println(dataSource.getConnection());
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
