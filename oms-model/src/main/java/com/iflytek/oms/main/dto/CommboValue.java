
package com.iflytek.oms.main.dto;

import java.io.Serializable;

/**
 * 下拉框
 * @author wangyan9110
 *
 */
public class CommboValue implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 16876876876L;

	/**
	 * 值
	 */
	private String value;
	
	/**
	 * 文本
	 */
	private String text;

	/**
	 * 获取value 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置value
	 * @param value value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取text 
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * 设置text
	 * @param text text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
