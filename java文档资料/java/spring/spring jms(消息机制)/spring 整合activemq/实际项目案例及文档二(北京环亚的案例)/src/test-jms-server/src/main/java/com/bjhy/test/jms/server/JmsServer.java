package com.bjhy.test.jms.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.bjhy.titan.broker.jms.service.JMSMessageService;

@Component
public class JmsServer extends ApplicationObjectSupport{
	
	@Autowired
	private JMSMessageService jmsService;
	
	@JmsListener(destination = "wulinServer2", containerFactory = "jmsContainerFactory")
	public void receiveMsg(byte[] bytes){
		jmsService.handleMessage(bytes);
	}

}
