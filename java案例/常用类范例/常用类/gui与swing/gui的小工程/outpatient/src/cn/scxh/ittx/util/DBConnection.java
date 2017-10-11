package cn.scxh.ittx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	public static Connection getConnection() throws SQLException{
		Connection connection = null;
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}

	public static void close(ResultSet rs, PreparedStatement ps,
			Connection connection) throws SQLException {
		if (rs != null) {
				rs.close();
		}
		close(ps, connection);
	}

	public static void close(PreparedStatement ps, Connection connection) throws SQLException {
		if (ps != null) {
				ps.close();
		}
		if (connection != null) {
				connection.close();
		}
	}

}
