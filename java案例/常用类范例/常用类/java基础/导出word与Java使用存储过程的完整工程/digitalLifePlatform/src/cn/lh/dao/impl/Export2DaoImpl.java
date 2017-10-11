package cn.lh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import cn.lh.dao.Export2Dao;
import cn.lh.domain.Export2;
import cn.lh.util.DBUtil;
import cn.lh.util.DataUtil;

public class Export2DaoImpl implements Export2Dao{

	public Export2 findExpor2(String suid, String sess, String spid) {
		Connection connection = null;
		ResultSet rs = null;
		Export2 export2 = null;
		CallableStatement call = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_remote_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				List<String[]> hos = DataUtil.getValueOfHospitals(rs.getString("hospitals"));
				String hospitalGrade1 = hos.get(0)[0];
				String hospitalAddress1 = hos.get(0)[1];
				String hospitalGrade2= "";
				String hospitalAddress2 = "";
				String hospitalGrade3 = "";
				String hospitalAddress3 = "";
				if(hos.size() == 2){
					hospitalGrade2 = hos.get(1)[0];
					hospitalAddress2 = hos.get(1)[1];
				}
				if(hos.size() == 3){
					hospitalGrade3 = hos.get(2)[0];
					hospitalAddress3 = hos.get(2)[1];
				}
				String company = rs.getString("unit_name");
				String salary = rs.getString("pay");
				String address = rs.getString("remote_address");
				String contactPerson = rs.getString("remote_people");
				String contactPhoneNumber = rs.getString("remote_phone");
				//String uid = rs.getString("uid");
				String user = rs.getString("uname");
				String hospitalNumber = rs.getString("idcard");
				//String contactPhoneNumber = rs.getString("mphone");
				String gender = rs.getString("insure_sex");
				String age = rs.getString("insure_birth");
				String identityCardCopyPicture = rs.getString("idcardFrontUrl");
				export2 = new Export2();
				export2.setHospitalGrade1(hospitalGrade1);
				export2.setHospitalAddress1(hospitalAddress1);
				export2.setHospitalGrade2(hospitalGrade2);
				export2.setHospitalAddress2(hospitalAddress2);
				export2.setHospitalGrade3(hospitalGrade3);
				export2.setHospitalAddress3(hospitalAddress3);
				export2.setCompany(company);
				export2.setSalary(salary);
				export2.setAddress(address);
				export2.setContactPerson(contactPerson);
				export2.setContactPhoneNumber(contactPhoneNumber);
				export2.setUser(user);
				export2.setHospitalNumber(hospitalNumber);
				export2.setGender(gender);
				export2.setAge(age);
				export2.setIdentityCardCopyPicture(identityCardCopyPicture);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return export2;
	}
	
	
	
}
