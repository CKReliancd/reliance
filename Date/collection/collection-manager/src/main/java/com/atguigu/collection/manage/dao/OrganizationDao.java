package com.atguigu.collection.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atguigu.collection.bean.SysOrganization;

@Repository
public interface OrganizationDao {

	List<SysOrganization> queryOrgList();

	List<SysOrganization> queryParentName();

	int insert(SysOrganization sysOrganization);

}
