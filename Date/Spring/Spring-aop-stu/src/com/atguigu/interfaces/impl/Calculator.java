package com.atguigu.interfaces.impl;

import org.springframework.stereotype.Component;

import com.atguigu.interfaces.Calculate;

public class Calculator implements Calculate {

	@Override
	public int add(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("这是add加法");
		return result;
	}

	@Override
	public int sub(int num1, int num2) {
		int result = num1 - num2;
		System.out.println("这是sub减法");
		return result;
	}

	@Override
	public int mul(int num1, int num2) {
		int result = num1 * num2;
		System.out.println("这是mul乘法");
		return result;
	}

	@Override
	public int div(int num1, int num2) {
		int result = 0;
		result = num1 / num2;
		System.out.println("这是div除法");
		return result;
	}

}
