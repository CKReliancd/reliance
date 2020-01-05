package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.atguigu.pojo.Employee;

@Repository
public class EmployeeDao_stu extends JdbcDaoSupport {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
	
	@Autowired
	public void setjdbcTemplate2(JdbcTemplate jdbcTemplate){
		setJdbcTemplate(jdbcTemplate);
	}
	

	public int saveEmployee(Employee employee) {
		String sql = "insert into `employee`(`name`,`salary`) values(?,?)";
		return getJdbcTemplate().update(sql, employee.getName(),
				employee.getSalary());
	}


	
}
