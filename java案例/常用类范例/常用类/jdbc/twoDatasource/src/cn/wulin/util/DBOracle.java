package cn.wulin.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBOracle {

private static ComboPooledDataSource dataSource=null;
	
	/**设置数据源*/
	public void getConficMessage(){
		InputStream is = DBOracle.class.getResourceAsStream("/myJdbc.properties");
		Properties p =new Properties();
		try {
			p.load(is);
			String user=p.getProperty("oracle.user");
			String password=p.getProperty("oracle.password");
			String driverName = p.getProperty("oracle.driverName");
			String url = p.getProperty("oracle.url");
			System.out.println(url);
			dataSource = new ComboPooledDataSource();
			dataSource.setUser(user);
			dataSource.setPassword(password);
			dataSource.setJdbcUrl(url);
			dataSource.setDriverClass(driverName);
			dataSource.setInitialPoolSize(3);
			dataSource.setMinPoolSize(1);
			dataSource.setMaxPoolSize(10);
			dataSource.setMaxStatements(50);
			dataSource.setMaxIdleTime(60);
			dataSource.setAcquireIncrement(5);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**获得数据源*/
	public static ComboPooledDataSource getDataSource(){
		if(dataSource==null){
			DBOracle oracle=new DBOracle();
			oracle.getConficMessage();
		}
		return dataSource;
	}
	
	/**
	 * 获得链接Connection
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		if(dataSource==null){
			DBOracle oracle=new DBOracle();
			oracle.getConficMessage();
		}
		return dataSource.getConnection();
	}
	
	public static void close(PreparedStatement ps, Connection connection) {
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps, Connection connection, ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(ps, connection);
	}
}
