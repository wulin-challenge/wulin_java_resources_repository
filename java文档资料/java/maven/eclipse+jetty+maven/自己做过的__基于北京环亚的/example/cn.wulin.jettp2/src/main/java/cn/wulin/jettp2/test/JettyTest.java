package cn.wulin.jettp2.test;

import org.eclipse.jetty.server.Server;

import cn.wulin.jettp2.server.JettyUtil;

public class JettyTest {
	
	public static void main(String[] args) throws Exception {
		Server server;
		server = JettyUtil.createServer("/wulinProject", 96);
		server.start();
		server.join();
	}
	
	
	
}



/////////////////////////////////////////
