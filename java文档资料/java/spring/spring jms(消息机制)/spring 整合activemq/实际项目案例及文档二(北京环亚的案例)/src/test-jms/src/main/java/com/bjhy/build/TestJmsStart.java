package com.bjhy.build;

import com.bjhy.platform.container.boot.PlatformStarter;

public class TestJmsStart {
	
	public static void main(String[] args) {
		PlatformStarter.start();
		System.out.println("jms测试启动成功!");
	}

}
