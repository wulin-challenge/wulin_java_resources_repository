package com.bjhy.titan.broker.jms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjhy.platform.biz.commons.service.impl.AbstractBizCommonService;
import com.bjhy.platform.persist.dao.CommonRepository;
import com.bjhy.titan.broker.jms.dao.ErrorJMSMessageRepository;
import com.bjhy.titan.broker.jms.domain.ErrorJMSMessage;
import com.bjhy.titan.broker.jms.service.ErrorJMSMessageService;
import com.bjhy.titan.broker.jms.service.JMSMessageService;

@Service
@Transactional
public class ErrorJMSMessageServiceImpl extends AbstractBizCommonService<ErrorJMSMessage, String> implements ErrorJMSMessageService{

	@Autowired
	private ErrorJMSMessageRepository errorJMSMessageRepository;
	
	@Autowired
	private JMSMessageService jmsMessageService;
	
	@Override
	protected CommonRepository<ErrorJMSMessage, String> getRepository() {
		return errorJMSMessageRepository;
	}

	@Override
	protected String getPageQl() {
		return "select t from ErrorJMSMessage t where 1=1";
	}

	@Override
	public void dispose(String[]ids) throws Exception {
		for (int i = 0; i < ids.length; i++) {
			jmsMessageService.handleMessageForSystem(ids[i]);
		}
	}

	@Override
	public void timing() throws Exception {
		String []ids=errorJMSMessageRepository.findAllId();
		dispose(ids);
	}

}
