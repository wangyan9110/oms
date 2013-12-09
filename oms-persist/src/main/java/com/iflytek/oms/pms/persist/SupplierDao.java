package com.iflytek.oms.pms.persist;

import com.iflytek.framework.mybatis.extra.MyBatisDao;
import com.iflytek.oms.main.persist.BaseDao;
import com.iflytek.oms.pms.domain.Supplier;

/**
 * 供应商数据访问类
 * @author wangyan9110
 *
 */
@MyBatisDao
public interface SupplierDao extends BaseDao<Supplier, Integer> {

}
