package cn.lh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import cn.lh.dao.Export3Dao;
import cn.lh.domain.Export3;
import cn.lh.domain.MyDate;
import cn.lh.util.DBUtil;
import cn.lh.util.DataUtil;

public class Export3DaoImpl implements Export3Dao{

	public Export3 findExpor3(String suid, String sess, String spid) {
		Connection connection = null;
		ResultSet rs = null;
		Export3 export3 = null;
		CallableStatement call = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_single_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				String sicknessName = rs.getString("subname");
				String company = rs.getString("unit_name");
				String companyAddressAndFamilyAddress = rs.getString("add_address");
				String medicalTreatmentDate = rs.getString("diagnose_date");
				List<String>  m = DataUtil.getValueByKey(rs.getString("apply_hos_doctor"));
				String hospital = m.get(0);
				String sectionCheif = m.get(1);
				String doctor = m.get(2);
				m = DataUtil.getValueByKey1(medicalTreatmentDate);
				
				String myDate1_year = m.get(0);
				String myDate1_month = m.get(1);
				String myDate1_day = m.get(2);
				m = DataUtil.getValueByKey1(rs.getString("add_begin_time"));
			
				String myDate2_year = m.get(0);
				String myDate2_month = m.get(1);
				String myDate2_day = m.get(2);
				
				m = DataUtil.getValueByKey1(rs.getString("add_end_time"));
				
				String myDate3_year = m.get(0);
				String myDate3_month = m.get(1);
				String myDate3_day = m.get(2);
				
				String medicinal = rs.getString("add_drugs");
				m = DataUtil.getValueByKey(rs.getString("add_pays"));
				String allCost = m.get(0);
				String medicinalCost = m.get(1);
				String checkTreatmentCost = m.get(2);
				
				String cause = rs.getString("add_reason");
				String uid = rs.getString("uid");
				String user = rs.getString("uname");
				String hospitalNumber = rs.getString("idcard");
				String contactPhone = rs.getString("mphone");
				String gender = rs.getString("insure_sex");
				String age = rs.getString("insure_birth");
				String medicalTreatmentResource = rs.getString("t_name");
				
				export3 = new Export3();
				export3.setAge(age);
				export3.setAllCost(allCost);
				export3.setCause(cause);
				export3.setCheckTreatmentCost(checkTreatmentCost);
				export3.setCompany(company);
				export3.setContactPhone(contactPhone);
				//export3.setCostControl(costControl);
				//export3.setCountTreatmentCost(countTreatmentCost);
				export3.setDoctor(doctor);
				export3.setGender(gender);
				export3.setHospital(hospital);
				export3.setHospitalNumber(hospitalNumber);
				export3.setMedicalTreatmentDate(medicalTreatmentDate);
				export3.setMedicalTreatmentResource(medicalTreatmentResource);
				export3.setMedicinal(medicinal);
				export3.setMedicinalCost(medicinalCost);
				export3.setCompanyAddressAndFamilyAddress(companyAddressAndFamilyAddress);
				MyDate mydate = new MyDate();
				mydate.setYear(myDate1_year);
				mydate.setMonth(myDate1_month);
				mydate.setDay(myDate1_day);
				export3.setMyDate1(mydate);
				
				mydate.setYear(myDate2_year);
				mydate.setMonth(myDate2_month);
				mydate.setDay(myDate2_day);
				export3.setMyDate2(mydate);
				
				mydate.setYear(myDate3_year);
				mydate.setMonth(myDate3_month);
				mydate.setDay(myDate3_day);
				export3.setMyDate3(mydate);
				
				export3.setSectionCheif(sectionCheif);
				export3.setSectionCheif(sicknessName);
				export3.setSicknessName(sicknessName);
				export3.setUser(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return export3;
	}

}
