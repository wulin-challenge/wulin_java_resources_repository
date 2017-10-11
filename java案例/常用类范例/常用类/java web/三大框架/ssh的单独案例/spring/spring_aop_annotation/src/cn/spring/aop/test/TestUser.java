package cn.spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.aop.service.UserService;

public class TestUser {
	
	@Test
	public void testData(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service=(UserService) ac.getBean("userServiceImpl");
		service.addUser();
		
	}
	
	

}
