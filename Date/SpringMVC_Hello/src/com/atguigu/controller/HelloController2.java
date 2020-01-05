package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController2 {

	@RequestMapping("/hello1")
	public String hello1() {
		
		return "forward:/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2() {
		
		return "forward:/hello1";
	}
	
}
