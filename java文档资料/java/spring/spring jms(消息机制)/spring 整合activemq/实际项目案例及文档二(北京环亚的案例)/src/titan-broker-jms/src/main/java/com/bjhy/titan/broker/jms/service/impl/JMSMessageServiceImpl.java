package com.bjhy.titan.broker.jms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjhy.titan.broker.jms.JmsMessage;
import com.bjhy.titan.broker.jms.JmsMessageHandle;
import com.bjhy.titan.broker.jms.domain.ErrorJMSMessage;
import com.bjhy.titan.broker.jms.service.ErrorJMSMessageService;
import com.bjhy.titan.broker.jms.service.JMSMessageService;
import com.bjhy.titan.broker.jms.util.ProtoStuffSerializerUtil;

@Service
@Transactional
public class JMSMessageServiceImpl implements JMSMessageService {

	@Autowired
	private ErrorJMSMessageService service;
	
	@Autowired
	private ApplicationContext ac;
	
	private Logger logger = Logger.getLogger(JMSMessageServiceImpl.class);
	@Override
	public void handleMessage( byte[] bytes) {
		String type=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			JmsMessage jmsMessage = ProtoStuffSerializerUtil.deserialize(bytes,JmsMessage.class );
			type = jmsMessage.getType();
			JmsMessageHandle handle = (JmsMessageHandle) ac.getBean(type);
			handle.doHandle(jmsMessage);
		} catch (Exception e) {
			logger.error(e);
			//将错误消息存入 错误消息管理列表中
			ErrorJMSMessage message=new ErrorJMSMessage();
			message.setType(type);
			message.setMessage(bytes);
			message.setDescribe("消息类型【"+type+"】,于"+sdf.format(new Date())+"处理错误");
			message.setZjclsj(new Date());
			service.save(message);
		}
	}

	@Override
	public void handleMessageForSystem(String id){
		  ErrorJMSMessage message=service.findById(id);
		  String type=message.getType();
		  byte []bytes=message.getMessage();
		  try {
		    JmsMessage jmsMessage = ProtoStuffSerializerUtil.deserialize(bytes,JmsMessage.class );
			type = jmsMessage.getType();
			JmsMessageHandle handle = (JmsMessageHandle) ac.getBean(type);
			handle.doHandle(jmsMessage);
			service.deleteById(id);
		} catch (Exception e) {
			logger.error(e);
			//手动或定时处理消息出错
			int zxcs=message.getZxcs();
			message.setZxcs(++zxcs);
			message.setZjclsj(new Date());
			service.update(message);
		}
		
	}

	public void dispose(ApplicationContext ac, byte[] bytes,String type) throws Exception{
		
		JmsMessage jmsMessage = ProtoStuffSerializerUtil.deserialize(bytes,JmsMessage.class );
		type = jmsMessage.getType();
		JmsMessageHandle handle = (JmsMessageHandle) ac.getBean(type);
		handle.doHandle(jmsMessage);
	}
}
