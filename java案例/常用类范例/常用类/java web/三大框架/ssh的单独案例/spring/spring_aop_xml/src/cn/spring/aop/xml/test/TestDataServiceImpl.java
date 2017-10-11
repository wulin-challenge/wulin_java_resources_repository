package cn.spring.aop.xml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.aop.xml.service.DataService;

public class TestDataServiceImpl {
	
	@Test
	public void testData(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataService dsi=(DataService) ac.getBean("dataServiceImpl");
		dsi.addData();
	}
	
	//≤‚ ‘ª∑»∆
	@Test
	public void testDataAround(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataService dsi=(DataService) ac.getBean("dataServiceImpl");
		dsi.addData();
	}

}
