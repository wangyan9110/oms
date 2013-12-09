
package com.iflytek.oms.oms.domain;

import java.io.Serializable;

/**
 * 物流公司
 * @author wangyan9110
 *
 */
public class Shipper implements Serializable {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 32543243242L;

	/**
	 * 物流公司编号
	 */
	private Integer shipperId;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 获取shipperId 
	 * @return shipperId
	 */
	public Integer getShipperId() {
		return shipperId;
	}

	/**
	 * 设置shipperId
	 * @param shipperId shipperId
	 */
	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
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
}
