package com.atguigu.atcrowdfunding.member.service;

import com.atguigu.atcrowdfunding.bean.Member;


public interface MemberService {

	Member queryByLoginacct(String loginacct);

}
