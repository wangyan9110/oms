
package com.iflytek.oms.model;

import org.dozer.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iflytek.oms.main.dto.CommboValue;
import com.iflytek.oms.oms.domain.Shipper;

/**
 * @author wangyan9110
 *
 */
public class TestDozer {

	/**
	 * 测试dozer
	 */
	@Test
	public void textDozer(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/context-dozer.xml");
		Mapper mapper=(Mapper)ctx.getBean("mapper");

		Shipper shipper=new Shipper();
		shipper.setCompanyName("34343");
		shipper.setShipperId(123);
		CommboValue cbv=mapper.map(shipper, CommboValue.class);
		System.out.println(cbv.getText());
		
	}
}
