package com.bjhy.titan.broker.jms.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bjhy.titan.broker.jms.service.ErrorJMSMessageService;

/**
 * 每天23点定时执行错误消息中数据
 * @author niechen
 *
 */
@Component("errorMessage")
public class ErrorMessageTimer {
	
	@Autowired
	private ErrorJMSMessageService service;
	
//	@Scheduled(cron = "0/10 * *  * * ?")//每隔10秒执行一次
	@Scheduled(cron = "0 0 23 * * ?")//每天1点执行一次
	public void handleMessage() throws Exception{
		service.timing();
	}

}
