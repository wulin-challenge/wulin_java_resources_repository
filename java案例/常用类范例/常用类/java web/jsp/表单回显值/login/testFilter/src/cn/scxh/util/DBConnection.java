package cn.scxh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/jsp";
	private static final String USER_NAME = "root";
	private static final String PWD = "a123";
	
	public static Connection getConnection(){
		Connection conneciton = null;
		try{
			Class.forName(DRIVER_NAME);
			conneciton = DriverManager.getConnection(URL,USER_NAME, PWD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conneciton;
	}

	
	public static void close(ResultSet rs,PreparedStatement ps,Connection connection){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
