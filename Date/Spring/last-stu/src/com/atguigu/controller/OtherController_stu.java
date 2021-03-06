package com.atguigu.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.nio.cs.ext.ISCII91;

import com.atguigu.pojo.Person;

@Controller
public class OtherController_stu {

	@RequestMapping(value = "/upload")
	public String upload(String username, MultipartFile photo) {
		System.out.println("用户名：" + username);
		if (photo != null && !photo.isEmpty()) {
			try {
				// transferTo 将文件写入到硬盘位置
				// getOriginalFilename
				photo.transferTo(new File("e:\\" + photo.getOriginalFilename()));
			} catch (IllegalStateException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "forward:/index.jsp";
	}

	@ResponseBody
	@RequestMapping(value = "/queryPersonById")
	public Person queryPersonById() {
		return new Person(19, "name10", new Date(), "chengmotong@qq.com",
				new BigDecimal(100));
	}

	@ResponseBody
	@RequestMapping(value = "/personList")
	public List<Person> personList() {
		List<Person> list = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			list.add(new Person(i, "name" + i, new Date(), "chuzihang@qq.com",
					new BigDecimal(100)));
		}
		return list;
	}

	@RequestMapping(value = "/requestBody")
	public String requestBody(@RequestBody String body) {
		System.out.println("请求体的全部内容：" + body);
		return "forward:/index.jssp";
	}

	@RequestMapping(value = "/httpEntity")
	public String httpEntity(HttpEntity<String> httpEntity) {
		System.out.println("请求头：" + httpEntity.getHeaders());
		System.out.println("请求头：" + httpEntity.getBody());
		return "forward:/index.jsp";
	}

	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpSession session) {
		try {
			ServletContext ctx = session.getServletContext();
			InputStream is = ctx.getResourceAsStream("/img/e.jpg");
			byte[] buffer;
			buffer = new byte[is.available()];
			is.read(buffer);
			is.close();
			// 获取需要下载的文件的数据类型
			String mimeType = ctx.getMimeType("/imgs/e.jpg");
			// 响应头
			HttpHeaders httpHeaders = new HttpHeaders();
			// 添加响应头，告诉客户端返还的数据类型
			httpHeaders.add("Content-Type", mimeType);
			httpHeaders.add("Content-Disposition", "attachment;filename=e.jpg");
			// 第一个参数是你要返回的数据--我们要实现文件下载，就需要把下载的文件字节内容都放body中
			// 第二个参数是 响应头
			// 第三个参数是你要返回的响应状态码和响应 状态描述 符
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(
					buffer, httpHeaders, HttpStatus.OK);

			return responseEntity;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@RequestMapping(value="/hello")
	public String hello() {
		System.out.println("目标方法执行…………");
//		int i = 12 / 0;
		Integer i = null;
		i.intValue();
		return "forward:/target.jsp";
	}
}
