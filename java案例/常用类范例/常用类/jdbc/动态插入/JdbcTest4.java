package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import package1.domain.Student;

public class JdbcTest4 {
	
	public static void main(String[] args) {
		Student student=new Student();
		student.setId(7);
		student.setName("haha");
		student.setSex("ÄÐ");
		insert(student);
		
	}

	public static void insert(Student student){
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","tiger");
			String sql="INSERT INTO t_student(id,name,sex) values(?,?,?)";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(2,student.getName());
			ps.setString(3, student.getSex());
			ps.execute();
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
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
