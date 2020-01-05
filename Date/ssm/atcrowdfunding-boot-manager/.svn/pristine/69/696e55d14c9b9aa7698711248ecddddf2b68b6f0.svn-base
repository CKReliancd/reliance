package com.atguigu.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("atcrowdfunding-activiti-service")
public interface ActivitiService {

	@RequestMapping("/act/queryProDefCount")
	public Integer queryProDefCount();

	@RequestMapping("/act/queryProDefList")
	public List<Map<String, Object>> queryProDefList(@RequestBody Map<String,Object> paramMap) ;

	@RequestMapping("/act/deleteDeployement/{deployid}")
	public void deleteDeployement(@PathVariable("deployid") String deployeid);
	
}
