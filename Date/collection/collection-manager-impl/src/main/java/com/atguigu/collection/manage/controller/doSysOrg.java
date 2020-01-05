package com.atguigu.collection.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.collection.bean.SysOrganization;
import com.atguigu.collection.controller.BaseController;
import com.atguigu.collection.manage.service.OrganizationService;
import com.atguigu.collection.util.Const;

@Controller
public class doSysOrg extends BaseController{

	@Autowired
	OrganizationService orgService;
	
	@ResponseBody
	@RequestMapping("/doAdd")
	public Object doAdd(SysOrganization sysOrganization) {
		start();
		try {
			int count = orgService.saveSysList(sysOrganization);
			success(count==1);
		} catch (Exception e) {
			success(false);
			message(Const.SAVE_DATA_ERROR);
			e.printStackTrace();
		}
		
		
		return end();
	}
	
}
