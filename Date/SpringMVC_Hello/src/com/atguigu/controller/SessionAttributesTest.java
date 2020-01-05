package com.atguigu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @SessionAttributes放在类上；
 * 效果：以前用map，model，modelmap保存的数据同时给session中保存一份
 * value=""：指定某些key；
 * @SessionAttributes(value="msg")：只要key是msg。不管保存的是什么给session域中放一份
 * types={String.class}：只要是string类型的，不管key是什么，都给session域中保存一份；
 * 
 * 
 * 
 * 我们建议，给session域中放数据，传入原生API；
 * 
 * @author lfy
 *
 */
@SessionAttributes(value={"msg","user","info"},types={String.class})
@Controller
public class SessionAttributesTest {
	
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Model model,HttpSession session){
		model.addAttribute("msg", "哈哈哈");
		model.addAttribute("abc", "嘿嘿");
		session.setAttribute("stand", "哈哈哈哈哈");
		return "WEB-INF/success";
	}

}
