package com.atguigu.atcrowdfunding.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.MemberCert;
import com.atguigu.atcrowdfunding.bean.Ticket;

@FeignClient("atcrowdfunding-member-service")
public interface MemberService {
	@RequestMapping("/queryMemberByLogin/{loginacct}")
	public Member queryMemberByLoginacct(@PathVariable("loginacct") String loginacct);
	
	@RequestMapping("/member/getTicketByMemberid/{memberid}")
	public Ticket getTicketByMemberid(@PathVariable("memberid") Integer memberid);
	
	@RequestMapping("member/saveTicket")
	public void saveTicket(@RequestBody Ticket ticket);
	
	@RequestMapping("/member/updateAccttype")
	public int updateAccttype(@RequestBody Member loginMember);

	@RequestMapping("/member/updateBasicinfo")
	public int updateBasicinfo(@RequestBody Member loginMember);

	@RequestMapping("/member/queryCertByAccttype/{accttype}")
	public List<Cert> queryCertByAccttype(@PathVariable("accttype") String accttype);

	@RequestMapping("/member/saveMemberCertList")
	public void saveMemberCertList(@RequestBody List<MemberCert> memberCertList);
}
