package cn.scxh.ittx.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.domain.Patient;

public class VariousConditionsQueryPatient {
	public static final String SQL="SELECT * FROM t_patient";
	static List<String> sqlList=null;
	public static String getSql(Patient patient){
		sqlList=new ArrayList<String>();
		String sql="SELECT * FROM t_patient";
		if(patient!=null){
			if(patient.getId()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where id=?";
					sqlList.add("id");
				}else{
					sql=sql+" and id=?";
					sqlList.add("id");
				}
			}
			if(patient.getName()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where name=?";
					sqlList.add("name");
				}else{
					sql=sql+" and name=?";
					sqlList.add("name");
				}
			}if(patient.getSex()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where sex=?";
					sqlList.add("sex");
				}else{
					sql=sql+" and sex=?";
					sqlList.add("sex");
				}
			}
			if(patient.getAge()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where age=?";
					sqlList.add("age");
				}else{
					sql=sql+" and age=?";
					sqlList.add("age");
				}
			}if(patient.getMarried()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where married=?";
					sqlList.add("married");
				}else{
					sql=sql+" and married=?";
					sqlList.add("married");
				}
			}if(patient.getJob()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where job=?";
					sqlList.add("job");
				}else{
					sql=sql+" and job=?";
					sqlList.add("job");
				}
			}if(patient.getWeight()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where weight=?";
					sqlList.add("weight");
				}else{
					sql=sql+" and weight=?";
					sqlList.add("weight");
				}
			}if(patient.getBlood()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where blood=?";
					sqlList.add("blood");
				}else{
					sql=sql+" and blood=?";
					sqlList.add("blood");
				}
			}if(patient.getPhoneNumber()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where phone_number=?";
					sqlList.add("phone_number");
				}else{
					sql=sql+" and phone_number=?";
					sqlList.add("phone_number");
				}
			}if(patient.getRegisterTime()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where register_time=?";
					sqlList.add("register_time");
				}else{
					sql=sql+" and register_time=?";
					sqlList.add("register_time");
				}
			}if(patient.getAddress()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where address=?";
					sqlList.add("address");
				}else{
					sql=sql+" and address=?";
					sqlList.add("address");
				}
			}if(patient.getAllergy()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where allergy=?";
					sqlList.add("allergy");
				}else{
					sql=sql+" and allergy=?";
					sqlList.add("allergy");
				}
			}if(patient.getRemark()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where remark=?";
					sqlList.add("remark");
				}else{
					sql=sql+" and remark=?";
					sqlList.add("remark");
				}
			}
		}
		return sql;
	}
	
	public static void setPreparedStatement(PreparedStatement ps,Patient patient) throws SQLException{
		for (int i=1;i<=sqlList.size();i++) {
			if("id".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getId());
			}
			if("name".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getName());
			}
			if("sex".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getSex());
			}
			if("age".equals(sqlList.get(i-1))){
				ps.setInt(i, patient.getAge());
			}if("married".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getMarried());
			}if("job".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getJob());
			}if("weight".equals(sqlList.get(i-1))){
				ps.setInt(i, patient.getWeight());
			}if("blood".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getBlood());
			}if("phone_number".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getPhoneNumber());
			}if("register_time".equals(sqlList.get(i-1))){
				ps.setDate(i, new java.sql.Date(patient.getRegisterTime().getTime()));
			}if("address".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getAddress());
			}if("allergy".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getAllergy());
			}if("remark".equals(sqlList.get(i-1))){
				ps.setString(i, patient.getRemark());
			}
		}
	}
}
