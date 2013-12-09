
package com.iflytek.oms.oms.service;

import java.util.List;

import com.iflytek.oms.main.dto.CommboValue;

/**
 * @author wangyan9110
 *
 */
public interface CustomerService {

	/**
	 * 获取客户信息
	 * @return 全部客户信息
	 */
	List<CommboValue> getCustomers();
}
