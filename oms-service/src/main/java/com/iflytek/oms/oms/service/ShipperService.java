
package com.iflytek.oms.oms.service;

import java.util.List;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.oms.domain.Shipper;

/**
 * 物流服务接口
 * @author wangyan9110
 *
 */
public interface ShipperService {

	/**
	 * 获取全部物流，并转为下拉框的键和值
	 * @return 全部物流信息
	 */
	List<CommboValue> getShippersCommboValue();
	
	/**
	 * 根据编号获取物流信息
	 * @param shipperId 编号
	 * @return 物流信息
	 * 
	 */
	Shipper getShipperById(Integer shipperId);
}
