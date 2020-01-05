package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.pojo.Person;

public class SpringIOCTest_stu {
	
	@Test
	public void test7() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		Person person = (Person) applicationContext.getBean("p7");
		System.out.println(person);
	}

	@Test
	public void test8() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		Person p8 = (Person) applicationContext.getBean("p8");
		System.out.println(p8);
//		System.out.println( applicationContext.getBean("innerCar") );
	}

	@Test
	public void test21() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application2.xml");
		System.out.println( applicationContext.getBean("p21") );
		System.out.println( applicationContext.getBean("p21") );
		System.out.println( applicationContext.getBean("p21") );
		System.out.println( applicationContext.getBean("p21") );
	}
	
}
