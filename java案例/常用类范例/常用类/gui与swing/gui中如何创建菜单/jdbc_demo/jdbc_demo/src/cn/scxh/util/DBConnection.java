package cn.scxh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USER_NAME = "scott";
	private static final String PWD = "tiger";
	
	public static Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME, PWD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close(Connection connection,PreparedStatement ps){
		try{
			if(ps != null){
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
