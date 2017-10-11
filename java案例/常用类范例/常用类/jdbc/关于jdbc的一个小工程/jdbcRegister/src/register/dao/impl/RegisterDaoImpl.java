package register.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import register.dao.RegisterDao;
import register.domain.Student;
import register.util.DBConnection;
import register.util.VariousConditionsQuery;

public class RegisterDaoImpl implements RegisterDao{

	public void register(Student student) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			connection=DBConnection.getConnection();
			String sql="INSERT INTO t_studentRegister(id,name,password,gender,identityNumber,registerDate,clazzName,sid) values(?,?,?,?,?,?,?,?)";
			ps=connection.prepareStatement(sql);
			ps.setInt(1,student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getIdentityNumber());
			ps.setDate(6, new java.sql.Date(student.getRegisterDate().getTime()));
			ps.setString(7,student.getClazzname());
			ps.setInt(8,student.getSid());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(ps,connection);
		}
	}

	public List<Student> findStudents() {
		List<Student> studentList=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			connection=DBConnection.getConnection();
			String sql="SELECT * FROM t_studentRegister";
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				String identityNumber=rs.getString("identityNumber");
				java.sql.Date registerDate=rs.getDate("registerDate");
				String clazzName=rs.getString("clazzName");
				int sid=rs.getInt("sid");
				
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setPassword(password);
				student.setGender(gender);
				student.setIdentityNumber(identityNumber);
				student.setRegisterDate(registerDate);
				student.setClazzname(clazzName);
				student.setSid(sid);
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,ps,connection);
		}
		return studentList;
	}

	public List<Student> conditionQuery(Student student) {
		List<Student> studentList=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			connection=DBConnection.getConnection();
			String sql="SELECT * FROM t_studentRegister where identityNumber=?,name=?,password=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, student.getIdentityNumber());
			ps.setString(2,student.getName());
			ps.setString(3, student.getPassword());
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				String identityNumber=rs.getString("IdentityNumber");
				java.sql.Date registerDate=rs.getDate("RegisterDate");
				String clazzName=rs.getString("clazzName");
				int sid=rs.getInt("sid");
				
				
				student=new Student();
				student.setId(id);
				student.setName(name);
				student.setPassword(password);
				student.setGender(gender);
				student.setIdentityNumber(identityNumber);
				student.setRegisterDate(registerDate);
				student.setClazzname(clazzName);
				student.setSid(sid);
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,ps,connection);
		}
		return studentList;
	}

	@Override
	public List<Student> findStudentsById(int id) {
		List<Student> studentList=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			connection=DBConnection.getConnection();
			String sql="SELECT * FROM t_studentRegister WHERE id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()){
				int i=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				String identityNumber=rs.getString("identityNumber");
				java.sql.Date registerDate=rs.getDate("registerDate");
				String clazzName=rs.getString("clazzName");
				int sid=rs.getInt("sid");
				
				Student student=new Student();
				student.setId(i);
				student.setName(name);
				student.setPassword(password);
				student.setGender(gender);
				student.setIdentityNumber(identityNumber);
				student.setRegisterDate(registerDate);
				student.setClazzname(clazzName);
				student.setSid(sid);
				studentList.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, connection);
		}
		return studentList;
	}
	
	//根据id来进行更新
	public void updateStudentsById(Student student) {
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			connection=DBConnection.getConnection();
			String sql="UPDATE t_studentRegister set name=?,gender=?,password=?,identityNumber=?,registerDate=?,clazzName=?,sid=? where id=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1,student.getName());
			ps.setString(2,student.getGender());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getIdentityNumber());
			ps.setDate(5,new java.sql.Date(student.getRegisterDate().getTime()));
			ps.setString(6,student.getClazzname());
			ps.setInt(7,student.getSid());
			ps.setInt(8, student.getId());
			ps.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(ps, connection);
		}
	}

	public List<Student> differenceConditionQuery(Student student) {
		List<Student> studentList=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			connection=DBConnection.getConnection();
			String sql=VariousConditionsQuery.getSql(student);
			System.out.println(sql);
			ps=connection.prepareStatement(sql);
			VariousConditionsQuery.setPreparedStatement(ps, student);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				String identityNumber=rs.getString("identityNumber");
				java.util.Date registerDate=rs.getDate("registerDate");
				String clazzName=rs.getString("clazzName");
				int sid=rs.getInt("sid");
				
				Student student1=new Student();
				student1.setId(id);
				student1.setName(name);
				student1.setPassword(password);
				student1.setGender(gender);
				student1.setIdentityNumber(identityNumber);
				student1.setRegisterDate(registerDate);
				student.setClazzname(clazzName);
				student.setSid(sid);
				
				studentList.add(student1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, connection);
		}
		return studentList;
	}
	
	//通过id进行删除
	public void deleteById(int id) {
		Connection connection=null;
		PreparedStatement ps=null;
		try{
			connection=DBConnection.getConnection();
			String sql="DELETE FROM t_studentRegister WHERE id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(ps, connection);
		}
	}
}
