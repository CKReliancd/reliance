package com.atguigu.atcrowdfunding.service;

import java.util.List;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.MemberCert;
import com.atguigu.atcrowdfunding.bean.Ticket;


public interface MemberService {

	
	//Member queryByLoginacct(String loginacct);
	Member queryMemberByLogin(String loginacct);
	
	Ticket getTicketByMemberid(Integer memberid);

	void saveTicket(Ticket ticket);

	int updateAccttype(Member loginMember);

	int updateBasicinfo(Member loginMember);

	List<Cert> queryCertByAccttype(String accttype);

	void saveMemberCertList(List<MemberCert> memberCertList);
	
	
	
	
	
	
	
}
