package com.atguigu.crowdfunding.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("eureka-member-service")
public interface MemberClient {
	@GetMapping("/test")
	String test(); 
}
