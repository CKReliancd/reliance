package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.pojo.Person;

public class SpringIOCTest_stu {
	
	@Test
	public void test1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		Object bean = applicationContext.getBean("p1");
		System.out.println("bean"+ bean);
	}

	
}
