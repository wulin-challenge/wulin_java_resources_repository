package cn.itcast.java.annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo3 {
	//该方法中需要取得@DbInfo中的属性值，即反射注解
	@DbInfo
	public static Connection getConnection() throws Exception{
		//取得该类的字节码
		Class clazz = Demo3.class;
		//取得该类中名为getConnection()的公共方法
		//参数一：方法名
		//参数二：方法参数类型对应的字节码对象，没有的话，即null
		Method method = clazz.getMethod("getConnection",null);
		//通过该方法，取得方法上定义的注解
		DbInfo dbInfo = method.getAnnotation(DbInfo.class);
		//分别取得数据库连接参数
		String driver = dbInfo.driver();
		String url = dbInfo.url();
		String username = dbInfo.usrename();
		String password = dbInfo.password();
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();
		if(conn!=null){
			System.out.println("取得连接");
			conn.close();
		}
	}
}
