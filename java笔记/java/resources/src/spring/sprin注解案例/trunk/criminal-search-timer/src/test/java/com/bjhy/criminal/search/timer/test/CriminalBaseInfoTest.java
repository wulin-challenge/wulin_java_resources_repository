package com.bjhy.criminal.search.timer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjhy.criminal.search.timer.command.Command;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/module-*.xml")
public class CriminalBaseInfoTest {
	
	@Autowired
	@Qualifier("criminalBaseInfo")
	private Command criminalBaseInfo;
	@Test
	public void test1() throws Exception{
		criminalBaseInfo.analyze();
	}
	
	
}
