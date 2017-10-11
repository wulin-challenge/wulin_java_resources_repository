package com.bjhy.client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjhy.platform.util.UUIDUtil;
import com.bjhy.titan.broker.jms.JmsMessage;
import com.bjhy.titan.broker.jms.JmsSender;

@Component
public class JmsClient {
	
	@Autowired
	private JmsSender jmsSender;
	
	public void send(){
		JmsMessage message = new JmsMessage();
		message.setMessageContext("罪犯编号存在该字段中");//
		message.setFrom("wulinclient");
		message.setTo("wulinServer2");
		message.setTime(new Date());
		message.setType("JmsClient");
		
		jmsSender.sendMsg("wulinServer2", message);
		
		System.out.println();
	}

}
