package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test1() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		System.out.println( applicationContext.getBean("bookDao_stu") );
		System.out.println( applicationContext.getBean("bookDao_stu") );
		System.out.println( applicationContext.getBean("bookDao_stu") );


	
	}
}
