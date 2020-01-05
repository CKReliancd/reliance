package com.atguigu.collection.manage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.collection.bean.SysOrganization;

public interface OrganizationService {

	HashMap<String, Object> getOrgList();

	int saveSysList(SysOrganization sysOrganization);


}
