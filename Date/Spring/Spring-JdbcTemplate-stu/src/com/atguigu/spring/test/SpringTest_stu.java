package com.atguigu.spring.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.dao.EmployeeDao_stu;
import com.atguigu.pojo.Employee;

@ContextConfiguration(locations = "classpath:application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest_stu {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private EmployeeDao_stu employeeDao;

	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("jdbc连接：" + dataSource.getConnection());
	}

	@Test
	public void testJdbcTemplate() {
		System.out.println("jdbcTemplate:   " + jdbcTemplate);
	}

	@Test
	public void test2() {
		String sql = "update employee set salary = ? where id= ?";
		int update = jdbcTemplate.update(sql, new BigDecimal(1300), 5);
		System.out.println(update);
	}

	@Test
	public void test3() {
		String sql = "insert into `employee` (`name`,`salary`) values(?,?)";
		List<Object[]> argsList = new ArrayList<Object[]>();
		argsList.add(new Object[] { "aaa", new BigDecimal(111) });
		argsList.add(new Object[] { "bbb", new BigDecimal(222) });
		argsList.add(new Object[] { "ccc", new BigDecimal(333) });

		jdbcTemplate.batchUpdate(sql, argsList);
	}

	@Test
	public void test4(){
		String sql = "select `id`, `name`, `salary` from employee where id = ?";
		Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 1);
		System.out.println(employee);
	}

	@Test
	public void test5(){
		String sql = "select `id`,`name`,`salary` from employee where salary > ?";
		List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class),new BigDecimal(4000));
		System.out.println(employees);
	}
	
	@Test
	public void test6(){
		String sql = "select max(salary) from employee";
		BigDecimal maxSalary = jdbcTemplate.queryForObject(sql, BigDecimal.class);
		System.out.println(maxSalary);
	}
	
	@Test
	public void test7(){
		String sql = "insert into `employee`(`name`, `salary`) values(:name, :salary)";
		Map<String, Object> param = new HashMap<String , Object>();
		param.put("name", "这是具名的name");
		param.put("salary", new BigDecimal(3000));
		namedParameterJdbcTemplate.update(sql, param);
	}
	
	@Test
	public void test8(){
		String sql = "insert into `employee`(`name`,`salary`) values(:name, :salary)";
		Employee employee = new Employee(null,
				"这是使用BeanPropertySqlParameterSource插入的",new BigDecimal(300000));
		namedParameterJdbcTemplate.update(sql,new BeanPropertySqlParameterSource(employee));
	}
	
	@Test
	public void test9(){
		employeeDao.saveEmployee(new Employee(null, "这是Dao插入的数据", new BigDecimal(30000)));
	}
	
	
	
	
	
	
	
	
	
}
