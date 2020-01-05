package com.atguigu.atcrowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.MemberCert;
import com.atguigu.atcrowdfunding.bean.Ticket;
import com.atguigu.atcrowdfunding.service.MemberService;

/*
 * @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，
 * 返回json数据不需要在方法前面加@ResponseBody注解了，但使用@RestController
 * 这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
 */
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService ;
	
	 
	@RequestMapping("/member/saveMemberCertList")
	public void saveMemberCertList(@RequestBody List<MemberCert> memberCertList) {
		memberService.saveMemberCertList(memberCertList);
	}
	
	@RequestMapping("/member/queryCertByAccttype/{accttype}")
	public List<Cert> queryCertByAccttype(@PathVariable("accttype") String accttype){
		return memberService.queryCertByAccttype(accttype);
	}
	
	@RequestMapping("/member/updateBasicinfo")
	public int updateBasicinfo(@RequestBody Member loginMember) {
		return memberService.updateBasicinfo(loginMember);
	}
	
	@RequestMapping("/member/updateAccttype")
	public int updateAccttype(@RequestBody Member loginMember) {
		return memberService.updateAccttype(loginMember);
	}
	
	@RequestMapping("/member/getTicketByMemberid/{memberid}")
	public Ticket getTicketByMemberid(@PathVariable("memberid") Integer memberid) {
		return memberService.getTicketByMemberid(memberid);
	}
	
	@RequestMapping("/member/saveTicket")
	public void saveTicket(@RequestBody Ticket ticket) {
		memberService.saveTicket(ticket);
	}
	
	@RequestMapping("/queryMemberByLogin/{loginacct}")
	public Member queryMemberByLoginacct(@PathVariable("loginacct") String loginacct) {
		return memberService.queryMemberByLogin(loginacct);//在java程序中做密码判断验证
	}
}
