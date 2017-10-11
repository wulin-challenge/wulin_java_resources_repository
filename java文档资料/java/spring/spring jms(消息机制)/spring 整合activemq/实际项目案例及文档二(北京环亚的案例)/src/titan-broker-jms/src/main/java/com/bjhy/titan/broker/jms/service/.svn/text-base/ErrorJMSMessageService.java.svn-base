package com.bjhy.titan.broker.jms.service;

import com.bjhy.platform.biz.commons.service.BizCommonService;
import com.bjhy.titan.broker.jms.domain.ErrorJMSMessage;

public interface ErrorJMSMessageService extends BizCommonService<ErrorJMSMessage,String>{
	
	/**
	 * 错误消息处理
	 * @param ids
	 * @throws Exception
	 */
	public void dispose(String []ids) throws Exception;
	
	/**
	 * 定时调用消息处理
	 * @throws Exception
	 */
	public void timing() throws Exception;

}
