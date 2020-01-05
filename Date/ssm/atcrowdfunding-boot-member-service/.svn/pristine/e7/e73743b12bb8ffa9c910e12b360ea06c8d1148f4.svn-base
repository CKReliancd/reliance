package com.atguigu.atcrowdfunding.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.atguigu.**.dao")

@EnableDiscoveryClient 
@SpringBootApplication
public class AtcrowdfundingBootMemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtcrowdfundingBootMemberServiceApplication.class, args);
	}
}
