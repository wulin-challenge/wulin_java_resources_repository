package register.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import register.dao.RegisterDao;
import register.domain.Student;

public class RegisterDaoImpl implements RegisterDao{

	public void register(Student student) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			String sql="INSERT INTO t_studentRegister(id,name,password,gender,identityNumber,registerDate) value(?,?,?,?,?,?)";
			ps=connection.prepareStatement(sql);
			ps.setInt(1,student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getIdentityNumber());
			ps.setDate(6, new java.sql.Date(student.getRegisterDate().getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
