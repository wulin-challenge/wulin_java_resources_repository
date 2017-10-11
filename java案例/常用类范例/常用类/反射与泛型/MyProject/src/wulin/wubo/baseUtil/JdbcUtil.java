package wulin.wubo.baseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static ComboPooledDataSource dataSource;
	
	static{
		dataSource=new ComboPooledDataSource();
	}
	
	public static Connection getConnection() throws SQLException{
		Connection connection=null;
		connection=dataSource.getConnection();
		return connection;
	}
	
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	
	public static void close(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void close(PreparedStatement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection connection){
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
