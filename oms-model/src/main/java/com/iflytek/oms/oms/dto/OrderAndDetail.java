
package com.iflytek.oms.oms.dto;

import java.util.List;

/**
 * @author wangyan9110
 *
 */
public class OrderAndDetail {

	/**
	 * 订单编号
	 */
	private Integer orderId;
	
	/**
	 * 客户名称
	 */
	private String customerName;
	
	/**
	 * 客户电话
	 */
	private String customerPhone;
	
	/**
	 * 收货人
	 */
	private String shipName;
	
	/**
	 * 收货地址
	 */
	private String shipAddress;
	
	/**
	 * 负责人
	 */
	private String employeeName;
	
	/**
	 * 运费
	 */
	private String freight;
	
	/**
	 * 物流公司名称
	 */
	private String shipCompanyName;
	
	/**
	 * 订单详情
	 */
	private List<OrderDetailDto> details;

	/**
	 * 获取orderId 
	 * @return orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 获取customerPhone 
	 * @return customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * 设置customerPhone
	 * @param customerPhone customerPhone
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * 设置orderId
	 * @param orderId orderId
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取customerName 
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 设置customerName
	 * @param customerName customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 获取shipName 
	 * @return shipName
	 */
	public String getShipName() {
		return shipName;
	}

	/**
	 * 设置shipName
	 * @param shipName shipName
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	/**
	 * 获取shipAddress 
	 * @return shipAddress
	 */
	public String getShipAddress() {
		return shipAddress;
	}

	/**
	 * 设置shipAddress
	 * @param shipAddress shipAddress
	 */
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	/**
	 * 获取shipCompanyName 
	 * @return shipCompanyName
	 */
	public String getShipCompanyName() {
		return shipCompanyName;
	}

	/**
	 * 设置shipCompanyName
	 * @param shipCompanyName shipCompanyName
	 */
	public void setShipCompanyName(String shipCompanyName) {
		this.shipCompanyName = shipCompanyName;
	}

	/**
	 * 获取details 
	 * @return details
	 */
	public List<OrderDetailDto> getDetails() {
		return details;
	}

	/**
	 * 设置details
	 * @param details details
	 */
	public void setDetails(List<OrderDetailDto> details) {
		this.details = details;
	}

	/**
	 * 获取employeeName 
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * 设置employeeName
	 * @param employeeName employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * 获取freight 
	 * @return freight
	 */
	public String getFreight() {
		return freight;
	}

	/**
	 * 设置freight
	 * @param freight freight
	 */
	public void setFreight(String freight) {
		this.freight = freight;
	}
}
