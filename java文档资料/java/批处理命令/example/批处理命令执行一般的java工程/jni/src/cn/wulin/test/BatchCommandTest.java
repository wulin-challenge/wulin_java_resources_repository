package cn.wulin.test;

import cn.wulin.test.other.First;

public class BatchCommandTest {
	
	public static void main(String[] args) {
		System.out.println("批处理命令执行开始!!");
		System.out.println(new First().batchCommand("哈哈!我要开始执行了!!!!"));
		System.out.println("批处理命令执行结束!!");
	}

}
