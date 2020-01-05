package com.atguigu.atcrowdfunding.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.MemberCert;
import com.atguigu.atcrowdfunding.bean.Ticket;
import com.atguigu.atcrowdfunding.dao.MemberDao;
import com.atguigu.atcrowdfunding.service.ActivitiService;
import com.atguigu.atcrowdfunding.service.MemberService;

@Service
@Transactional()
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private ActivitiService activitiService ;
	
	@Override
	public Member queryMemberByLogin(String loginacct) {

		return memberDao.queryMemberByLogin(loginacct);
	}

	@Override
	public Ticket getTicketByMemberid(Integer memberid) {

		return memberDao.getTicketByMemberid(memberid);
	}

	@Override
	public void saveTicket(Ticket ticket) {
		memberDao.saveTicket(ticket);
	}

	@Override
	public int updateAccttype(Member loginMember) {
		//1.更新账户类型
		int count = memberDao.updateAccttype(loginMember);
		//2.更新流程单步骤
		Ticket ticket = memberDao.getTicketByMemberid(loginMember.getId());
		ticket.setPstep("basicinfo");
		memberDao.updateTicketPstep(ticket);
		//3.完成当前任务节点
		Map<String,Object> variables = new HashMap<String,Object>();
		//记录是哪一个委托人
		variables.put("loginacct", loginMember.getLoginacct());
		//记录完成哪一个流程实例
		variables.put("piid", ticket.getPiid());
		activitiService.completeTask(variables);
		
		return count;
	}

	@Override
	public int updateBasicinfo(Member loginMember) {
		//1、更新基本信息
		int count = memberDao.updateBasicinfo(loginMember);
		//2、更新流程单步骤
		Ticket ticket = memberDao.getTicketByMemberid(loginMember.getId());
		ticket.setPstep("uploadfile");
		memberDao.updateTicketPstep(ticket);
	
		
		//3.完成当前任务节点
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("loginacct", loginMember.getLoginacct());
		variables.put("piid", ticket.getPiid());
		variables.put("flag", true);
		
		activitiService.completeTask(variables);
		return count;
	}

	@Override
	public List<Cert> queryCertByAccttype(String accttype) {

		return memberDao.queryCertByAccttype(accttype);
	}

	@Override
	public void saveMemberCertList(List<MemberCert> memberCertList) {
		//??
		MemberCert memberCert = memberCertList.get(0);
		
		//获取MemberCert实例里的memberid
		Integer memberid = memberCert.getMemberid();
		
		//从t_member里获取"memberid"情况下的全部数据
		Member member = memberDao.getMemberById(memberid);
		
		//1.保存会员与资质关系表数据
		memberDao.saveMemberCertList(memberCertList);
		
		//2.更新流程单步骤
		//从t_ticket表里获取status = '0'和"memberid"情况下的全部数据
		Ticket ticket = memberDao.getTicketByMemberid(memberid);
		
		//保存checkemail
		ticket.setPstep("checkemail");
		//更新t_ticket表里id=#{id}"时的Pstep
		memberDao.updateTicketPstep(ticket);
		
		//3.完成当前任务节点
		Map<String, Object> variables = new HashMap<String,Object>();
		
		//从t_member表里获取"id=#{memberid}"情况下全部数据里的Loginacct
		variables.put("loginacct", member.getLoginacct());
		
		//从t_ticket表里获取"memberid=#{memberid}and status = '0'"情况下的Piid
		variables.put("piid", ticket.getPiid());
		
		//设flag的值是true
		variables.put("flag", true);
		
		//提交
		activitiService.completeTask(variables);
	}

}
