
package com.iflytek.oms.ums.dto;

/**
 * @author wangyan9110
 *
 */
public class SessionInfo {

	/**
	 * 用户编号
	 */
	private Integer userId;
	
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 构造器
	 * @param userId 用户编号
	 * @param name 姓名
	 */
	public SessionInfo(Integer userId,String name){
		this.userId=userId;
		this.name=name;
	}
	
	/**
	 * 获取userId 
	 * @return userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置userId
	 * @param userId userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取name 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置name
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
