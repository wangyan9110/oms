/**
 * 
 */
package com.iflytek.oms.main.domain;

import java.io.Serializable;

/**
 * 员工名
 * @author wangyan9110
 *
 */
public class EmployeeName implements Serializable {

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = 689798798789781L;
	
	/**
	 * 姓
	 */
	private String firstName;
	
	/**
	 * 名
	 */
	private String lastName;

	
	
	/**
	 * 获取firstName 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * 设置firstName
	 * @param firstName firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * 获取lastName 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * 设置lastName
	 * @param lastName lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return this.lastName+this.firstName;
	}

}
