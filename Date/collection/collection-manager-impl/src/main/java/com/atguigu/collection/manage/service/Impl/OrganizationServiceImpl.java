package com.atguigu.collection.manage.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.atguigu.collection.bean.SysOrganization;
import com.atguigu.collection.manage.dao.OrganizationDao;
import com.atguigu.collection.manage.service.OrganizationService;
import com.vaadin.terminal.gwt.server.AbstractCommunicationManager.Request;

import freemarker.ext.servlet.HttpSessionHashModel;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationDao orgDao;

	@Override
	public int saveSysList(SysOrganization sysOrganization) {

		return orgDao.insert(sysOrganization);
	}

	
	
	public HashMap<String, Object> getOrgList() {
		
		// 格式化日期时间类型 "yyyy-MM-dd HH:mm:ss"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SysOrganization organization = new SysOrganization();

	
		List<Map<String, Object>> list = new ArrayList<>();
		
		// 从数据库中查询后接收数据类型
		List<SysOrganization> orgdata = new ArrayList<>();

		orgdata = orgDao.queryOrgList();

		for (SysOrganization org : orgdata) {
	
			// 创建treegrid识别的键值对
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", org.getId());
			map.put("name", org.getName());

			if (org.getType() == 0) {
				map.put("type", "总公司");
			} else {
				map.put("type", "分公司");
			}
			map.put("_parentId", org.getParentId());
			map.put("code", org.getCode());
			map.put("principalId", org.getPrincipalId());
			map.put("address", org.getAddress());
			map.put("phone", org.getPhone());
			map.put("postCode", org.getPostCode());
			map.put("fax", org.getFax());
			
			if (org.getCreateTime() != null) {
				map.put("createTime", sdf.format(org.getCreateTime()));
			} else {
				map.put("createTime", org.getCreateTime());
			}

			if (org.getModifyTime() != null) {
				map.put("modifyTime", sdf.format(org.getModifyTime()));
			} else {
				map.put("modifyTime", org.getModifyTime());
			}

			list.add(map);

		}
		
		
		// 封装返回treegrid的总数据
		HashMap<String, Object> hashMap = new HashMap();
		hashMap.put("rows",list);
		
		
		return hashMap;
	}



}
