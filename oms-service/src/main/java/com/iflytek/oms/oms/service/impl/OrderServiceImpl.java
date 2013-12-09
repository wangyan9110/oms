
package com.iflytek.oms.oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iflytek.framework.pagination.PaginationCriteria;
import com.iflytek.framework.pagination.PaginationCriteria.SortOrder;
import com.iflytek.framework.pagination.PaginationResult;
import com.iflytek.oms.cache.OrderCache;
import com.iflytek.oms.main.service.BaseService;
import com.iflytek.oms.oms.domain.Customer;
import com.iflytek.oms.oms.domain.Order;
import com.iflytek.oms.oms.domain.OrderDetail;
import com.iflytek.oms.oms.domain.Shipper;
import com.iflytek.oms.oms.dto.OrderAndDetail;
import com.iflytek.oms.oms.dto.OrderDto;
import com.iflytek.oms.oms.dto.SimpleOrderDto;
import com.iflytek.oms.oms.persist.CustomerDao;
import com.iflytek.oms.oms.persist.OrderDao;
import com.iflytek.oms.oms.persist.OrderDetailDao;
import com.iflytek.oms.oms.persist.ShipperDao;
import com.iflytek.oms.oms.service.OrderService;
import com.iflytek.oms.pms.domain.Product;
import com.iflytek.oms.pms.persist.ProductDao;
import com.iflytek.oms.ums.persist.EmployeeDao;
import com.iflytek.oms.utils.DateUtils;
import com.iflytek.oms.oms.dto.OrderDetailDto;

