package com.bjhy.titan.broker.jms;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bjhy.platform.container.boot.PlatformStarter;
import com.bjhy.titan.broker.jms.util.ZipFileUtil;


public class TestSender {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext  context = SpringApplication.run(PlatformStarter.class);
		JmsSender sender = context.getBean(JmsSender.class);
		
		
		JmsMessage jmsMessage = new JmsMessage();
		File[] files = new File[2];
		files[0] = new File("I:/temp/1.txt");
		files[1] = new File("I:/temp/2.txt");
		File zipFile = ZipFileUtil.zipFiles(files, "I:/temp/", "zipFile");
		
		try(FileInputStream fis = new FileInputStream(zipFile);
            	ByteArrayOutputStream bos = new ByteArrayOutputStream();){
    		int temp = 0;
        	while((temp = fis.read()) != -1){
        		bos.write(temp);
        	}
        	byte[] attachment = bos.toByteArray();
        	jmsMessage.setBytes(attachment);
		}
		
		
		jmsMessage.setType("first");
		jmsMessage.setMessageContext(" this is first message");
		jmsMessage.setTime(new Date());
		sender.sendMsg("ym",jmsMessage);
		zipFile.delete();
		//context.close();
	}
	
}
