package com.atguigu.atcrowdfunding.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.member.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/queryMemberByLogin/{loginacct}")
	public Member queryMemberByLoginacct(@PathVariable("loginacct") String loginacct) {
		return memberService.queryByLoginacct(loginacct);
	}
}
