
package com.iflytek.oms.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.oms.service.CustomerService;

/**
 * @author wangyan9110
 *
 */
@Controller
@RequestMapping(value="Customer/*")
public class CustomerController {
	
	/**
	 * 客户业务对象
	 */
	@Autowired
	private CustomerService customerService;

	/**
	 * 获取全部客户信息
	 * @return 全部客户信息
	 */
	@RequestMapping(value="list.json")
	@ResponseBody
	public List<CommboValue> getCustomers(){
		return customerService.getCustomers();
	}
}
