package com.iflytek.oms.main.persist;

import java.io.Serializable;
import java.util.List;

/**
 * 基本数据访问接口
 * @author wangyan9110
 * @param <T> domain类
 * @param <PK> 主键类型
 */
public interface BaseDao<T extends Serializable,PK extends Serializable>  {
	
	/**
	 * 插入对象
	 * @param obj 要插入的对象
	 */
	void insert(T obj);
	
	/**
	 * 更新对象
	 * @param obj 要更新的对象
	 */
	void update(T obj);
	
	/**+
	 * 删除对象
	 * @param id 要删除的对象
	 */
	void delete(PK id);
	
	/**
	 * 根据编号查询对象
	 * @param id 编号主键
	 * @return 对象
	 */
	T selectOne(PK id);
	
	/**
	 * 查询所有对象
	 * @return 对象列表
	 */
	List<T> selectAll();
}
