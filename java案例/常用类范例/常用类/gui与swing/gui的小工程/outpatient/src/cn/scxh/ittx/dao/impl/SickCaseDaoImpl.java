package cn.scxh.ittx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.dao.intf.SickCaseDao;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.util.DBConnection;

public class SickCaseDaoImpl implements SickCaseDao{

	public void addSickCase(SickCase sickCase) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO t_sick_case(id,main_symptom,now_symptom," +
					"past_symptom,personal_symptom,body_test,lab_test,examination," +
					"advice,other_explain,examination_time,patient_id_fk) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, sickCase.getId());
			ps.setString(2, sickCase.getMainSymptom());
			ps.setString(3, sickCase.getNowSymptom());
			ps.setString(4, sickCase.getPastSymptom());
			ps.setString(5, sickCase.getPersonalSymptom());
			ps.setString(6, sickCase.getBodyTest());
			ps.setString(7,sickCase.getLabTest());
			ps.setString(8, sickCase.getExamination());
			ps.setString(9, sickCase.getAdvice());
			ps.setString(10,sickCase.getOtherExplain());
			ps.setDate(11,new java.sql.Date(sickCase.getExaminationTime().getTime()));
			ps.setString(12, sickCase.getPatientIdFk());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	public void deleteSickCase(SickCase sickCase) throws SQLException {

		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="DELETE FROM t_sick_case where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1,sickCase.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	public List<SickCase> differenceConditionQuerySickCase(SickCase sickCase)
			throws SQLException {
		List<SickCase> sickCaseList=new ArrayList<SickCase>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
			connection = DBConnection.getConnection();
			String sql=VariousConditionsQuerySickCase.getSql(sickCase);
			ps=connection.prepareStatement(sql);
			VariousConditionsQuerySickCase.setPreparedStatement(ps, sickCase);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String mainSymptom=rs.getString("main_symptom");
				String nowSymptom=rs.getString("now_symptom");
				String pastSymptom=rs.getString("past_symptom");
				String personalSymptom=rs.getString("personal_symptom");
				String bodyTest=rs.getString("body_test");
				String labTest=rs.getString("lab_test");
				String examination=rs.getString("examination");
				String advice=rs.getString("advice");
				String otherExplain=rs.getString("other_explain");
				java.sql.Date examinationTime=rs.getDate("examination_time");
				String patientIdFk=rs.getString("patient_id_fk");
				SickCase sc=new SickCase();
				sc.setId(id);
				sc.setMainSymptom(mainSymptom);
				sc.setNowSymptom(nowSymptom);
				sc.setPastSymptom(pastSymptom);
				sc.setPersonalSymptom(personalSymptom);
				sc.setBodyTest(bodyTest);
				sc.setLabTest(labTest);
				sc.setExamination(examination);
				sc.setAdvice(advice);
				sc.setOtherExplain(otherExplain);
				sc.setExaminationTime(examinationTime);
				sc.setPatientIdFk(patientIdFk);
				sickCaseList.add(sc);
			}
			DBConnection.close(rs,ps, connection);
		
		
		return sickCaseList;
	}

	public List<SickCase> theLargestNumberOfSikeCase() throws SQLException {
		List<SickCase> sickCaseList=new ArrayList<SickCase>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        connection=DBConnection.getConnection();
        String sql="SELECT max(id) FROM t_sick_case";
        ps=connection.prepareStatement(sql);
        rs=ps.executeQuery();
        if(rs.next()){
        	String id=rs.getString("max(id)");
        	SickCase sc=new SickCase();
        	sc.setId(Integer.parseInt(id));
        	sickCaseList.add(sc);
        }
		return sickCaseList;
	}

	public void updateSickCase(SickCase sickCase) throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="UPDATE t_sick_case set id=?,main_symptom=?,now_symptom=?," +
					"past_symptom=?,personal_symptom=?,body_test=?,lab_test=?,examination=?," +
					"advice=?,other_explain=?,examination_time=?,patient_id_fk=? where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, sickCase.getId());
			ps.setString(2, sickCase.getMainSymptom());
			ps.setString(3, sickCase.getNowSymptom());
			ps.setString(4, sickCase.getPastSymptom());
			ps.setString(5, sickCase.getPersonalSymptom());
			ps.setString(6, sickCase.getBodyTest());
			ps.setString(7,sickCase.getLabTest());
			ps.setString(8, sickCase.getExamination());
			ps.setString(9, sickCase.getAdvice());
			ps.setString(10,sickCase.getOtherExplain());
			ps.setDate(11,new java.sql.Date(sickCase.getExaminationTime().getTime()));
			ps.setString(12, sickCase.getPatientIdFk());
			ps.setInt(13, sickCase.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

}
