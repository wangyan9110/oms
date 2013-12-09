package com.iflytek.oms.oms.domain;

import java.io.Serializable;

import com.iflytek.oms.main.domain.Address;
import com.iflytek.oms.main.domain.Contact;

/**
 * 客户信息
 * @author wangyan9110
 *
 */
public class Customer implements Serializable {

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = 2432342321L;
	
	/**
	 *顾客编号 
	 */
	private String customerId;
	
	/**
	 * 公司名
	 */
	private String companyName;
	
	/**
	 * 联系人信息
	 */
	private Contact contact;
	
	/**
	 * 地址
	 */
	private Address address;

	/**
	 * 获取customerId 
	 * @return customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * 设置customerId
	 * @param customerId customerId
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * 获取companyName 
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置companyName
	 * @param companyName companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取contact 
	 * @return contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * 设置contact
	 * @param contact contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
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
