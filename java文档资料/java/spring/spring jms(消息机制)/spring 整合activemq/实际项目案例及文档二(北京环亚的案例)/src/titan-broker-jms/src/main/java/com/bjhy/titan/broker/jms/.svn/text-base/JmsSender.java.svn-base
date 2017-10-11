package com.bjhy.titan.broker.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.bjhy.titan.broker.jms.util.ProtoStuffSerializerUtil;

@Component
public class JmsSender {
		
	@Autowired(required=false)
	JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * @param topics 【接受监狱的监狱代码，多个监狱由逗号隔开】
	 * @param message
	 */
	public void sendMsg(String topics , final com.bjhy.titan.broker.jms.JmsMessage message){
		MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(ProtoStuffSerializerUtil.serialize(message));
            }
        };
        ActiveMQQueue queue = new ActiveMQQueue(topics);
		jmsTemplate.send(queue, messageCreator);
	}
}
