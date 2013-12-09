
package com.iflytek.oms.pms.persist;

import com.iflytek.framework.mybatis.extra.MyBatisDao;
import com.iflytek.oms.main.persist.BaseDao;
import com.iflytek.oms.pms.domain.Product;

/**
 * 产品数据访问接口
 * @author wangyan9110
 */
@MyBatisDao
public interface ProductDao extends BaseDao<Product, Integer> {
	
	/**
	 * 根据产品名获取产品信息
	 * @param name 产品名
	 * @return 产品信息
	 */
	Product selectProductByName(String name);
}
