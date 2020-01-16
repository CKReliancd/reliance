package com.atguigu.atcrowdfunding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.atguigu.**.dao")
@EnableTransactionManagement
@SpringBootApplication
public class AtcrowdfundingBootMemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtcrowdfundingBootMemberServiceApplication.class, args);
	}
}