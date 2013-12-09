
package com.iflytek.oms.cache;

import com.iflytek.oms.oms.dto.OrderDto;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * 订单缓存类，主要用于缓存用户未完成的订单
 * 
 * @author wangyan9110
 * 
 */
public class OrderCache {
	/**
	 * 缓存的订单
	 */
	private Cache cache;

	/**
	 * 获取cache
	 * 
	 * @return cache
	 */
	public Cache getCache() {
		return cache;
	}

	/**
	 * 设置cache
	 * 
	 * @param cache
	 *            cache
	 */
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	/**
	 * 添加订单
	 * 
	 * @param key
	 *            键值
	 * @param orderDto
	 *            dto对象
	 */
	public void addOrUpdateOrder(int key, OrderDto orderDto) {
		cache.put(new Element(key, orderDto));
	}

	/**
	 * 删除缓存
	 * 
	 * @param key
	 *            键值
	 */
	public void deleteOrder(int key) {
		cache.remove(key);
	}

	/**
	 * 根据key获取缓存数据
	 * 
	 * @param key
	 *            键值
	 * @return 数据
	 */
	public OrderDto getOrder(int key) {
		Element element = cache.get(key);
		if (element != null) {
			return (OrderDto) element.getObjectValue();
		} else {
			return null;
		}
	}
}
