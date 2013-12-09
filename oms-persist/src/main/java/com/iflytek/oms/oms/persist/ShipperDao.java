package com.iflytek.oms.oms.persist;

import com.iflytek.framework.mybatis.extra.MyBatisDao;
import com.iflytek.oms.main.persist.BaseDao;
import com.iflytek.oms.oms.domain.Shipper;

/**
 * 物流数据库访问接口
 * @author wangyan9110
 *
 */
@MyBatisDao
public interface ShipperDao extends BaseDao<Shipper, Integer> {
	
	/**
	 * 根据公司名称查询物流
	 * @param companyName 公司名称
	 * @return 物流对象
	 */
	Shipper selectShipperByCompanyName(String companyName);
}
