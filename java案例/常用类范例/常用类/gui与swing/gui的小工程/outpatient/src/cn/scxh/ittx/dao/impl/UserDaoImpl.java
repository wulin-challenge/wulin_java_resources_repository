package cn.scxh.ittx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.scxh.ittx.dao.intf.UserDao;
import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.util.DBConnection;

public class UserDaoImpl implements UserDao {

	public void addUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO t_user(id,name,password,status) values(?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2,user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getStatus());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	public void deleteUserById(User user) throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="DELETE FORM t_user where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1,user.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	public List<User> queryUserById(User user) throws SQLException {
		List<User> userList=new ArrayList<User>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM t_user wher id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String status=rs.getString("status");
				User u=new User();
				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				u.setStatus(status);
				userList.add(u);
			}
			
			DBConnection.close(rs,ps, connection);
		return userList;
	}

	public List<User> queryUsers(User user) throws SQLException {
		List<User> userList=new ArrayList<User>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM t_user";
			ps = connection.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String status=rs.getString("status");
				User u=new User();
				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				u.setStatus(status);
				userList.add(u);
			}
			DBConnection.close(rs,ps, connection);
		return userList;
	}

	public void updateuserById(User user) throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="UPDATE t_user set id=? ,name=?,password=?,status=? where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2,user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getStatus());
			ps.setInt(5, user.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}
	
	public List<User> variousConditionQueryUsers(User user) throws SQLException {
		List<User> userList=new ArrayList<User>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
			connection = DBConnection.getConnection();
			String sql=VariousConditionsQuery.getSql(user);
			ps=connection.prepareStatement(sql);
			VariousConditionsQuery.setPreparedStatement(ps, user);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String status=rs.getString("status");
				User u=new User();
				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				u.setStatus(status);
				userList.add(u);
			}
			DBConnection.close(rs,ps, connection);
		return userList;
	}
}
