package com.bjhy.test.jms;

import com.bjhy.platform.container.boot.PlatformStarter;


public class TestJmsServerMain {
	
	public static void main(String[] args) {
		PlatformStarter.start();
		System.out.println("jms 的服务端启动成功");
	}

}
