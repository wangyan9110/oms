package com.iflytek.oms.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iflytek.oms.oms.domain.Shipper;
import com.iflytek.oms.oms.persist.ShipperDao;

/**
 * @author wangyan9110
 * 
 */
public class DataSourceTest {

	/**
	 * 测试物流信息
	 */
	@Test
	public void testGetShippers() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		SqlSessionFactory sessionFactory=(SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SqlSession session=sessionFactory.openSession();
		
		ShipperDao shipperDao=session.getMapper(ShipperDao.class);
		List<Shipper> shippers=shipperDao.selectAll();
		System.out.println(shippers.size());
	}
}
