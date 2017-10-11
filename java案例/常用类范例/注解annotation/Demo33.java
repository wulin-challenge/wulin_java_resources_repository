package cn.itcast.java.annotation;

import java.sql.Connection;

public class Demo33 extends Demo3{
	@DbInfo
	public static Connection getConnection() throws Exception{
		return null;
	}
	public static void main(String[] args) {
	}
}
