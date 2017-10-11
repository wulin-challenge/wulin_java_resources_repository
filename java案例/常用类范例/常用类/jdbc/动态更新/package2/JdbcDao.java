package package2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import package1.domain.Student;
import package2.util.DBConnection;

public class JdbcDao {
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(4);
		student.setName("ww");
		student.setSex("nv");
		update(student);

	}

	public static void update(Student student) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection=DBConnection.getConnection();
			String sql = "UPDATE t_student set name=?,sex=? where id=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setInt(3,student.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		DBConnection.close(ps, connection);
		}
	}
}
