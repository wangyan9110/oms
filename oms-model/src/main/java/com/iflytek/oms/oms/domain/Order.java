
package com.iflytek.oms.oms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.iflytek.oms.main.domain.ShipInfo;

/**
 * 订单类
 * @author wangyan9110
 *
 */
public class Order implements Serializable {

	/**
	 * 序列化版本信息
	 */
	private static final long serialVersionUID = 654553535352L;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 订单日期
	 */
	@NotEmpty
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDate;

	/**
	 * 到货日期
	 */
	@NotEmpty
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date requiredDate;

	/**
	 * 发货日期
	 */
	@NotEmpty
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date shippedDate;

	/**
	 * 运费
	 */
	@NotEmpty
	private BigDecimal freight;
	
	/**
	 * 员工编号
	 */
	@NotEmpty
	private Integer employeeId;
	
	/**
	 * 客户编号
	 */
	@NotEmpty
	private String customerId;
	
	/**
	 * 物流编号
	 */
	@NotEmpty
	private Integer shipperId;

	/**
	 * 收货人
	 */
	private ShipInfo ship;

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
	 * 获取orderDate 
	 * @return orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * 设置orderDate
	 * @param orderDate orderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * 获取requiredDate 
	 * @return requiredDate
	 */
	public Date getRequiredDate() {
		return requiredDate;
	}

	/**
	 * 设置requiredDate
	 * @param requiredDate requiredDate
	 */
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 * 获取shippedDate 
	 * @return shippedDate
	 */
	public Date getShippedDate() {
		return shippedDate;
	}

	/**
	 * 设置shippedDate
	 * @param shippedDate shippedDate
	 */
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * 获取freight 
	 * @return freight
	 */
	public BigDecimal getFreight() {
		return freight;
	}

	/**
	 * 设置freight
	 * @param freight freight
	 */
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

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
	 * 获取ship 
	 * @return ship
	 */
	public ShipInfo getShip() {
		return ship;
	}

	/**
	 * 设置ship
	 * @param ship ship
	 */
	public void setShip(ShipInfo ship) {
		this.ship = ship;
	}
}
