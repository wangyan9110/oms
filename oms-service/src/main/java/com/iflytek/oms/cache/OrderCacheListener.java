package com.iflytek.oms.cache;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.oms.oms.dto.OrderDto;
import com.iflytek.oms.oms.service.OrderService;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

/**
 * @author wangyan9110
 * 
 */
public class OrderCacheListener implements CacheEventListener {

	/**
	 * 订单处理
	 */
	@Autowired
	private OrderService orderService;

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void notifyElementEvicted(Ehcache arg0, Element arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyElementExpired(Ehcache arg0, Element arg1) {
		OrderDto orderDto = (OrderDto) arg1.getObjectValue();
		orderService.rebackProduct(orderDto.getOrderDetails());
	}

	@Override
	public void notifyElementPut(Ehcache arg0, Element arg1) {

	}

	@Override
	public void notifyElementRemoved(Ehcache arg0, Element arg1) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void notifyElementUpdated(Ehcache arg0, Element arg1) {
		// TODO Auto-generated method stub
		return;

	}

	@Override
	public void notifyRemoveAll(Ehcache arg0) {
		// TODO Auto-generated method stub
	}

}
