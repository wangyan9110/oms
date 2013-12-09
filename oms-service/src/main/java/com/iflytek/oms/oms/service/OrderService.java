package com.iflytek.oms.oms.service;

import java.util.List;

import com.iflytek.framework.pagination.PaginationResult;
import com.iflytek.oms.oms.domain.Order;
import com.iflytek.oms.oms.domain.OrderDetail;
import com.iflytek.oms.oms.dto.OrderDetailDto;
import com.iflytek.oms.oms.dto.OrderDto;
import com.iflytek.oms.oms.dto.SimpleOrderDto;
import com.iflytek.oms.oms.dto.OrderAndDetail;

/**
 * 订单服务接口
 * @author wangyan9110
 *
 */
public interface OrderService {

	/**
	 * 获取订单信息列表
	 * @param pageIndex 第几页
	 * @param pageSize 每页长度
	 * @return 本页订单信息
	 */
	PaginationResult<SimpleOrderDto> getPagedOrders(int pageIndex,int pageSize);
	
	/**
	 * 获取订单信息列表
	 * @param pageIndex 第几页
	 * @param pageSize 每页长度
	 * @param shipCompanyName 物流公司名称
	 * @return 本页订单信息
	 */
	PaginationResult<SimpleOrderDto> getPagedOrders(int pageIndex,int pageSize,String shipCompanyName);
	
	/**
	 * 根据订单编号获取订单摘要信息
	 * @param id 订单编号
	 * @return 订单信息
	 */
	SimpleOrderDto getSimpleOrderById(Integer id);
	
	/**
	 * 添加订单主信息，暂时存到cache
	 * @param id 用户编号
	 * @param order 订单主信息
	 */
	void addSimpleOrder(int id,Order order);
	
	/**
	 * 添加订单详情,暂时存到cache,更新产品信息
	 * @param id 用户编号
	 * @param orderDetail 订单详情信息
	 */
	void addOrderDetail(int id,OrderDetail orderDetail);
	
	/**
	 * 添加订单详情
	 * 直接持久化到数据库，更新产品信息
	 * @param orderDetail 订单详情
	 */
	void addOrderDetail(OrderDetail orderDetail);
	
	/**
	 * 添加订单信息(包括订单物流信息和订单明细)
	 * 先从cache中获取订单信息
	 * 如果添加失败增加产品信息
	 * @param id 用户编号
	 */
	void addOrder(int id);
	
	/**
	 * 更新订单信息(订单物流信息)
	 * @param order 订单信息
	 */
	void updateOrder(Order order);
	
	/**
	 * 删除订单信息
	 * 同时删除订单详情
	 * 注意增加相应的产品信息
	 * @param orderId 订单信息
	 */
	void delete(Integer orderId);
	
	/**
	 * 删除订单详情信息
	 * 注意增加相应的产品信息
	 * @param orderId 订单编号
	 * @param productId 产品编号
	 */
	void deleteOrderDetail(Integer orderId,Integer productId);
	
	/**
	 * 删除订单详情
	 * @param id 用户编号 
	 * @param productId 订单编号
	 */
	void deleteOrderDetail(int id,int productId);
	
	/**
	 * 根据订单编号获取订单详细信息
	 * @param orderId 订单编号
	 * @return 订单详细信息
	 */
	OrderAndDetail getOrderAndDetailsById(Integer orderId);
	
	/**
	 * 根据订单编号获取订单信息（包括订单物流信息和订单明细）
	 * @param orderId 订单编号
	 * @return 订单信息
	 */
	OrderDto getOrderOrderDtoById(Integer orderId);
	
	/**
	 * 根据订单编号获取订单信息
	 * @param orderId 订单编号
	 * @return 订单信息
	 */
	Order getOrderById(Integer orderId);
	
	/**
	 * 回滚产品数量
	 * @param orderDetails 订单明细
	 */
	void rebackProduct(List<OrderDetail> orderDetails);
	
	/**
	 * 根据订单编号获取订单编号
	 * orderDetailDto所有属性
	 * @param orderId 订单编号
	 * @return 订单详情
	 */
	List<OrderDetailDto> getOrderDetailByOrderId(Integer orderId);
}
