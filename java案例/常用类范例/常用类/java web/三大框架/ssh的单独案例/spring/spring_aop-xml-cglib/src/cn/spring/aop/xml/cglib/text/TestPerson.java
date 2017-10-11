package cn.spring.aop.xml.cglib.text;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.aop.xml.cglib.serviceImpl.PersonServiceImpl;

public class TestPerson {
	
	@Test
	public void testAddPerson(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonServiceImpl service=(PersonServiceImpl) ac.getBean("personServiceImpl");
		service.addPerson();
	}

}
