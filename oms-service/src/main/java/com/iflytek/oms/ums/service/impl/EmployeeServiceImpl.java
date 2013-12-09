
package com.iflytek.oms.ums.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.ums.domain.Employee;
import com.iflytek.oms.ums.persist.EmployeeDao;
import com.iflytek.oms.ums.service.EmployeeService;

/**
 * 员工业务逻辑实现
 * @author wangyan9110
 *
 */
@Service
@Transactional(readOnly=true)
public class EmployeeServiceImpl implements EmployeeService {
	
	/**
	 * 员工数据访问对象
	 */
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getEmployeeByUserName(String userName) {
		return employeeDao.selectEmployeeByUserName(userName);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDao.selectEmployeeById(id);
	}

	@Override
	public List<CommboValue> getAllEmployees() {
		return convertToCommboValue(employeeDao.selectAllEmployees());
	}
	
	/**
	 * 转换为CommboValue
	 * @param employees 员工
	 * @return 返回CommboValues
	 */
	private List<CommboValue> convertToCommboValue(List<Employee> employees){
		List<CommboValue> commboValues=new ArrayList<CommboValue>();
		for(Employee employee:employees){
			CommboValue cv=new CommboValue();
			cv.setText(employee.getName().toString());
			cv.setValue(employee.getEmployeeId().toString());
			commboValues.add(cv);
		}
		return commboValues;
	}
}
