package cn.wulin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ManyDBUtil {

	private static ConnectionPools connectionPools= new ConnectionPools();
	
	/**根据databaseName得到Connection*/
	public static Connection getConnection(String databaseName){
		Connection connection = null;
		try {
			connection = connectionPools.getDataSource(databaseName).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**根据databaseName得到数据源*/
	public static ComboPooledDataSource getDataSource(String databaseName){
		return connectionPools.getDataSource(databaseName);
	}
	
	/**关闭preparedStatement与 Connection*/
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

	/**关闭preparedStatement与 Connection和ResultSet*/
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

	public static void main(String[] args) {
		System.out.println(getConnection("mysql1"));
		System.out.println(getDataSource("oracle1"));
	}
}
