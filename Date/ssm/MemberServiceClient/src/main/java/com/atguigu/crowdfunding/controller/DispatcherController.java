package com.atguigu.crowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowdfunding.client.MemberClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DispatcherController {
	
	@Autowired
	private MemberClient memberClient;
	
	@HystrixCommand(fallbackMethod="testError")
	@RequestMapping("/test")
	public String test() {
		return memberClient.test();
	}
	
	public String testError() {
		return "Server Error...";
	}
}
