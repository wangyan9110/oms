
package com.iflytek.oms.main.domain;

import java.io.Serializable;

/**
 * 联系人信息
 * @author wangyan9110
 *
 */
public class Contact implements Serializable{

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = 3534543543L;

	/**
	 * 职位
	 */
	private String title;
	
	/**
	 * 称呼
	 */
	private String name;
	
	/**
	 * 电话
	 */
	private String phone;
	
	/**
	 * 传真
	 */
	private String fax;

	/**
	 * 获取title 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置title
	 * @param title title
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * 获取phone 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone
	 * @param phone phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取fax 
	 * @return fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * 设置fax
	 * @param fax fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}	
}
