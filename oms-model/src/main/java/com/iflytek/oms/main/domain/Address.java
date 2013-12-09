
package com.iflytek.oms.main.domain;

import java.io.Serializable;

/**
 * 地址信息
 * @author wangyan9110
 *
 */
public class Address implements Serializable{

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 89898989993L;

	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 区域
	 */
	private String region;
	
	/**
	 * 邮编
	 */
	private String postalCode;
	
	/**
	 * 国家
	 */
	private String country;

	/**
	 * 获取address 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置address
	 * @param address address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取city 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置city
	 * @param city city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取region 
	 * @return region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * 设置region
	 * @param region region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * 获取postalCode 
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * 设置postalCode
	 * @param postalCode postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 获取country 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置country
	 * @param country country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
