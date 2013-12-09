package com.iflytek.oms.main.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基本服务类信息
 * @author wangyan9110
 *
 */
public abstract class BaseService {
	
	/**
	 * dozer映射
	 * 用于dto和domain的映射
	 */
	@Autowired
	protected Mapper mapper;

	/**
	 * 获取mapper 
	 * @return mapper
	 */
	public Mapper getMapper() {
		return mapper;
	}

	/**
	 * 设置mapper
	 * @param mapper mapper
	 */
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
}
