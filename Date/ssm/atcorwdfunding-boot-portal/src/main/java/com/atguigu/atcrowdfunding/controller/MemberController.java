package com.atguigu.atcrowdfunding.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.MemberCert;
import com.atguigu.atcrowdfunding.bean.Ticket;
import com.atguigu.atcrowdfunding.service.ActivitiService;
import com.atguigu.atcrowdfunding.service.MemberService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.Datas;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private ActivitiService activitiService;

	@ResponseBody
	@RequestMapping("/uploadCertFile")
	public Object uploadCertFile(HttpSession session, Datas ds) {
		start();
		try {
			// 获取session域中的loginMember
			Member loginMember = (Member) session.getAttribute(Const.LOGIN_MEMBER);

			// 获取资质权限
			List<MemberCert> memberCertList = ds.getMemberCertList();
			//循环完成之后文件就另存为，再把数据传到远程服务作为表(t_memebr_cert)保存起来
			for (MemberCert memberCert : memberCertList) {
				//从每一次循环中拿到上传的文件，下一步生成一个新的文件名，另存为就可以
				MultipartFile certFile = memberCert.getCertFile();
				
				//拿到原始的文件名
				String originalFilename = certFile.getOriginalFilename();
				
				//拿到原始文件的扩展名比如：.jpg,用subString(startIndex ,endIndex),lastIndexOf(".")拿到点的索引值，
				//传到subString里就可以拿到点后面的东西
				String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
				
				//通过UUID拿到扩展名之前的文件名
				String filename = UUID.randomUUID().toString() + extname;
				
				//将文件上传到硬盘路径下 ，拿到路径，要在路径最后加上"/"，构成路径加上文件名
				String path = "D:/server/resources/atcrowdfunding/pics/cert/";
				
				//文件另存为用transferTO为一个新的对象
				certFile.transferTo(new File(path + filename));
				
				//将拼出的文件名set进memberCert里当memberService保存的时候就有文件名
				memberCert.setIconpath(filename);
				
				//文件已经保存到硬盘路径下，就不要上传到服务器上，所以设置成null
				memberCert.setCertFile(null);
				
				//从当前session中找到这个人，把这个人保存进服务器
				memberCert.setMemberid(loginMember.getId());
			}
			//把这些属性保存到表里面
			memberService.saveMemberCertList(memberCertList);

			success(true);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
			message(e.getMessage());
		}
		return end();
	}

	@ResponseBody
	@RequestMapping("/updateBasicinfo")
	public Object updateBasicinfo(HttpSession session, Member member) {
		start();
		try {
			Member loginMember = (Member) session.getAttribute(Const.LOGIN_MEMBER);

			loginMember.setRealname(member.getRealname());
			loginMember.setCardnum(member.getCardnum());
			loginMember.setTel(member.getTel());

			session.setAttribute(Const.LOGIN_MEMBER, loginMember); // Session共享,需要同步redis缓存数据.
			int count = memberService.updateBasicinfo(loginMember);

			success(count == 1);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
			message(e.getMessage());
		}
		return end();
	}

	@ResponseBody
	@RequestMapping("/updateAccttype")
	public Object updateAccttype(HttpSession session, String accttype) {
		start();
		try {
			Member loginMember = (Member) session.getAttribute(Const.LOGIN_MEMBER);
			loginMember.setAccttype(accttype);
			session.setAttribute(Const.LOGIN_MEMBER, loginMember); // 在Session共享中,改变了什么，就一定要set值进去,需要同步redis缓存数据.
			int count = memberService.updateAccttype(loginMember);
			success(count == 1);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
			message(e.getMessage());
		}

		return end();
	}

	@RequestMapping("/apply")
	public String apply(HttpSession session, Map<String, Object> map) {
		// 1.实名认证申请
		// ①跳转页面
		// ②判断流程单是否存在：查询流程单（memberid， status条件查询）

		Member loginMember = (Member) session.getAttribute(Const.LOGIN_MEMBER);
		Ticket ticket = memberService.getTicketByMemberid(loginMember.getId());
		if (ticket == null) {
			// 不存在：
			// 启动流程实例，启动流程实例前需要部署流程，画流程图
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("loginacct", loginMember.getLoginacct());
			String piid = activitiService.startProcessInstance(paramMap);
			// 保存流 程单
			ticket = new Ticket();
			ticket.setMemberid(loginMember.getId());
			ticket.setPiid(piid);
			ticket.setPstep("accttype");
			ticket.setStatus("0");

			memberService.saveTicket(ticket);
			// 跳转页面，同步请求
			return "member/accttype";
		} else {
			// 存在：
			// 需要根据流程单步骤， 跳转到相应步骤继续申请
			String pstep = ticket.getPstep();
			if ("accttype".equals(pstep)) {
				return "member/accttype";
			} else if ("basicinfo".equals(pstep)) {
				return "member/basicinfo";
			} else if ("uploadfile".equals(pstep)) {
				List<Cert> certList = memberService.queryCertByAccttype(loginMember.getAccttype());
				map.put("certList", certList);

				return "member/uploadfile";
			} else if ("checkemail".equals(pstep)) {
				return "member/checkemail";
			} else if ("authcode".equals(pstep)) {
				return "member/authcode";
			}
		}

		return "member/accttype";
	}
}
