package com.iflytek.oms.persist;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iflytek.oms.oms.domain.Order;
import com.iflytek.oms.oms.persist.OrderDao;

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
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/database.xml");
		SqlSessionFactory sessionFactory=(SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SqlSession session=sessionFactory.openSession();
		
//		EmployeeDao employeeDao=session.getMapper(EmployeeDao.class);
//		Employee employee=employeeDao.selectEmployeeByUserName("admin");
//		System.out.println(employee.getPassword());
		
		OrderDao ordeDao=session.getMapper(OrderDao.class);
		Order order=ordeDao.selectOne(10250);
		System.out.println(order.getEmployeeId());
		
//		E shipperDao=session.getMapper(ShipperDao.class);
//		List<Shipper> shippers=shipperDao.selectAll();
//		System.out.println(shippers.size());
	}
}
