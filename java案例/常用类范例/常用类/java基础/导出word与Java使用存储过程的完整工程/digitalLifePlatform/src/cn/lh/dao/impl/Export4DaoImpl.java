package cn.lh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import cn.lh.dao.Export4Dao;
import cn.lh.domain.Export4;
import cn.lh.util.CommonUtil;
import cn.lh.util.DBUtil;
import cn.lh.util.DataUtil;

public class Export4DaoImpl implements Export4Dao{

	public Export4 findExpor4(String suid, String sess, String spid) {
		Connection connection = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Export4 export4 = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_insure_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				List<String> list = DataUtil.getValueByKey(rs.getString("address"));
				String countyName = list.get(0);
				String townName = list.get(1);
				String villageName = list.get(2);
				
				String nation = rs.getString("nation");
				String postCode = rs.getString("postcode");
				String communicationAddress = rs.getString("teladdress");
				//String para = rs.getString("peopletype");
				//String para = rs.getString("insurancetype");
				//String uid = rs.getString("uid");
				//String para = rs.getString("insure_birth");
				//String para = rs.getString("mphone");
				
				String phoneNumber1_phoneNumber1 = "";
				String phoneNumber1_phoneNumber2 = "";
				String phoneNumber1_phoneNumber3 = "";
				String phoneNumber1_phoneNumber4 = "";
				String phoneNumber1_phoneNumber5 = "";
				String phoneNumber1_phoneNumber6 = "";
				String phoneNumber1_phoneNumber7 = "";
				String phoneNumber1_phoneNumber8 = "";
				String phoneNumber1_phoneNumber9 = "";
				String phoneNumber1_phoneNumber10 = "";
				String phoneNumber1_phoneNumber11 = "";
				
				String[] array = DataUtil.getValueOfStringArray(rs.getString("cellphone"));
				if(array.length>0){
					phoneNumber1_phoneNumber1 = array[0];
				}
				if(array.length>1){
					phoneNumber1_phoneNumber2 = array[1];
				}
				if(array.length>2){
					phoneNumber1_phoneNumber3 = array[2];
				}
				if(array.length>3){
					phoneNumber1_phoneNumber4 = array[3];
				}
				if(array.length>4){
					phoneNumber1_phoneNumber5 = array[4];
				}
				if(array.length>5){
					phoneNumber1_phoneNumber6 = array[5];
				}
				if(array.length>6){
					phoneNumber1_phoneNumber7 = array[6];
				}
				if(array.length>7){
					phoneNumber1_phoneNumber8 = array[7];
				}
				if(array.length>8){
					phoneNumber1_phoneNumber9 = array[8];
				}
				if(array.length>9){
					phoneNumber1_phoneNumber10 = array[9];
				}
				if(array.length>10){
					phoneNumber1_phoneNumber11 = array[10];
				}
				
				String phoneNumber2_phoneNumber1 = "";
				String phoneNumber2_phoneNumber2 = "";
				String phoneNumber2_phoneNumber3 = "";
				String phoneNumber2_phoneNumber4 = "";
				String phoneNumber2_phoneNumber5 = "";
				String phoneNumber2_phoneNumber6 = "";
				String phoneNumber2_phoneNumber7 = "";
				String phoneNumber2_phoneNumber8 = "";
				String phoneNumber2_phoneNumber9 = "";
				String phoneNumber2_phoneNumber10 = "";
				String phoneNumber2_phoneNumber11 = "";
				if(array.length>0){
					phoneNumber2_phoneNumber1 = array[0];
				}
				if(array.length>1){
					phoneNumber2_phoneNumber2 = array[1];
				}
				if(array.length>2){
					phoneNumber2_phoneNumber3 = array[2];
				}
				if(array.length>3){
					phoneNumber2_phoneNumber4 = array[3];
				}
				if(array.length>4){
					phoneNumber2_phoneNumber5 = array[4];
				}
				if(array.length>5){
					phoneNumber2_phoneNumber6 = array[5];
				}
				if(array.length>6){
					phoneNumber2_phoneNumber7 = array[6];
				}
				if(array.length>7){
					phoneNumber2_phoneNumber8 = array[7];
				}
				if(array.length>8){
					phoneNumber2_phoneNumber9 = array[8];
				}
				if(array.length>9){
					phoneNumber2_phoneNumber10 = array[9];
				}
				if(array.length>10){
					phoneNumber2_phoneNumber11 = array[10];
				}
				
				array = DataUtil.getValueOfStringArray(rs.getString("tel"));
				if(array.length>0){
					phoneNumber2_phoneNumber1 = array[0];
				}
				if(array.length>1){
					phoneNumber2_phoneNumber2 = array[1];
				}
				if(array.length>2){
					phoneNumber2_phoneNumber3 = array[2];
				}
				if(array.length>3){
					phoneNumber2_phoneNumber4 = array[3];
				}
				if(array.length>4){
					phoneNumber2_phoneNumber5 = array[4];
				}
				if(array.length>5){
					phoneNumber2_phoneNumber6 = array[5];
				}
				if(array.length>6){
					phoneNumber2_phoneNumber7 = array[6];
				}
				if(array.length>7){
					phoneNumber2_phoneNumber8 = array[7];
				}
				if(array.length>8){
					phoneNumber2_phoneNumber9 = array[8];
				}
				if(array.length>9){
					phoneNumber2_phoneNumber10 = array[9];
				}
				if(array.length>10){
					phoneNumber2_phoneNumber11 = array[10];
				}
				
				
				String identifyNumber_number1 = "";
				String identifyNumber_number2 = "";
				String identifyNumber_number3 = "";
				String identifyNumber_number4 = "";
				String identifyNumber_number5 = "";
				String identifyNumber_number6 = "";
				String identifyNumber_number7 = "";
				String identifyNumber_number8 = "";
				String identifyNumber_number9 = "";
				String identifyNumber_number10 ="";
				String identifyNumber_number11 ="";
				String identifyNumber_number12 ="";
				String identifyNumber_number13 ="";
				String identifyNumber_number14 ="";
				String identifyNumber_number15 ="";
				String identifyNumber_number16 ="";
				String identifyNumber_number17 ="";
				String identifyNumber_number18 ="";
				
				array = DataUtil.getValueOfStringArray(rs.getString("idcard"));
				if(array.length>0){
					phoneNumber2_phoneNumber1 = array[0];
				}
				if(array.length>1){
					phoneNumber2_phoneNumber2 = array[1];
				}
				if(array.length>2){
					phoneNumber2_phoneNumber3 = array[2];
				}
				if(array.length>3){
					phoneNumber2_phoneNumber4 = array[3];
				}
				if(array.length>4){
					phoneNumber2_phoneNumber5 = array[4];
				}
				if(array.length>5){
					phoneNumber2_phoneNumber6 = array[5];
				}
				if(array.length>6){
					phoneNumber2_phoneNumber7 = array[6];
				}
				if(array.length>7){
					phoneNumber2_phoneNumber8 = array[7];
				}
				if(array.length>8){
					phoneNumber2_phoneNumber9 = array[8];
				}
				if(array.length>9){
					phoneNumber2_phoneNumber10 = array[9];
				}
				if(array.length>10){
					phoneNumber2_phoneNumber11 = array[10];
				}
				
				array = DataUtil.getValueOfStringArray(rs.getString("tel"));
				if(array.length>0){
					identifyNumber_number1 = array[0];
				}
				if(array.length>1){
					identifyNumber_number2 = array[1];
				}
				if(array.length>2){
					identifyNumber_number3 = array[2];
				}
				if(array.length>3){
					identifyNumber_number4 = array[3];
				}
				if(array.length>4){
					identifyNumber_number5 = array[4];
				}
				if(array.length>5){
					System.out.println(array.length);
					identifyNumber_number6 = array[5];
				}
				if(array.length>6){
					identifyNumber_number7 = array[6];
				}
				if(array.length>7){
					identifyNumber_number8 = array[7];
				}
				if(array.length>8){
					identifyNumber_number9 = array[8];
				}
				if(array.length>9){
					identifyNumber_number10 = array[9];
				}
				if(array.length>10){
					identifyNumber_number11 = array[10];
				}
				if(array.length>11){
					identifyNumber_number12 = array[11];
				}
				if(array.length>12){
					identifyNumber_number13 = array[12];
				}
				if(array.length>13){
					identifyNumber_number14 = array[13];
				}
				if(array.length>14){
					identifyNumber_number15 = array[14];
				}
				if(array.length>15){
					identifyNumber_number16 = array[15];
				}
				if(array.length>16){
					identifyNumber_number17 = array[16];
				}
				if(array.length>17){
					identifyNumber_number18 = array[17];
				}
				
				String chinaBank = "" ;
				String businessBank = "" ;
				String buildBank = "" ;
				String agricultureBank = "" ;
				String postBank = "" ;
				String villageBank = "" ;
				String leShanBusinessBank = "" ;
				
				String ibId = rs.getString("ib_id");
				if("1".equals(ibId)){
					chinaBank = CommonUtil.BANK_VALUE;
				}else if("2".equals(ibId)){
					businessBank = CommonUtil.BANK_VALUE;
				}else if("3".equals(ibId)){
					buildBank = CommonUtil.BANK_VALUE;
				}else if("4".equals(ibId)){
					agricultureBank = CommonUtil.BANK_VALUE;
				}else if("5".equals(ibId)){
					postBank = CommonUtil.BANK_VALUE;
				}else if("6".equals(ibId)){
					villageBank = CommonUtil.BANK_VALUE;
				}else if("7".equals(ibId)){
					leShanBusinessBank = CommonUtil.BANK_VALUE;
				}
				String username = rs.getString("uname");
				String gender = rs.getString("insure_sex");
				String frontIdentifyCopyPicture = rs.getString("idcardFrontUrl");
				String reverseSideIdentifyCopyPicture = rs.getString("idcardBackUrl");
				String headerPicture = rs.getString("photourl");
				
				export4 = new Export4();
				export4.setAgricultureBank(agricultureBank);
				export4.setBuildBank(buildBank);
				export4.setBusinessBank(businessBank);
				export4.setChinaBank(chinaBank);
				export4.setCommunicationAddress(communicationAddress);
				export4.setCountyName(countyName);
				export4.setFrontIdentifyCopyPicture(frontIdentifyCopyPicture);
				if(gender != null){
					export4.setGender(gender);
				}
				export4.setHeaderPicture(headerPicture);
				export4.setLeShanBusinessBank(leShanBusinessBank);
				export4.setNation(nation);
				export4.setPostBank(postBank);
				export4.setPostCode(postCode);
				export4.setReverseSideIdentifyCopyPicture(reverseSideIdentifyCopyPicture);
				export4.setTownName(townName);
				export4.setUsername(username);
				export4.setVillageBank(villageBank);
				export4.setVillageName(villageName);
				
				export4.getIdentifyNumber().setNumber1(identifyNumber_number1);
				export4.getIdentifyNumber().setNumber2(identifyNumber_number2);
				export4.getIdentifyNumber().setNumber3(identifyNumber_number3);
				export4.getIdentifyNumber().setNumber4(identifyNumber_number4);
				export4.getIdentifyNumber().setNumber5(identifyNumber_number5);
				export4.getIdentifyNumber().setNumber6(identifyNumber_number6);
				export4.getIdentifyNumber().setNumber7(identifyNumber_number7);
				export4.getIdentifyNumber().setNumber8(identifyNumber_number8);
				export4.getIdentifyNumber().setNumber9(identifyNumber_number9);
				export4.getIdentifyNumber().setNumber10(identifyNumber_number10);
				export4.getIdentifyNumber().setNumber11(identifyNumber_number11);
				export4.getIdentifyNumber().setNumber12(identifyNumber_number12);
				export4.getIdentifyNumber().setNumber13(identifyNumber_number13);
				export4.getIdentifyNumber().setNumber14(identifyNumber_number14);
				export4.getIdentifyNumber().setNumber15(identifyNumber_number15);
				export4.getIdentifyNumber().setNumber16(identifyNumber_number16);
				export4.getIdentifyNumber().setNumber17(identifyNumber_number17);
				export4.getIdentifyNumber().setNumber18(identifyNumber_number18);
				
				export4.getPhoneNumber1().setPhoneNumber1(phoneNumber1_phoneNumber1);
				export4.getPhoneNumber1().setPhoneNumber2(phoneNumber1_phoneNumber2);
				export4.getPhoneNumber1().setPhoneNumber3(phoneNumber1_phoneNumber3);
				export4.getPhoneNumber1().setPhoneNumber4(phoneNumber1_phoneNumber4);
				export4.getPhoneNumber1().setPhoneNumber5(phoneNumber1_phoneNumber5);
				export4.getPhoneNumber1().setPhoneNumber6(phoneNumber1_phoneNumber6);
				export4.getPhoneNumber1().setPhoneNumber7(phoneNumber1_phoneNumber7);
				export4.getPhoneNumber1().setPhoneNumber8(phoneNumber1_phoneNumber8);
				export4.getPhoneNumber1().setPhoneNumber9(phoneNumber1_phoneNumber9);
				export4.getPhoneNumber1().setPhoneNumber10(phoneNumber1_phoneNumber10);
				export4.getPhoneNumber1().setPhoneNumber11(phoneNumber1_phoneNumber11);
				
				export4.getPhoneNumber2().setPhoneNumber1(phoneNumber2_phoneNumber1);
				export4.getPhoneNumber2().setPhoneNumber2(phoneNumber2_phoneNumber2);
				export4.getPhoneNumber2().setPhoneNumber3(phoneNumber2_phoneNumber3);
				export4.getPhoneNumber2().setPhoneNumber4(phoneNumber2_phoneNumber4);
				export4.getPhoneNumber2().setPhoneNumber5(phoneNumber2_phoneNumber5);
				export4.getPhoneNumber2().setPhoneNumber6(phoneNumber2_phoneNumber6);
				export4.getPhoneNumber2().setPhoneNumber7(phoneNumber2_phoneNumber7);
				export4.getPhoneNumber2().setPhoneNumber8(phoneNumber2_phoneNumber8);
				export4.getPhoneNumber2().setPhoneNumber9(phoneNumber2_phoneNumber9);
				export4.getPhoneNumber2().setPhoneNumber10(phoneNumber2_phoneNumber10);
				export4.getPhoneNumber2().setPhoneNumber11(phoneNumber2_phoneNumber11);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return export4;
	}

}
