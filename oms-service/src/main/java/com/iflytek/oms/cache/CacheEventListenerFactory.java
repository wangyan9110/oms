
package com.iflytek.oms.cache;

import java.util.Properties;

import com.iflytek.oms.utils.SpringContextUtil;

import net.sf.ehcache.event.CacheEventListener;

/**
 * @author wangyan9110
 *
 */
public class CacheEventListenerFactory extends
		net.sf.ehcache.event.CacheEventListenerFactory {

	@Override
	public CacheEventListener createCacheEventListener(Properties arg0) {
		String beanName=arg0.getProperty("bean");
		if(beanName==null){
			throw new IllegalArgumentException( "缓存监听器名字未定义" );
		}
		
		return (CacheEventListener)SpringContextUtil.getBean(beanName);
	}

}
