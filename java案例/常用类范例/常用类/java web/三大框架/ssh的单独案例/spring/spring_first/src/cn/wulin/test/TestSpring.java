package cn.wulin.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wulin.service.intf.SpringService;

public class TestSpring {
	
	@Test
	public void testSpringService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringService service=(SpringService) ac.getBean("springService");
		service.save();
		
	}
}
