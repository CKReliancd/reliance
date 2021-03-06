package com.atguigu.atcrowdfunding.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import com.atguigu.atcrowdfunding.util.Const;

/**
 * 监听ServletContext对象的创建和销毁。
 */
@WebListener	//声明监听器对象
@WebServlet		//声明Servlet对象
@WebFilter		//声明Filter对象
public class StartUpSystemListener implements ServletContextListener {

	//在服务器启动时创建ServletContext对象时执行此方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//将项目上下文路径存放到application域，给jsp使用  : ${APP_PATH}
		ServletContext applicataion = sce.getServletContext();
		String contextPath = applicataion.getContextPath();
		applicataion.setAttribute(Const.APP_PATH, contextPath);
	}

	//服务器停止或卸载项目时，ServletContext对象被销毁时执行此方法
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
