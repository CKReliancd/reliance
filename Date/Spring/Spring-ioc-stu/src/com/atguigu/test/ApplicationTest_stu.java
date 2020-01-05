package com.atguigu.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.pojo.Person;

public class ApplicationTest_stu {

	@Test
	public void test1() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void test2() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		Person person = (Person) applicationContext.getBean("personEL");
		System.out.println(person);
	}

	@Test
	public void test3(){
		boolean a = true;

		boolean b = false;

		System.out.println(a || b);
	}
}
