package cn.scxh.ittx.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.domain.SickCase;

public class VariousConditionsQuerySickCase {

	public static final String SQL="SELECT * FROM t_sick_case";
	static List<String> sqlList=null;
	public static String getSql(SickCase sickCase){
		sqlList=new ArrayList<String>();
		String sql="SELECT * FROM t_sick_case";
		if(sickCase!=null){
			if(sickCase.getId()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where id=?";
					sqlList.add("id");
				}else{
					sql=sql+" and id=?";
					sqlList.add("id");
				}
			}
			if(sickCase.getMainSymptom()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where main_symptom=?";
					sqlList.add("main_symptom");
				}else{
					sql=sql+" and main_symptom=?";
					sqlList.add("main_symptom");
				}
			}if(sickCase.getNowSymptom()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where now_symptom=?";
					sqlList.add("now_symptom");
				}else{
					sql=sql+" and now_symptom=?";
					sqlList.add("now_symptom");
				}
			}
			if(sickCase.getPastSymptom()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where past_symptom=?";
					sqlList.add("past_symptom");
				}else{
					sql=sql+" and past_symptom=?";
					sqlList.add("past_symptom");
				}
			}if(sickCase.getPersonalSymptom()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where personal_symptom=?";
					sqlList.add("personal_symptom");
				}else{
					sql=sql+" and personal_symptom=?";
					sqlList.add("personal_symptom");
				}
			}if(sickCase.getBodyTest()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where body_test=?";
					sqlList.add("body_test");
				}else{
					sql=sql+" and body_test=?";
					sqlList.add("body_test");
				}
			}if(sickCase.getLabTest()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where lab_test=?";
					sqlList.add("lab_test");
				}else{
					sql=sql+" and lab_test=?";
					sqlList.add("lab_test");
				}
			}if(sickCase.getExamination()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where examination=?";
					sqlList.add("examination");
				}else{
					sql=sql+" and examination=?";
					sqlList.add("examination");
				}
			}if(sickCase.getAdvice()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where advice=?";
					sqlList.add("advice");
				}else{
					sql=sql+" and advice=?";
					sqlList.add("advice");
				}
			}if(sickCase.getOtherExplain()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where other_explain=?";
					sqlList.add("other_explain");
				}else{
					sql=sql+" and other_explain=?";
					sqlList.add("other_explain");
				}
			}if(sickCase.getExaminationTime()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where examination_time=?";
					sqlList.add("examination_time");
				}else{
					sql=sql+" and examination_time=?";
					sqlList.add("examination_time");
				}
			}if(sickCase.getPatientIdFk()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where patient_id_fk=?";
					sqlList.add("patient_id_fk");
				}else{
					sql=sql+" and patient_id_fk=?";
					sqlList.add("patient_id_fk");
				}
			}
		}
		return sql;
	}
	
	public static void setPreparedStatement(PreparedStatement ps,SickCase sickCase) throws SQLException{
		for (int i=1;i<=sqlList.size();i++) {
			if("id".equals(sqlList.get(i-1))){
				ps.setInt(i, sickCase.getId());
			}
			if("main_symptom".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getMainSymptom());
			}
			if("now_symptom".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getNowSymptom());
			}
			if("past_symptom".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getPastSymptom());
			}if("personal_symptom".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getPersonalSymptom());
			}if("body_test".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getBodyTest());
			}if("lab_test".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getLabTest());
			}if("examination".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getExamination());
			}if("advice".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getAdvice());
			}if("other_explain".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getOtherExplain());
			}if("examination_time".equals(sqlList.get(i-1))){
				ps.setDate(i, new java.sql.Date(sickCase.getExaminationTime().getTime()));
			}if("patient_id_fk".equals(sqlList.get(i-1))){
				ps.setString(i, sickCase.getPatientIdFk());
			}
		}
	}
}
