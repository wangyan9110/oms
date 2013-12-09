/**
 * 
 */
package com.iflytek.oms.main.domain;

import java.io.Serializable;

/**
 * 
 * 收货人信息
 * @author wangyan9110
 *
 */
public class ShipInfo implements Serializable{
	
	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = 23432424224L;

	/**
	 * 收货人姓名
	 */
	private String name;
	
	/**
	 * 地址
	 */
	private Address address;

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
}
