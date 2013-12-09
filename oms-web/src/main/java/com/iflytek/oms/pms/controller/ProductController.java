
package com.iflytek.oms.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.pms.domain.Product;
import com.iflytek.oms.pms.service.ProductService;

/**
 * @author wangyan9110
 * 
 */
@Controller
@RequestMapping(value = "Product/*")
public class ProductController {

	/**
	 * 产品服务对象
	 */
	@Autowired
	private ProductService productService;

	/**
	 * 获取全部产品
	 * 
	 * @return 全部产品
	 */
	@RequestMapping(value = "list.json")
	@ResponseBody
	public List<CommboValue> getProducts() {
		return productService.getProductsCommboValue();
	}

	/**
	 * 根据产品编号获取产品信息
	 * 
	 * @param productId
	 *            产品编号
	 * @return 产品信息
	 */
	@ResponseBody
	@RequestMapping(value = "get.json")
	public Product getProductById(Integer productId) {
		if (productId != null) {
			return productService.getPoductById(productId);
		}
		return null;
	}
}
