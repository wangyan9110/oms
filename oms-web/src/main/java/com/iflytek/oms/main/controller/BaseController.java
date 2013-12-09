
package com.iflytek.oms.main.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.iflytek.oms.main.dto.AjaxMessage;

/**
 * @author wangyan9110
 * 基础controller，简化一些基本操作
 */
public abstract class BaseController implements Serializable {

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = -90302432543205L;
	
	/**
	 * 日志
	 */
	@SuppressWarnings("unused")
	private static Logger logger;

	/**
	 * 基本构造函数
	 */
	protected BaseController(){
		logger=Logger.getLogger(getClass());
	}
	
	/**
	 * 重定向到指定url
	 * @param url 要跳转的url
	 * @return spring mvc跳转的url标志
	 */
	protected static String redirect(String url) {
		return String.format("redirect:%s", url);
	}
	
	/**
	 * 获取应用根目录
	 * @param request 请求信息
	 * @return 应用根目录
	 */
	protected static String getBasePath(HttpServletRequest request) {
		StringBuilder strBuilder=new StringBuilder();
		strBuilder.append(request.getScheme());
		strBuilder.append("://");
		strBuilder.append(request.getServerName());
		strBuilder.append(request.getServerPort());
		strBuilder.append(request.getContentLength());
		return strBuilder.toString();
	}
	
	/**
	 * 获取服务器项目的绝对路径
	 * @param request 请求流
	 * @return 绝对路径
	 */
	protected String getRealPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}
	
	/**
	 * 返回ajax正常信息对象
	 * @param msg 信息
	 * @return ajax信息对象
	 */
	protected static AjaxMessage ajaxInfo(String msg) {
		return AjaxMessage.getInstance(msg);
	}
	
	/**
	 * 返回ajax错误信息对象
	 * @param msg 信息
	 * @return ajax信息对象
	 */
	protected static AjaxMessage ajaxError(String msg) {
		return AjaxMessage.getInstance(AjaxMessage.ERROR, msg);
	}
	
	/**
	 * 返回ajax警告信息对象
	 * @param msg 警告信息
	 * @return ajax信息对象
	 */
	protected static AjaxMessage ajaxWarn(String msg) {
		return AjaxMessage.getInstance(msg);
	}
}
	
