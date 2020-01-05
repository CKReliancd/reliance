package com.atguigu.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient 
@SpringBootApplication
public class MemberServiceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceServerApplication.class, args);
	}
}
