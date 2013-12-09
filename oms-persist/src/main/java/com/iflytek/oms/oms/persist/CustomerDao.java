
package com.iflytek.oms.oms.persist;

import com.iflytek.framework.mybatis.extra.MyBatisDao;
import com.iflytek.oms.main.persist.BaseDao;
import com.iflytek.oms.oms.domain.Customer;

/**
 * 客户数据访问接口.
 * @author wangyan9110
 *
 */
@MyBatisDao
public interface CustomerDao extends BaseDao<Customer, String> {
	/**
	 * 根据客户名称查询客户信息.
	 * @param name 客户名称
	 * @return 客户信息
	 */
	Customer selectCustomerByName(String name);
}
