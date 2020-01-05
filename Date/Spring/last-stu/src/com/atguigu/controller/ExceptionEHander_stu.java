package com.atguigu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionEHander_stu {

	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e){
		System.out.println("@ControllerAdvice---Exception");
		ModelAndView modelAndView = new ModelAndView("forward:/error.jsp");
		modelAndView.addObject("exception",e);
		return modelAndView;
	}
}
