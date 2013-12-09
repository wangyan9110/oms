package com.iflytek.oms.pms.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品类
 * @author wangyan9110
 *
 */
public class Product implements Serializable {

	/**
	 * 序列化版本标志
	 */
	private static final long serialVersionUID = 98734378783433L;

	/**
	 * 产品编号
	 */
	private Integer productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 每单位的数量
	 */
	private String quantityPerUnit;
	
	/**
	 * 库存量
	 */
	private Integer unitsInStock;
	
	/**
	 * 订出量
	 */
	private Integer unitsOnOrder;
	
	/**
	 * 单位价格
	 */
	private BigDecimal unitPrice;
	
	/**
	 * 重订购标准
	 */
	private Integer reorderLevel;
	
	/**
	 * 是否停止生产
	 */
	private Boolean discontinued;
	
	/**
	 * 供货商编号
	 */
	private Integer supplierId;

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
	 * 获取quantityPerUnit 
	 * @return quantityPerUnit
	 */
	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	/**
	 * 设置quantityPerUnit
	 * @param quantityPerUnit quantityPerUnit
	 */
	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	/**
	 * 获取unitsInStock 
	 * @return unitsInStock
	 */
	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	/**
	 * 设置unitsInStock
	 * @param unitsInStock unitsInStock
	 */
	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	/**
	 * 获取unitsOnOrder 
	 * @return unitsOnOrder
	 */
	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	/**
	 * 设置unitsOnOrder
	 * @param unitsOnOrder unitsOnOrder
	 */
	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
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
	 * 获取reorderLevel 
	 * @return reorderLevel
	 */
	public Integer getReorderLevel() {
		return reorderLevel;
	}

	/**
	 * 设置reorderLevel
	 * @param reorderLevel reorderLevel
	 */
	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	/**
	 * 获取discontinued 
	 * @return discontinued
	 */
	public Boolean getDiscontinued() {
		return discontinued;
	}

	/**
	 * 设置discontinued
	 * @param discontinued discontinued
	 */
	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

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
}
