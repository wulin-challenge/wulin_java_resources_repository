package cn.itcast.java.proxy.exe3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

//自定义连接池
public class Pool {
	private static LinkedList<Connection> linkedList = new LinkedList<Connection>();
	static{
		//在加载Pool类时，创建10个连接，并加入到连接池中
		for(int i=0;i<10;i++){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root","root");
				linkedList.addLast(conn);
			} catch (Exception e) {
			}
		}
	}
	//取得连接池中连接的个数
	public int getSize() {
		return linkedList.size();
	}
	/*取得一个空闲的连接，只能返回Connection的动态代理对象
	public Connection getConnection() {
		final Connection conn = linkedList.removeFirst();
		return (Connection) Proxy.newProxyInstance(
				Pool.class.getClassLoader(),
				conn.getClass().getInterfaces(), 
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						//如果调用的是close()方法
						if("close".equals(method.getName())){
							//将连接放回连接池
							linkedList.addLast(conn);
							//返回null
							return null;
						}else{
							return method.invoke(conn,args);
						}
					}
				});
	}
	*/
	public Connection getConnection() {
		Connection conn = linkedList.removeFirst();
		return conn;//返回真Connection
	}
}





