package com.bjhy.titan.broker.jms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {
	
	@Bean
    JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
	
	@Bean
	public ConnectionFactory jmsConnectionFactory(@Value("${activeMQ.address}")String value) {
//	    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","failover:("+value+")");
		
		//failover:(tcp://192.168.0.49:61616) //当网络出现断网时,过段时间有好了,能自动重连
	    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("failover:("+value+")");
	    factory.setTrustAllPackages(true);
	    return factory;
	}
	
	@Autowired
	ConnectionFactory connectionFactory;
	
	@Bean
	public JmsTemplate jmsTemplate(){
		System.out.println();
		return new JmsTemplate(connectionFactory);
	}
	
}
