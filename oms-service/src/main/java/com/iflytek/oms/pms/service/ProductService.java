
package com.iflytek.oms.pms.service;

import java.util.List;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.pms.domain.Product;

/**
 * 产品服务接口
 * @author wangyan9110
 *
 */
public interface ProductService {

	/**
	 * 根据产品编号获取产品信息
	 * @param id 产品编号
	 * @return 产品信息
	 */
	Product getPoductById(Integer id);
	
	/**
	 * 获取全部产品信息,并转为下拉框中的值
	 * @return 全部产品信息
	 */
	List<CommboValue> getProductsCommboValue();
	
}
