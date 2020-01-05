package com.atguigu.atcrowdfunding.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("atcrowdfunding-activiti-service")
public interface ActivitiService {

	/**
	 * 启动流程实例
	 * @param 包含，当前会员账号名称（用于第一个任务节点流程变量）
	 * @return 流程实例id
	 */
	@RequestMapping("/act/startProcessInstance")
	public String startProcessInstance(Map<String, Object> paramMap);
	
}
