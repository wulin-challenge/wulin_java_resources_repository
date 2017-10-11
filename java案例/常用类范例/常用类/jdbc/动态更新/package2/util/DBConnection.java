package package2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USER_NAME="scott";
	private static final String PASSWORD="tiger";
	
	public static Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(PreparedStatement ps,Connection connection){
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

}
