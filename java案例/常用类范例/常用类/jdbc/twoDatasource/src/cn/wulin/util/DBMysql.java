package cn.wulin.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBMysql {
	private static ComboPooledDataSource dataSource = null;

	/** 设置数据源 */
	public void getConficMessage() {
		InputStream is = DBMysql.class.getResourceAsStream("/myJdbc.properties");
		Properties p = new Properties();
		try {
			p.load(is);
			String user = p.getProperty("mysql.user");
			String password = p.getProperty("mysql.password");
			String driverName = p.getProperty("mysql.driverName");
			String url = p.getProperty("mysql.url");
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
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/** 获得数据源 */
	public static ComboPooledDataSource getDataSource() {
		if (dataSource == null) {
			DBMysql mysql = new DBMysql();
			mysql.getConficMessage();
		}
		return dataSource;
	}

	/**
	 * 获得链接Connection
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (dataSource == null) {
			DBMysql mysql = new DBMysql();
			mysql.getConficMessage();
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
