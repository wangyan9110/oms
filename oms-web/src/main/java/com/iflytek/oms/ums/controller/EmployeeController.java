
package com.iflytek.oms.ums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.ums.service.EmployeeService;

/**
 * @author wangyan9110
 * 
 */
@Controller
@RequestMapping(value = "Employee/*")
public class EmployeeController {

	/**
	 * 员工数据服务对象
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 获取全部员工
	 * @return 全部员工
	 */
	@RequestMapping(value = "list.json")
	@ResponseBody
	public List<CommboValue> getEmployees() {
		return employeeService.getAllEmployees();
	}
}
