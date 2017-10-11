package cn.lh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.lh.dao.Export1Dao;
import cn.lh.domain.Export1;
import cn.lh.util.DBUtil;

public class Export1DaoImpl implements Export1Dao{
	
	public Export1 findExport11(String suid,String sess,String sspid){
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Export1 export1 =null;
		try{
			connection = DBUtil.getContection();
			String sql = "SELECT dzsa.subname,dzsa.unit_address,dzsa.commit_time ,du.uname,du.idcard,du.mphone,du.sex," +
					"du.photourl FROM dl_z1_spec_apply dzsa ,dl_user du where du.uid = dzsa.uid and dzsa.uid = ? " +
					"and dzsa.spid = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, suid);
			ps.setString(2, sspid);
			rs = ps.executeQuery();
			while(rs.next()){
				String sicknessName = rs.getString("subname");
				String address = rs.getString("unit_address");
				String hospitalDate = rs.getString("commit_time");
				String username = rs.getString("uname");
				String medicalNumber = rs.getString("idcard");
				String phoneNumber = rs.getString("mphone");
				String gender = rs.getString("sex");
				//String age = rs.getString("insure_birth");
				//String checkingResource = rs.getString("t_name");
				String headPicture = rs.getString("photourl");
				export1 = new Export1();
				export1.setSicknessName(sicknessName);
				export1.setAddress(address);
				export1.setHospitalDate(hospitalDate);
				export1.setUsername(username);
				export1.setMedicalNumber(medicalNumber);
				export1.setPhoneNumber(phoneNumber);
				export1.setGender(gender);
				//export1.setAge(age);
				export1.setAge("25");
				//export1.setCheckingResource(checkingResource);
				//export1.setCheckingResource(DataUtil.getImageStr(CommonUtil.getRealPath(request, CommonUtil.IMAGE_PATH,"dress8.png")));
				export1.setHeadPicture(headPicture);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, null, connection);
		}
		return export1;
	}
	
	public static void main(String[] args) {
		//findExport11("0280000001", "C664600863200002DB33105A13101170", "20141123000000009");
	}
	
	public Export1 findExport1(String suid,String sess,String sspid){
		System.out.println("uid:"+suid+",sess:"+sess+",sspid:"+sspid);
		Connection connection = null;
		ResultSet rs = null;
		Export1 export1 =null;
		try{
			connection = DBUtil.getContection();
			CallableStatement call = connection.prepareCall("{call a1_gj_spec_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,sspid);
			//call.execute();
			//rs = call.getResultSet();
			rs = call.executeQuery();
			while(rs.next()){
				String s =  rs.getString(1);
				String s1 =  rs.getString(2);
				System.out.println(s+","+s1);
				String sicknessName = rs.getString("subname");
				String address = rs.getString("unit_address");
				String hospitalDate = rs.getString("commit_time");
				String username = rs.getString("uname");
				String medicalNumber = rs.getString("idcard");
				String phoneNumber = rs.getString("mphone");
				String gender = rs.getString("insure_sex");
				String age = rs.getString("insure_birth");
				String checkingResource = rs.getString("t_name");
				String headPicture = rs.getString("photourl");
				export1 = new Export1();
				export1.setSicknessName(sicknessName);
				export1.setAddress(address);
				export1.setHospitalDate(hospitalDate);
				export1.setUsername(username);
				export1.setMedicalNumber(medicalNumber);
				export1.setPhoneNumber(phoneNumber);
				export1.setGender(gender);
				export1.setAge(age);
				export1.setCheckingResource(checkingResource);
				export1.setHeadPicture(headPicture);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, null, connection);
		}
		return export1;
	}
	
}
