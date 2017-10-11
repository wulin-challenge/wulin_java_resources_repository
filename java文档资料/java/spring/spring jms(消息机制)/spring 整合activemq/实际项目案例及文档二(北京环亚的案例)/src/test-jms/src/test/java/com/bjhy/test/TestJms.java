package com.bjhy.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjhy.client.JmsClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/module-*.xml")
public class TestJms {
	
	@Autowired
	private JmsClient jmsClient;
	
	@Autowired
	JmsTemplate jmsTemplate;

	@Test
	public void sendMessage() throws IOException{
		jmsClient.send();
		System.in.read();
	}
	
	
}