/**
 * 订单服务接口实现
 * 
 * @author wangyan9110
 * 
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl extends BaseService implements OrderService {

	/**
	 * 订单缓存
	 */
	@Autowired
	private OrderCache orderCache;

	/**
	 * 订单数据访问对象
	 */
	@Autowired
	private OrderDao orderDao;

	/**
	 * 订单详情数据访问对象
	 */
	@Autowired
	private OrderDetailDao orderDetailDao;

	/**
	 * 产品数据访问对象
	 */
	@Autowired
	private ProductDao productDao;

	/**
	 * 物流数据访问对象
	 */
	@Autowired
	private ShipperDao shipperDao;

	/**
	 * 员工数据访问对象
	 */
	@Autowired
	private EmployeeDao employeeDao;

	/**
	 * 客户名称
	 */
	@Autowired
	private CustomerDao customerDao;

	@Override
	public PaginationResult<SimpleOrderDto> getPagedOrders(int pageIndex,
			int pageSize) {
		int start = (pageIndex - 1) * pageSize;
		PaginationCriteria criteria = new PaginationCriteria(start, pageSize,
				"OrderID", SortOrder.DESC);
		PaginationResult<Order> pr = orderDao.selectPagedOrders(criteria);
		return convertToSimpleOrderDto(pr);
	}

	@Override
	public PaginationResult<SimpleOrderDto> getPagedOrders(int pageIndex,
			int pageSize, String shipCompanyName) {
		int start = (pageIndex - 1) * pageSize;

		PaginationCriteria criteria = new PaginationCriteria(start, pageSize,
				"OrderID", SortOrder.DESC);

		Shipper shipper = shipperDao
				.selectShipperByCompanyName(shipCompanyName);
		if (shipper == null) {
			throw new RuntimeException("没有该物流公司");
		}

		Integer shipId = shipper.getShipperId();
		PaginationResult<Order> pr = orderDao.selectPagedOrdersByShipperId(
				criteria, shipId);
		return convertToSimpleOrderDto(pr);
	}

	@Override
	public SimpleOrderDto getSimpleOrderById(Integer id) {
		Order order = orderDao.selectOne(id);
		return convertToSimpleOrderDto(order);
	}

	@Transactional
	@Override
	public void updateOrder(Order order) {
		orderDao.update(order);
	}

	@Transactional
	@Override
	public void delete(Integer orderId) {
		if(orderId==null){
			throw new RuntimeException("订单编号不能为空");
		}
		List<OrderDetail> orderDetails = orderDetailDao.selectOrderDetailsByOrderId(orderId);
		rebackProduct(orderDetails);
		orderDetailDao.deleteOrderDetailsByOrderId(orderId);
		orderDao.delete(orderId);
	}

	@Transactional
	@Override
	public void deleteOrderDetail(Integer orderId, Integer productId) {
		if (orderId == null || productId == null) {
			throw new RuntimeException("订单编号或产品编号不能为空");
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(orderId);
		orderDetail.setProductId(productId);
		orderDetailDao.deleteOrderDetailByOrderIdAndProductId(orderDetail);
	}

	@Override
	public OrderDto getOrderOrderDtoById(Integer orderId) {
		if(orderId==null){
			throw new RuntimeException("订单编号不能为空");
		}
		Order order = orderDao.selectOne(orderId);
		List<OrderDetail> orderDetails = orderDetailDao
				.selectOrderDetailsByOrderId(orderId);
		OrderDto orderDto = new OrderDto();
		orderDto.setOrder(order);
		orderDto.setOrderDetails(orderDetails);
		return orderDto;
	}

	@Override
	public void addSimpleOrder(int id, Order order) {
		OrderDto orderDto = new OrderDto();
		orderDto.setOrder(order);
		orderCache.addOrUpdateOrder(id, orderDto);
	}

	@Transactional
	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		if (orderDetailDao.selectOrderDetailByOrderIdAndProductId(orderDetail) != null) {
			throw new RuntimeException("订单中已存在该商品");
		}
		orderDetail.setDiscount(1f);
		checkAndUpdateProduct(orderDetail.getProductId(),
				orderDetail.getQuantity());
		orderDetailDao.insert(orderDetail);
	}

	@Transactional
	@Override
	public void addOrderDetail(int id, OrderDetail orderDetail) {
		// 查询验证产品信息，并作相应修改
		checkAndUpdateProduct(orderDetail.getProductId(),
				orderDetail.getQuantity());

		// 添加的订单详情添加到cache
		OrderDto orderDto = orderCache.getOrder(id);
		if (orderDto == null) {
			throw new RuntimeException("不存在订单信息，请返回上一步先填写订单主信息");
		}
		if (orderDto.getOrderDetails() == null) {
			orderDto.setOrderDetails(new ArrayList<OrderDetail>());
		}
		// 添加订单明细到cache,如果添加重复的产品,增加产品数据合并
		int flag = 0;
		for (OrderDetail od : orderDto.getOrderDetails()) {
			if (od.getProductId().equals(orderDetail.getProductId())) {
				od.setQuantity(od.getQuantity() + orderDetail.getQuantity());
				flag = 1;
			}
		}
		if (flag == 0) {
			orderDto.getOrderDetails().add(orderDetail);
		}
		orderCache.addOrUpdateOrder(id, orderDto);
	}

	@Transactional
	@Override
	public void addOrder(int id) {
		OrderDto orderDto = null;
		try {
			orderDto = orderCache.getOrder(id);
			if(orderDto.getOrderDetails()==null){
				throw new RuntimeException("订单详情不能为空");
			}
			orderDao.insert(orderDto.getOrder());
			for (OrderDetail od : orderDto.getOrderDetails()) {
				od.setOrderId(orderDto.getOrder().getOrderId());
				od.setDiscount(1.0f);
				orderDetailDao.insert(od);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (orderDto != null) {
				rebackProduct(orderDto.getOrderDetails());
			}
		} finally {
			orderCache.deleteOrder(id);
		}
	}

	/**
	 * 回滚产品数量
	 * 
	 * @param orderDetails
	 *            产品详情
	 */
	public void rebackProduct(List<OrderDetail> orderDetails) {
		if(orderDetails==null){
			return;
		}
		for (OrderDetail orderDetail : orderDetails) {
			Product product = productDao.selectOne(orderDetail.getProductId());
			product.setUnitsInStock(product.getUnitsInStock()
					+ orderDetail.getQuantity());
			product.setUnitsOnOrder(product.getUnitsOnOrder()
					- orderDetail.getQuantity());
			productDao.update(product);
		}
	}

	@Transactional
	@Override
	public void deleteOrderDetail(int id, int productId) {
		OrderDto orderDto = orderCache.getOrder(id);
		if (orderDto == null) {
			throw new RuntimeException("不存在订单信息");
		}
		List<OrderDetail> orderDetails = orderDto.getOrderDetails();
		OrderDetail orderDetail = getIndexOfOrderDetails(productId,
				orderDetails);
		if (orderDetail != null) {
			Product product = productDao.selectOne(productId);
			product.setUnitsInStock(product.getUnitsInStock()
					+ orderDetail.getQuantity());
			product.setUnitsOnOrder(product.getUnitsOnOrder()
					- orderDetail.getQuantity());
			productDao.update(product);
		}
		orderDto.setOrderDetails(orderDetails);
		orderCache.addOrUpdateOrder(id, orderDto);
	}

	@Override
	public OrderAndDetail getOrderAndDetailsById(Integer orderId) {
		OrderDto orderDto = getOrderOrderDtoById(orderId);
		Order order = orderDto.getOrder();
		OrderAndDetail orderDetail = new OrderAndDetail();
		orderDetail.setOrderId(orderId);
		orderDetail.setEmployeeName(employeeDao.selectEmployeeById(order.getEmployeeId()).getName()
						.toString());
		orderDetail.setFreight(order.getFreight().toString());
		Customer customer = customerDao.selectOne(order.getCustomerId());
		orderDetail.setCustomerName(customer.getCompanyName());
		orderDetail.setCustomerPhone(customer.getContact().getPhone());
		orderDetail.setShipAddress(order.getShip().getAddress().getAddress());
		orderDetail.setShipName(order.getShip().getName());
		orderDetail.setShipCompanyName(shipperDao.selectOne(
				order.getShipperId()).getCompanyName());
		orderDetail.setDetails(convertToOrderDetailDto(orderDto
				.getOrderDetails()));

		return orderDetail;
	}

	@Override
	public Order getOrderById(Integer orderId) {
		return orderDao.selectOne(orderId);
	}

	@Override
	public List<OrderDetailDto> getOrderDetailByOrderId(Integer orderId) {
		List<OrderDetail> orderDetails = orderDetailDao.selectOrderDetailsByOrderId(orderId);
		List<OrderDetailDto> orderDetailDtos = new ArrayList<OrderDetailDto>();
		for (OrderDetail od : orderDetails) {
			orderDetailDtos.add(convertToOrderDetailDto(od));
		}
		return orderDetailDtos;
	}

	/**
	 * 检查更新产品信息
	 * 
	 * @param proudctId
	 *            产品编号
	 * @param quantity
	 *            订单中的产品数量
	 */
	private void checkAndUpdateProduct(Integer proudctId, Integer quantity) {
		Product product = productDao.selectOne(proudctId);
		if (quantity > product.getUnitsInStock()) {
			throw new RuntimeException("库存量不足,库存只剩" + product.getUnitsInStock());
		}
		product.setUnitsInStock(product.getUnitsInStock() - quantity);
		product.setUnitsOnOrder(product.getUnitsOnOrder() + quantity);
		productDao.update(product);
	}

	/**
	 * 转换为dto
	 * 
	 * @param orderDetails
	 *            订单详情
	 * @return 订单详情
	 */
	private List<OrderDetailDto> convertToOrderDetailDto(
			List<OrderDetail> orderDetails) {
		List<OrderDetailDto> orderDetailDtos = new ArrayList<OrderDetailDto>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailDto orderDeatilDto = convertToOrderDetailDto(orderDetail);
			orderDetailDtos.add(orderDeatilDto);
		}
		return orderDetailDtos;
	}

	/**
	 * 转换为dto对象
	 * 
	 * @param order
	 *            数据访问对象
	 * @return dto对象
	 */
	private SimpleOrderDto convertToSimpleOrderDto(Order order) {
		SimpleOrderDto simpleOrderDto = new SimpleOrderDto();
		simpleOrderDto.setOrderId(order.getOrderId());
		simpleOrderDto.setShipName(order.getShip().getName());
		simpleOrderDto.setShipCompanyName(shipperDao.selectOne(
				order.getShipperId()).getCompanyName());
		simpleOrderDto.setOrderDate(DateUtils.getFormatStr(
				order.getOrderDate(), "yyyy-MM-dd"));
		return simpleOrderDto;
	}

	/**
	 * 转换为orderDetaildto
	 * 
	 * @param od
	 *            订单详情对象
	 * @return 订单详情视图
	 */
	private OrderDetailDto convertToOrderDetailDto(OrderDetail od) {
		OrderDetailDto odd = mapper.map(od, OrderDetailDto.class);
		odd.setProductName(productDao.selectOne(od.getProductId())
				.getProductName());
		return odd;
	}

	/**
	 * 获取产品编号为productId的产品的索引
	 * 
	 * @param productId
	 *            产品编号
	 * @param orderDetails
	 *            产品详情
	 * @return 索引
	 */
	@SuppressWarnings("unused")
	private OrderDetail getIndexOfOrderDetails(int productId,
			List<OrderDetail> orderDetails) {
		int length = orderDetails.size();
		for (int i = 0; i < length; i++) {
			return (OrderDetail) orderDetails.get(i);
		}
		return null;
	}

	/**
	 * 转为dto对象
	 * 
	 * @param orders
	 *            数据库访问层对象
	 * @return dto对象数据
	 */
	private PaginationResult<SimpleOrderDto> convertToSimpleOrderDto(
			PaginationResult<Order> orders) {
		PaginationResult<SimpleOrderDto> simpleOrders = new PaginationResult<SimpleOrderDto>();
		simpleOrders.setTotal(orders.getTotal());
		for (Order order : orders.getRows()) {
			simpleOrders.getRows().add(convertToSimpleOrderDto(order));
		}
		return simpleOrders;
	}

}
