package com.atguigu.interfaces.impl.test;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.interfaces.Calculate;

public class SpringTest_stu {

	private Calculate calculate;
	@Test
	public void test1(){
		System.out.println(Arrays.asList(calculate.getClass().getInterfaces()));
//		calculate.add(100, 200);
		System.out.println("+++++++++++++++++++++++++++");
		calculate.div(100, 0);
	}
	
	@Test
	public void test2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		Calculate calculate = (Calculate) applicationContext.getBean("calculator");
		calculate.add(100, 200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
