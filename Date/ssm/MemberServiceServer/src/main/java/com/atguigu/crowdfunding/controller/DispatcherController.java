package com.atguigu.crowdfunding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispatcherController {


	@RequestMapping("/test")
	public String test() {
		System.out.println("member service");
		return "member service!";
	}
}
