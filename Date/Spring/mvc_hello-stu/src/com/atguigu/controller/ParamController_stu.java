package com.atguigu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParamController_stu {

	@RequestMapping(value="param1")
	public String param1(HttpServletRequest request){
		System.out.println("这是param1方法");
		System.out.println(request);
		return "param";
	}
	@RequestMapping(value="param2")
	public String param2(HttpServletRequest request, HttpSession session){
		System.out.println("这是param2方法");
		System.out.println(request);
		System.out.println(session);
		return "param";
	}
	@RequestMapping(value="param3")
	public String param3(HttpServletRequest request, HttpServletResponse response , HttpSession session){
		System.out.println("这是param3方法");
		System.out.println(response);
		System.out.println(request);
		System.out.println(session);
		return "param";
	}
	@RequestMapping(value="param4")
	public String param3(HttpServletRequest request){
		System.out.println("这是param4方法");
		System.out.println(request.getParameter("username"));

		return "param";
	}
}
