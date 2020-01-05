package com.atguigu.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.atguigu") 
@SpringBootApplication
public class AtCrowdfundingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtCrowdfundingApplication.class, args);
	}

}
