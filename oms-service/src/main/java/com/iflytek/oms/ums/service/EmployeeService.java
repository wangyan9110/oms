
package com.iflytek.oms.ums.service;

import java.util.List;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.ums.domain.Employee;

/**
 * 登录信息服务类
 * @author wangyan9110
 *
 */
public interface EmployeeService {
	
	/**
	 * 根据用户名获取员工信息(仅包括员工编号，用户名，密码，员工姓名)
	 * @param userName 用户名 
	 * @return 员工信息
	 */
	Employee getEmployeeByUserName(String userName);
	
	/**
	 * 根据员工编号获取员工信息
	 * @param id  员工编号
	 * @return 员工信息
	 */
	Employee getEmployeeById(Integer id);
	
	/**
	 * 获取全部员工信息
	 * @return 员工信息
	 */
	List<CommboValue> getAllEmployees();
	
}
