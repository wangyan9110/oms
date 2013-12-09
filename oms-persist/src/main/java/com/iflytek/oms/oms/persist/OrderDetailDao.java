package com.iflytek.oms.oms.persist;

import java.util.List;

import com.iflytek.framework.mybatis.extra.MyBatisDao;
import com.iflytek.oms.main.persist.BaseDao;
import com.iflytek.oms.oms.domain.OrderDetail;

/**
 * 订单详情数据访问对象
 * @author wangyan9110
 *
 */
@MyBatisDao
public interface OrderDetailDao extends BaseDao<OrderDetail, Integer> {
	
	/**
	 * 根据订单编号查询订单详情
	 * @param orderId 订单编号
	 * @return 订单详情
	 */
	List<OrderDetail> selectOrderDetailsByOrderId(Integer orderId);
	
	/**
	 * 根据订单编号产品编号删除订单明细中的产品
	 * @param detail 订单详情（包括订单编号，产品编号）
	 */
	void deleteOrderDetailByOrderIdAndProductId(OrderDetail detail);
	
	/**
	 * 根据订单编号删除订单详情
	 * @param orderId 订单编号
	 */
	void deleteOrderDetailsByOrderId(Integer orderId);
	
	/**
	 * 根据订单编号和产品编号查询订单详细信息
	 * @param od 订单详细信息（订单编号及产品编号）
	 * @return 订单详情
	 */
	OrderDetail selectOrderDetailByOrderIdAndProductId(OrderDetail od);
}
