package com.atguigu.atcrowdfunding.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.atcrowdfunding.service.ActivitiService;
import com.atguigu.atcrowdfunding.util.Page;

@Controller
@RequestMapping("/process")
public class ProcessController extends BaseController {

	@Autowired
	private ActivitiService activitiService;

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/index")
	public String index() {
		return "process/index";
	}
	@RequestMapping("/view")
	public String view() {
		return "process/view";
	}
	
	
	@RequestMapping("/loadImg")
	public void loadImg(String pdid,HttpServletResponse resp) throws Exception { //流程定义表主键是字符串类型
		// 通过响应对象返回图形信息
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		 
		String url = "http://atcrowdfunding-activiti-service/act/loadImgById/"+pdid;
		ResponseEntity<byte[]> response = restTemplate.exchange( url, HttpMethod.POST,  new HttpEntity<byte[]>(headers), byte[].class); 
		
		byte[] result = response.getBody();
		 
		InputStream in = new ByteArrayInputStream(result);
		OutputStream out = resp.getOutputStream();
		 
		int i = -1;
		while ( (i = in.read()) != -1 ) {
			out.write(i);
		} 

	}

	@ResponseBody
	@RequestMapping("/uploadFile")
	public Object uploadFile(@RequestParam("procDefFile") MultipartFile file) {// 浏览器传给客户端
		start();
		
		try {
			// 获取的是表单中文件域的name属性值
			System.out.println(file.getName());
			// 获取传递文件的名称
			System.out.println(file.getOriginalFilename());

			String uuid = UUID.randomUUID().toString();
			String fileName = file.getOriginalFilename();
			// 客户端把文件传给远程的服务项目，不能再用feign方法，也就是不能用ActivitiService接口
			final File tempFile = File.createTempFile(uuid, fileName.substring(fileName.lastIndexOf(".")));

			file.transferTo(tempFile);// 另存为
			//把文件tempFile转换成FileSystemResource
			FileSystemResource resource = new FileSystemResource(tempFile);
			
			MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
			//封装进MultiValueMap
			param.add("pdfile", resource);
			
			/**
			 * 	调用restTemple里的postForObject方法向"http://atcrowdfunding-activiti-service/act/deploy"发起请求
			 *	传输的文件放在MultiValueMap集合里，param
			 *	String.class表示我调远程方法返回的类型，就是一个字符串消息
			 */

			String s = restTemplate.postForObject("http://atcrowdfunding-activiti-service/act/deploy", param, String.class);
			System.out.println("result string = " + s);
			//远程部署完成，临时文件也就没有了
			tempFile.delete();

			success(true);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
		}

		return end();
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteDeployement")
	public Object deleteDeployement(String deployid) {// 浏览器传给客户端
		start();
		
		try {
			
			activitiService.deleteDeployement(deployid);
			
			success(true);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
		}
		
		return end();
	}

	
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery(Integer pageno, Integer pagesize) {
		start();

		try {
			Page<Map<String, Object>> page = new Page<Map<String, Object>>(pageno, pagesize);

			Integer totalsize = activitiService.queryProDefCount();

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("startIndex", page.getStartindex());
			paramMap.put("pagesize", pagesize);

			List<Map<String, Object>> datas = activitiService.queryProDefList(paramMap);

			page.setDatas(datas);
			page.setTotalsize(totalsize);

			data(page);

			success(true);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
		}

		return end();
	}

}
