package cn.scxh.ittx.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.domain.User;


public class VariousConditionsQuery {
	public static final String SQL="SELECT * FROM t_user";
	static List<String> sqlList=null;
	public static String getSql(User user){
		sqlList=new ArrayList<String>();
		String sql="SELECT * FROM t_user";
		if(user!=null){
			if(user.getId()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where id=?";
					sqlList.add("id");
				}else{
					sql=sql+" and id=?";
					sqlList.add("id");
				}
			}
			if(user.getName()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where name=?";
					sqlList.add("name");
				}else{
					sql=sql+" and name=?";
					sqlList.add("name");
				}
			}if(user.getPassword()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where password=?";
					sqlList.add("password");
				}else{
					sql=sql+" and password=?";
					sqlList.add("password");
				}
			}
			if(user.getStatus()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where status=?";
					sqlList.add("status");
				}else{
					sql=sql+" and status=?";
					sqlList.add("status");
				}
			}
		}
		return sql;
	}
	
	public static void setPreparedStatement(PreparedStatement ps,User user) throws SQLException{
		for (int i=1;i<=sqlList.size();i++) {
			if("id".equals(sqlList.get(i-1))){
				ps.setInt(i, user.getId());
			}
			if("name".equals(sqlList.get(i-1))){
				ps.setString(i, user.getName());
			}
			if("password".equals(sqlList.get(i-1))){
				ps.setString(i, user.getPassword());
			}
			if("status".equals(sqlList.get(i-1))){
				ps.setString(i, user.getStatus());
			}
		}
	}
}
