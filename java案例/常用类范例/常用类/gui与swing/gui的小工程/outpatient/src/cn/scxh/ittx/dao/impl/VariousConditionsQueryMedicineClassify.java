package cn.scxh.ittx.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.domain.MedicineClassify;

public class VariousConditionsQueryMedicineClassify {
	public static final String SQL="SELECT * FROM t_medicine_classify";
	static List<String> sqlList=null;
	public static String getSql(MedicineClassify classify){
		sqlList=new ArrayList<String>();
		String sql="SELECT * FROM t_medicine_classify";
		if(classify!=null){
			if(classify.getId()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where id=?";
					sqlList.add("id");
				}else{
					sql=sql+" and id=?";
					sqlList.add("id");
				}
			}
			if(classify.getName()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where name=?";
					sqlList.add("name");
				}else{
					sql=sql+" and name=?";
					sqlList.add("name");
				}
			}if(classify.getPid()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where name=?";
					sqlList.add("name");
				}else{
					sql=sql+" and name=?";
					sqlList.add("name");
				}
			}
		}
		return sql;
	}
	
	public static void setPreparedStatement(PreparedStatement ps,MedicineClassify classify) throws SQLException{
		for (int i=1;i<=sqlList.size();i++) {
			if("id".equals(sqlList.get(i-1))){
				ps.setInt(i, classify.getId());
			}
			if("name".equals(sqlList.get(i-1))){
				ps.setString(i, classify.getName());
			}
			if("id".equals(sqlList.get(i-1))){
				ps.setInt(i, classify.getPid());
			}
			
		}
	}
}
