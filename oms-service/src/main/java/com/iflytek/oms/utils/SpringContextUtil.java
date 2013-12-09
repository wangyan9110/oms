package com.iflytek.oms.utils;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.ApplicationContextAware; 
	
 /** 
  * 获取spring容器，以访问容器中定义的其他bean 
  */
public class SpringContextUtil implements ApplicationContextAware {

	/**
	 * spring 应用上下文
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext 应用上下文
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象
	 * 这里重写了bean方法，起主要作用
	 * @param name bean的key
	 * @return Object 一个以所给名字注册的bean的实例
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

}


