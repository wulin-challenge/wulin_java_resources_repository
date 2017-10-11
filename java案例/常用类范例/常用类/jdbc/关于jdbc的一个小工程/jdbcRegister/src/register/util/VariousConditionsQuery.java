package register.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import register.domain.Student;

public class VariousConditionsQuery {
	public static final String SQL="SELECT * FROM t_studentRegister";
	static List<String> sqlList=null;
	public static String getSql(Student student){
		sqlList=new ArrayList<String>();
		String sql="SELECT * FROM t_studentRegister";
		if(student!=null){
			if(student.getId()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where id=?";
					sqlList.add("id");
				}else{
					sql=sql+" and id=?";
					sqlList.add("id");
				}
			}
			if(student.getName()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where name=?";
					sqlList.add("name");
				}else{
					sql=sql+" and name=?";
					sqlList.add("name");
				}
			}if(student.getPassword()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where password=?";
					sqlList.add("password");
				}else{
					sql=sql+" and password=?";
					sqlList.add("password");
				}
			}if(student.getIdentityNumber()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where identityNumber=?";
					sqlList.add("identityNumber");
				}else{
					sql=sql+" and identityNumber=?";
					sqlList.add("identityNumber");
				}
			}if(student.getRegisterDate()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where registerDate=?";
					sqlList.add("registerDate");
				}else{
					sql=sql+" and registerDate=?";
					sqlList.add("registerDate");
				}
			}if(student.getGender()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where gender=?";
					sqlList.add("gender");
				}else{
					sql=sql+" and gender=?";
					sqlList.add("gender");
				}
			}
		}
		return sql;
	}
	
	public static void setPreparedStatement(PreparedStatement ps,Student student) throws SQLException{
		for (int i=1;i<=sqlList.size();i++) {
			if("id".equals(sqlList.get(i-1))){
				ps.setInt(i, student.getId());
			}
			if("name".equals(sqlList.get(i-1))){
				ps.setString(i, student.getName());
				System.out.println(student.getName());
			}
			if("password".equals(sqlList.get(i-1))){
				ps.setString(i, student.getPassword());
			}
			if("gender".equals(sqlList.get(i-1))){
				ps.setString(i, student.getGender());
			}
			if("identityNumber".equals(sqlList.get(i-1))){
				ps.setString(i, student.getIdentityNumber());
			}
			if("registerDate".equals(sqlList.get(i-1))){
				ps.setDate(i, new java.sql.Date(student.getRegisterDate().getTime()));
			}
		}
	}
}
