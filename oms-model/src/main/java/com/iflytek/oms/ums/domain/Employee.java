
package com.iflytek.oms.ums.domain;

import java.io.Serializable;

import com.iflytek.oms.main.domain.Address;
import com.iflytek.oms.main.domain.EmployeeName;

/**
 * 员工类
 * @author wangyan9110
 *
 */
public class Employee implements Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 8993743834L;
	
	/**
	 * 员工编号
	 */
	private Integer employeeId;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 员工姓名
	 */
	private EmployeeName name;
	
	/**
	 * 地址
	 */
	private Address address;

	/**
	 * 获取employeeId 
	 * @return employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * 设置employeeId
	 * @param employeeId employeeId
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 获取name 
	 * @return name
	 */
	public EmployeeName getName() {
		return name;
	}

	/**
	 * 设置name
	 * @param name name
	 */
	public void setName(EmployeeName name) {
		this.name = name;
	}

	/**
	 * 获取address 
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * 设置address
	 * @param address address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

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
}
