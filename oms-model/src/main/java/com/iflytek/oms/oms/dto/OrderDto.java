
package com.iflytek.oms.oms.dto;

import java.util.List;

import com.iflytek.oms.oms.domain.Order;
import com.iflytek.oms.oms.domain.OrderDetail;

/**
 * 订单类
 * @author wangyan9110
 *
 */
public class OrderDto {

	/**
	 * 订单信息
	 */
	private Order order;
	
	/**
	 * 订单详情
	 */
	private List<OrderDetail> orderDetails;

	/**
	 * 获取order 
	 * @return order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * 设置order
	 * @param order order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * 获取orderDetails 
	 * @return orderDetails
	 */
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * 设置orderDetails
	 * @param orderDetails orderDetails
	 */
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
