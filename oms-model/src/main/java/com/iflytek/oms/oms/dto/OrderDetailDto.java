
package com.iflytek.oms.oms.dto;

import java.math.BigDecimal;

/**
 * 订单详情dto
 * @author wangyan9110
 *
 */
public class OrderDetailDto {
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	
	/**
	 * 数量
	 */
	private Integer quantity;
	
	/**
	 * 订单编号
	 */
	private Integer orderId;
	
	/**
	 * 产品编号
	 */
	private Integer productId;

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
	 * 获取productId 
	 * @return productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * 设置productId
	 * @param productId productId
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * 获取productName 
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置productName
	 * @param productName productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 获取unitPrice 
	 * @return unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 设置unitPrice
	 * @param unitPrice unitPrice
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 获取quantity 
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 设置quantity
	 * @param quantity quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
