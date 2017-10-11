package cn.scxh.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.dao.intf.UserDao;
import cn.scxh.model.User;
import cn.scxh.util.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into t_user(name,sex,hobby,dept,description,birthday) values(?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSex());
			ps.setString(3, user.getHobby());
			ps.setString(4, user.getDept());
			ps.setString(5, user.getDescription());
			
			java.util.Date d = user.getBirthday();
			Date registerTime = null;
			if(d!=null){
				registerTime = new Date(d.getTime()); 
			}
			ps.setDate(6, registerTime);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getUserList(User user) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user where 1=1";
		if(user.getId() !=0){
			sql += " and id=?";
		}
		if(user.getName()!= null && !"".equals(user.getName())){
			sql += " and name=?";
		}
		
		List<User> users = new ArrayList<User>();
		try{
			
			ps = connection.prepareStatement(sql);
			int count = 1;
			if(user.getId() !=0){
				ps.setInt(count, user.getId());
				count++;
			}
			if(user.getName()!= null && !"".equals(user.getName())){
				ps.setString(count, user.getName());
			}
			
			rs = ps.executeQuery();
			User user1 = null;
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String hobby = rs.getString("hobby");
				String dept = rs.getString("dept");
				String description = rs.getString("description");
				java.util.Date birthday = rs.getDate("birthday");
				
				user1 = new User();
				user1.setId(id);
				user1.setName(name);
				user1.setSex(sex);
				user1.setDept(dept);
				user1.setHobby(hobby);
				user1.setDescription(description);
				user1.setBirthday(birthday);
				
				users.add(user1);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, connection);
		}
		
		return users;
	}

	@Override
	public User getUserById(String id) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user where id=?";
		User user = null;
		try{
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()){
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String hobby = rs.getString("hobby");
				String dept = rs.getString("dept");
				String description = rs.getString("description");
				java.util.Date birthday = rs.getDate("birthday");
				
				user = new User();
				user.setId(id1);
				user.setName(name);
				user.setSex(sex);
				user.setDept(dept);
				user.setHobby(hobby);
				user.setDescription(description);
				user.setBirthday(birthday);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, connection);
		}
		
		return user;
	}
	
	
	

}
