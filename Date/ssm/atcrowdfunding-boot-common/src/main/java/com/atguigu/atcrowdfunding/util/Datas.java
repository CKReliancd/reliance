package com.atguigu.atcrowdfunding.util;

import java.util.ArrayList;
import java.util.List;

import com.atguigu.atcrowdfunding.bean.MemberCert;
import com.atguigu.atcrowdfunding.bean.User;

public class Datas {

	private List<Integer> ids = new ArrayList<Integer>();
	
	private List<User> userList = new ArrayList<User>();

	private List<MemberCert> memberCertList = new ArrayList<MemberCert>();
	
	public List<Integer> getIds() {
		return ids;
	}

	public List<MemberCert> getMemberCertList() {
		return memberCertList;
	}

	public void setMemberCertList(List<MemberCert> memberCertList) {
		this.memberCertList = memberCertList;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
	
}
