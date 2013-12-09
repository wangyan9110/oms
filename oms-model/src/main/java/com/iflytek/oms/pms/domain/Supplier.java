package com.iflytek.oms.pms.domain;

import java.io.Serializable;

import com.iflytek.oms.main.domain.Address;
import com.iflytek.oms.main.domain.Contact;

/**
 * 供货商类
 * @author wangyan9110
 *
 */
public class Supplier implements Serializable {

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = 4324324322L;

	/**
	 * 供货商编号
	 */
	private Integer supplierId;
	
	/**
	 * 公司名
	 */
	private String companyName;
	
	/**
	 * 联系人
	 */
	private Contact contact;
	
	/**
	 * 地址
	 */
	private Address address;
	
	/**
	 * 主页
	 */
	private String homePage;

	/**
	 * 获取supplierId 
	 * @return supplierId
	 */
	public Integer getSupplierId() {
		return supplierId;
	}

	/**
	 * 设置supplierId
	 * @param supplierId supplierId
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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

	/**
	 * 获取homePage 
	 * @return homePage
	 */
	public String getHomePage() {
		return homePage;
	}

	/**
	 * 设置homePage
	 * @param homePage homePage
	 */
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
}
