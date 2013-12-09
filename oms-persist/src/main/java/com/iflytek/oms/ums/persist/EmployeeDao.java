
package com.iflytek.oms.ums.persist;

import java.util.List;

import com.iflytek.oms.ums.domain.Employee;

/**
 * 员工数据访问接口
 * @author wangyan9110
 *
 */
public interface EmployeeDao{
	
	/**
	 * 根据用户名获取用户信息（只需包括用户编号，用户名，用户密码信息,员工姓名）
	 * @param userName 用户名
	 * @return 用户信息
	 */
	Employee selectEmployeeByUserName(String userName);
	
	/**
	 * 根据用户编号获取用户信息(只需用户编号，用户名，员工姓名)
	 * @param id 用户编号
	 * @return 用户信息
	 */
	Employee selectEmployeeById(Integer id);
	
	/**
	 * 获取全部员工信息(只需员工编号，员工姓名)
	 * @return 全部员工信息
	 */
	List<Employee> selectAllEmployees();
}
