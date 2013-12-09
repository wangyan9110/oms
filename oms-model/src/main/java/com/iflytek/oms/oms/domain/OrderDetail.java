package com.iflytek.oms.oms.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单详情
 * @author wangyan9110
 *
 */
public class OrderDetail implements Serializable {

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = 5757865876867L;

	/**
	 * 订单编号
	 */
	private Integer orderId;
	
	/**
	 * 产品编号
	 */
	private Integer productId;
	
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	
	/**
	 * 数量
	 */
	private Integer quantity;
	
	/**
	 * 折扣
	 */
	private Float discount;

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

	/**
	 * 获取discount 
	 * @return discount
	 */
	public Float getDiscount() {
		return discount;
	}

	/**
	 * 设置discount
	 * @param discount discount
	 */
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
}
