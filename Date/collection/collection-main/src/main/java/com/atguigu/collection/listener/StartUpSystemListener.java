package com.atguigu.collection.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.atguigu.collection.util.Const;


public class StartUpSystemListener implements ServletContextListener{

    //在服务器启动时创建ServletContext对象时执行此方法
    @Override
    public void contextInitialized(ServletContextEvent sce){
        //将项目上下文路径存放到application域，给jsp使用：${APP_PATH}
        ServletContext appliction = sce.getServletContext();
        String contextPath = appliction.getContextPath();
        appliction.setAttribute(Const.APP_PATH,contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
