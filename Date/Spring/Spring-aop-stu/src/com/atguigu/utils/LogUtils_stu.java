package com.atguigu.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogUtils_stu {
	
	public static void pointcut1(){}
	
	public static void logBefore(JoinPoint jp) {
		System.out.println("【LogUtils】 目标方法之前是【" + jp.getSignature().getName()
				+ "】方法，然后参数" + Arrays.asList(jp.getArgs()));
	}

	public static void logAfterReturning(JoinPoint jp, Object result) {
		System.out.println("【LogUtils】目标方法 返回结果 是【 "
				+ jp.getSignature().getName() + "】方法，返回值是：" + result
				+ "，然后参数是：" + Arrays.asList(jp.getArgs()));
	}

	public static void logAfter() {
		System.out.println("【LogUtils】目标方法之后是【 method 】方法，然后参数是：");
	}

	
	public static void logAfterException(JoinPoint jp, Exception e) {
		System.out.println("【LogUtils】目标方法异常之后是【  " + jp.getSignature().getName() + " 】方法，异常信息是:" + e + "，然后参数是：" + Arrays.asList(jp.getArgs()));
	}
	
	public static Object around(ProceedingJoinPoint pjp) throws Throwable{
		Object result = null;
		try {
			try{
				System.out.println("这是环绕的前置通知");
				//执行目标方法
				result = pjp.proceed(pjp.getArgs());
			}finally{
				System.out.println("这是环绕的后置通知");
			}
			System.out.println("这是环绕的返回通知");
			return result;
		} catch (Exception e) {
			System.out.println("这是环绕的异常通知");
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
