package com.bjhy.criminal.search.timer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjhy.criminal.search.timer.service.MyTestService;
import com.bjhy.criminal.search.timer.tool.DBUtil;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/module-*.xml")
public class MyTimerTest {
	
	@Autowired
	@Qualifier("myTestServiceImpl")
	private MyTestService myTestService;
	@Test
	public void test1() throws Exception{
		
		myTestService.test2();
	}
	
	@Test
	public void testConnect() throws Exception{
		
		DBUtil db = new DBUtil();
		//db.isConnectSuccess("YZ", "JLYZ", "ORACLE", 1);
		db.isConnectSuccess("JCSJ", "JLJCSJ", "ORACLE", 1);
	}
	
	
	public static void main(String[] args) {
			
	}
	
	
}
