package cn.itcast.java.proxy.exe3;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPool {
	public static void main(String[] args) throws Exception {
		//创建连接池
		Pool pool = new Pool();
		//取得连接池中的连接个数
		System.out.println("连接个数为：" + pool.getSize());//10
		//取得一个空闲的连接
		Connection conn = pool.getConnection();
		//取得连接池中的连接个数
		System.out.println("连接个数为：" + pool.getSize());//9
		//关闭连接对象，本质是将连接放回连接池
		conn.close();
		System.out.println("连接个数为：" + pool.getSize());//10
	}
}
