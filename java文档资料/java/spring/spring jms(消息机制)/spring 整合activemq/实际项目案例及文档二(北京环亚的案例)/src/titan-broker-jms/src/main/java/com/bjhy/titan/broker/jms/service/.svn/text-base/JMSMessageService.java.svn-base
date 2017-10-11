package com.bjhy.titan.broker.jms.service;


public interface JMSMessageService  {
	
	/**
	 * 从消息中间件接收到的消息处理
	 * @param bytes
	 */
	public void handleMessage(byte[] bytes);
	
	/**
	 * 通过系统中的 手动 或者定时 处理错误消息
	 * @param id 
	 * @throws Exception
	 */
	public void handleMessageForSystem(String id);

}
