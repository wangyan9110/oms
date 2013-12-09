
package com.iflytek.oms.pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.main.service.BaseService;
import com.iflytek.oms.pms.domain.Product;
import com.iflytek.oms.pms.persist.ProductDao;
import com.iflytek.oms.pms.service.ProductService;

/**
 * 产品服务实现
 * @author wangyan9110
 *
 */
@Service
@Transactional(readOnly=true)
public class ProductServiceImpl extends BaseService implements ProductService {

	/**
	 * 产品数据访问对象
	 */
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getPoductById(Integer id) {
		return productDao.selectOne(id);
	}

	@Override
	public List<CommboValue> getProductsCommboValue() {
		List<Product> products=productDao.selectAll();
		return convertToCommboValue(products);
	}
	
	/**
	 * 转换为下拉框
	 * @param products 产品信息
	 * @return 下拉框信息
	 */
	private List<CommboValue> convertToCommboValue(List<Product> products){
		List<CommboValue> commboValues=new ArrayList<CommboValue>();
		for(Product product :products){
			CommboValue commboValue=mapper.map(product, CommboValue.class);
			commboValues.add(commboValue);
		}
		return commboValues;
	}
}
