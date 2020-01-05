package com.atguigu.atcrowdfunding;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@ServletComponentScan		//扫描@WebServlet		@WebListener	@WebFilter 注解
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AtcorwdfundingBootPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtcorwdfundingBootPortalApplication.class, args);
	}
}
