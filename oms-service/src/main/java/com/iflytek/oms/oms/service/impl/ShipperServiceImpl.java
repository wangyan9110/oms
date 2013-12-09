
package com.iflytek.oms.oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.main.service.BaseService;
import com.iflytek.oms.oms.domain.Shipper;
import com.iflytek.oms.oms.persist.ShipperDao;
import com.iflytek.oms.oms.service.ShipperService;

/**
 * 物流服务实现
 * @author wangyan9110
 *
 */
@Service
public class ShipperServiceImpl extends BaseService implements ShipperService {
	
	/**
	 * 物流数据访问对象
	 */
	@Autowired
	private ShipperDao shipperDao;
	
	@Override
	public List<CommboValue> getShippersCommboValue() {
		List<Shipper> shippers=shipperDao.selectAll();
		return convertShipperToCommboValue(shippers);
	}
	
	/**
	 * 转换物流数据到下拉框
	 * @author wangyan9110
	 * @param shippers 物流信息
	 * @return 下拉框信息
	 */
	private List<CommboValue> convertShipperToCommboValue(List<Shipper> shippers){
		List<CommboValue> commboValues=new ArrayList<CommboValue>();
		for(Shipper shipper :shippers){
			commboValues.add(mapper.map(shipper, CommboValue.class));
		}
		return commboValues;
	}

	@Override
	public Shipper getShipperById(Integer shipperId) {
		return shipperDao.selectOne(shipperId);
	}

}
