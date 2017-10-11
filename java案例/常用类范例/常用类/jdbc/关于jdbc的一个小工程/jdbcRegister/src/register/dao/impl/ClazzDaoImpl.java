package register.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import register.dao.ClazzDao;
import register.domain.Clazz;
import register.util.DBConnection;

public class ClazzDaoImpl implements ClazzDao{

	public void addClazz(Clazz clazz) {
		Connection connection=null;
		PreparedStatement ps=null;
		try{
			connection=DBConnection.getConnection();
			String sql="INSERT INTO clazz(id,name) values(?,?)";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, clazz.getId());
			ps.setString(2, clazz.getName());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(ps, connection);
		}
	}

	public void deleteClassById(int id) {
		Connection connection=null;
		PreparedStatement ps=null;
		try{
			connection=DBConnection.getConnection();
			String sql="DELETE FROM clazz where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(ps, connection);
		}
		
	}

	public List<Clazz> queryClazzById(int id) {
		List<Clazz> clazzList=new ArrayList<Clazz>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			connection=DBConnection.getConnection();
			String sql="select * from clazz where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				int i=rs.getInt("id");
				String name=rs.getString("name");
				Clazz clazz=new Clazz();
				clazz.setId(i);
				clazz.setName(name);
				clazzList.add(clazz);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,ps, connection);
		}
		return clazzList;
	}

	public List<Clazz> queryClazzs() {
		List<Clazz> clazzList=new ArrayList<Clazz>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			connection=DBConnection.getConnection();
			String sql="select * from clazz";
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				Clazz clazz=new Clazz();
				clazz.setId(id);
				clazz.setName(name);
				clazzList.add(clazz);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,ps, connection);
		}
		return clazzList;
	}

	public void updateClazz(Clazz clazz) {
		Connection connection=null;
		PreparedStatement ps=null;
		try{
			connection=DBConnection.getConnection();
			String sql="update clazz set name=? where id=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, clazz.getName());
			ps.setInt(2, clazz.getId());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(ps, connection);
		}
	}

}
