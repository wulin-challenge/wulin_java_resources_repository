package cn.wulin.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.wulin.dao.UserDao;
import cn.wulin.domain.User;
import cn.wulin.util.DBMysql;
import cn.wulin.util.DBOracle;

public class UserDaoImpl implements UserDao{

	@SuppressWarnings("unchecked")
	public List<User> findUser() throws SQLException {
		List<User> userList = new ArrayList<User>();
		QueryRunner runner= new QueryRunner(DBOracle.getDataSource());
		String sql="select * from t_user";
		userList=(List<User>) runner.query(sql, new BeanListHandler(User.class));
		return userList;
	}

	@SuppressWarnings("unchecked")
	public List<User> findUser1(Date previously) throws SQLException {
		List<User> userList = new ArrayList<User>();
		QueryRunner runner= new QueryRunner(DBMysql.getDataSource());
		String sql="select * from t_user where changeTime > ?";
		userList=(List<User>) runner.query(sql,previously, new BeanListHandler(User.class));
		return userList;
	}
	
	public int getMaxIdOracle() throws SQLException{
		QueryRunner runner = new QueryRunner(DBOracle.getDataSource());
		String sql = "select max(id) from t_user";
		BigDecimal m=(BigDecimal) runner.query(sql,new ScalarHandler());
		int max=m.intValue();
		return max;
	}
	
	public int getMaxIdMysql() throws SQLException{
		QueryRunner runner = new QueryRunner(DBMysql.getDataSource());
		String sql = "select max(id) from t_user";
		Integer m=(Integer) runner.query(sql,new ScalarHandler());
		int max=m.intValue();
		return max;
	}
	
	public Date getNewTimeMysql() throws SQLException{
		QueryRunner runner = new QueryRunner(DBMysql.getDataSource());
		String sql = "select max(changeTime) from t_user";
		Timestamp m=(Timestamp) runner.query(sql,new ScalarHandler());
		return m;
	}
	
	public Date getNewTimeOracle() throws SQLException{
		QueryRunner runner = new QueryRunner(DBOracle.getDataSource());
		String sql = "select max(changeTime) from t_user";
		Object m=(Object) runner.query(sql,new ScalarHandler());
		System.out.println("111"+m);
		
		return (Date) m;
	}
	
	public List<User> findUserJdbc(){
		List<User> userList = new ArrayList<User>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			connection=DBOracle.getConnection();
			String sql="select * from t_user";
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Long id=rs.getLong("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				
				User user=new User();
				user.setId(id);
				user.setUsername(name);
				user.setPassword(password);
				
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBOracle.close(ps, connection, rs);
		}
		return userList;
	}
	
	public static void main(String[] args) {
		UserDaoImpl u=new UserDaoImpl();
		try {
			List<User> userList=u.findUser();
			for (User user : userList) {
				System.out.println(user.getPassword());
				
			}
			
			List<User> userList1=u.findUser1(new Date());
			for (User user : userList1) {
				System.out.println(user.getPassword());
			}
			
			List<User> userList2=u.findUserJdbc();
			for (User user : userList2) {
				System.out.println("---"+user.getId());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
