package com.atguigu.collection.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.collection.bean.SysOrganization;
import com.atguigu.collection.manage.service.OrganizationService;
import com.atguigu.collection.util.Const;
import com.mxgraph.shape.mxActorShape;

@Controller
public class indexController extends BaseController {

	@Autowired
	private OrganizationService orgService;

	
	@RequestMapping("/organization")
	public String organization() {
		
		return "organization";
	}
	
	@RequestMapping("/getOrganizationList")
	@ResponseBody
	public HashMap<String, Object> getOrganizationList(HttpSession session){
		
		HashMap<String, Object> sysOrgMap = orgService.getOrgList();
		
		List<Map<String, Object>> list = (List<Map<String, Object>>) sysOrgMap.get("rows");
		
		for (Map<String, Object> map : list) {
			String type = (String) map.get("type");
			if(type.equals("总公司")) {
				
				List<String> list2 = new ArrayList<>();
				list2.add((String)map.get("name"));
				
				
				session.setAttribute("parentName",list2);
				
				session.setAttribute("size", list2.size());
			}
		}
		
		System.out.println("parentName"+session.getAttribute("parentName"));
		
		return sysOrgMap;
	}
	
}
