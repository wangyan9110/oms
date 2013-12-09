/**
 * 
 */
package com.iflytek.oms.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.oms.domain.Shipper;
import com.iflytek.oms.oms.service.ShipperService;

/**
 * @author wangyan9110
 *
 */
@Controller
@RequestMapping(value="Shipper/*")
public class ShipperController {

	/**
	 * 快递服务对象
	 */
	@Autowired
	private ShipperService shipperService;
	
	/**
	 * 获取全部物流信息
	 * @return 物流信息
	 */
	@ResponseBody
	@RequestMapping(value="list.json")
	public List<CommboValue> getShippers(){
		return shipperService.getShippersCommboValue();
	}
	
	/**
	 * 根据编号获取物流信息
	 * @param shipperId 物流编号
	 * @return 物流信息
	 */
	@RequestMapping(value="get.json")
	@ResponseBody
	public Shipper getShipperById(Integer shipperId){
		return shipperService.getShipperById(shipperId);
	}
}
