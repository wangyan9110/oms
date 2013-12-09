
package com.iflytek.oms.oms.persist;

import org.apache.ibatis.annotations.Param;

import com.iflytek.framework.mybatis.extra.MyBatisDao;
import com.iflytek.framework.pagination.PaginationCriteria;
import com.iflytek.framework.pagination.PaginationResult;
import com.iflytek.oms.main.persist.BaseDao;
import com.iflytek.oms.oms.domain.Order;

/**
 * 订单数据访问对象
 * @author wangyan9110
 *
 */
@MyBatisDao
public interface OrderDao extends BaseDao<Order, Integer> {
	
	/**
	 * 分页获取订单信息
	 * @param criteria 查询条件
	 * @return 订单列表
	 */
	PaginationResult<Order> selectPagedOrders(PaginationCriteria criteria);
	
	/**
	 * 分页获取订单信息
	 * @param criteria 查询条件
	 * @param shipperId 物流编号
	 * @return 订单列表
	 */
	PaginationResult<Order> selectPagedOrdersByShipperId(PaginationCriteria criteria,@Param("shipperId") Integer shipperId);
	
	/**
	 * 插入订单并返回订单编号
	 * @param order 订单信息
	 * @return 订单编号
	 */
	int insertOrderBackId(Order order);
}
