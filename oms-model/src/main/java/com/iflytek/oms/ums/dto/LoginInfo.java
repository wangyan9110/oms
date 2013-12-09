package com.iflytek.oms.ums.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 登录信息
 * @author wangyan9110
 *
 */
public class LoginInfo {

	/**
	 * 用户名
	 */
	@NotEmpty
	private String userName;
	
	/**
	 * 密码
	 */
	@NotEmpty
	private String password;
	
	/**
	 * 是否记住密码
	 */
	private boolean remember;

	/**
	 * 获取userName 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置userName
	 * @param userName userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取password 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取remember 
	 * @return remember
	 */
	public boolean isRemember() {
		return remember;
	}

	/**
	 * 设置remember
	 * @param remember remember
	 */
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
}
