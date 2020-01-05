package com.atguigu.atcrowdfunding.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.member.dao.MemberDao;
import com.atguigu.atcrowdfunding.member.service.MemberService;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public Member queryByLoginacct(String loginacct) {

		return memberDao.queryByLoginacct(loginacct);
	}

}
