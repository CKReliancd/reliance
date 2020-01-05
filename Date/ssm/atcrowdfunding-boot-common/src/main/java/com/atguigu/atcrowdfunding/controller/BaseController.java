package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

	//Map<String,Object> result ; //控制器对象是单例的，成员变量是被多个线程并发访问，所以存在线程安全问题。
	
	ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String,Object>>();
	
	public void start() {
		Map<String,Object> result = new HashMap<String,Object>();
		threadLocal.set(result);//存放到当前线程的ThreadLocalMap中。
	}
	
	public void success(boolean success) {		
		threadLocal.get().put("success", success);
	}
	
	public void message(String message) {
		threadLocal.get().put("message", message);
	}
	
	public void data(Object data) {
		threadLocal.get().put("data", data);
	}
	
	public Object end() {
		return threadLocal.get() ;
	}
	
}
