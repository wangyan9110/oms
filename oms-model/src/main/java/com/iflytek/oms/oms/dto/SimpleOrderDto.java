package com.iflytek.oms.oms.dto;

/**
 * 订单显示
 * @author wangyan9110
 *
 */
public class SimpleOrderDto {

	/**
	 * 订单编号
	 */
	private Integer orderId;
	
	/**
	 * 收货人
	 */
	private String shipName;
	
	/**
	 * 订单日期
	 */
	private String orderDate;
	
	/**
	 * 物流公司
	 */
	private String shipCompanyName;

	/**
	 * 获取orderId 
	 * @return orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 设置orderId
	 * @param orderId orderId
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	 * 获取orderDate 
	 * @return orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * 设置orderDate
	 * @param orderDate orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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
}
