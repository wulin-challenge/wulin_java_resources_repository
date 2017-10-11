package cn.scxh.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import cn.scxh.dao.intf.StudentDao;
import cn.scxh.model.Student;
import cn.scxh.util.DBConnection;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void addStudent(Student student) {
		Connection connection = null;
		PreparedStatement ps = null;
		try{
			connection = DBConnection.getConnection();
			String sql = "insert into t_student(id,id_card,name,pwd,sex,register_time) values(?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getIdCard());
			ps.setString(3, student.getName());
			ps.setString(4, student.getPwd());
			ps.setString(5, student.getSex());
			Date d = student.getRegisterTime();
			long time = d.getTime();
			java.sql.Date d1 = new java.sql.Date(time);
			ps.setDate(6, d1);
			
			ps.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("«˝∂Øº”‘ÿ“Ï≥£");
		}finally{
			DBConnection.close(connection, ps);
		}
	}

}
