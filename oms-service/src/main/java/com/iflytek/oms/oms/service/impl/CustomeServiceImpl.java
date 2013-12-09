
package com.iflytek.oms.oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.main.service.BaseService;
import com.iflytek.oms.oms.domain.Customer;
import com.iflytek.oms.oms.persist.CustomerDao;
import com.iflytek.oms.oms.service.CustomerService;

/**
 * @author wangyan9110
 *
 */
@Service
public class CustomeServiceImpl extends BaseService implements CustomerService {

	/**
	 * 客户数据访问对象
	 */
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<CommboValue> getCustomers() {
		return convertToCommboValue(customerDao.selectAll());
	}
	
	/**
	 * 转换为customers
	 * @param customers 类型
	 * @return 已转换的commboValues
	 */
	private List<CommboValue> convertToCommboValue(List<Customer> customers){
		List<CommboValue> commboValues=new ArrayList<CommboValue>();
		for(Customer customer:customers){
			commboValues.add(mapper.map(customer, CommboValue.class));
		}
		return commboValues;
	}

}
