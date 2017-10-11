package cn.scxh.ittx.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.domain.Medicine;

public class VariousConditionsQueryMedicine {

	public static final String SQL="SELECT * FROM t_medicine";
	static List<String> sqlList=null;
	public static String getSql(Medicine medicine){
		sqlList=new ArrayList<String>();
		String sql="SELECT * FROM t_medicine";
		if(medicine!=null){
			if(medicine.getId()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where id=?";
					sqlList.add("id");
				}else{
					sql=sql+" and id=?";
					sqlList.add("id");
				}
			}
			if(medicine.getName()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where name=?";
					sqlList.add("name");
				}else{
					sql=sql+" and name=?";
					sqlList.add("name");
				}
			}if(medicine.getClassification()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where classification=?";
					sqlList.add("classification");
				}else{
					sql=sql+" and classification=?";
					sqlList.add("classification");
				}
			}
			if(medicine.getStandard()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where standard=?";
					sqlList.add("standard");
				}else{
					sql=sql+" and standard=?";
					sqlList.add("standard");
				}
			}if(medicine.getEnterCompany()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where enter_company=?";
					sqlList.add("enter_company");
				}else{
					sql=sql+" and enter_company=?";
					sqlList.add("enter_company");
				}
			}if(medicine.getEnterPrice()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where enter_price=?";
					sqlList.add("enter_price");
				}else{
					sql=sql+" and enter_price=?";
					sqlList.add("enter_price");
				}
			}if(medicine.getShoppingPrice()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where shopping_price=?";
					sqlList.add("shopping_price");
				}else{
					sql=sql+" and shopping_price=?";
					sqlList.add("shopping_price");
				}
			}if(medicine.getValidateNumber()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where validate_number=?";
					sqlList.add("validate_number");
				}else{
					sql=sql+" and validate_number=?";
					sqlList.add("validate_number");
				}
			}if(medicine.getApproveNumber()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where sale_price=?";
					sqlList.add("sale_price");
				}else{
					sql=sql+" and sale_price=?";
					sqlList.add("sale_price");
				}
			}if(medicine.getSimpleName()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where simple_name=?";
					sqlList.add("simple_name");
				}else{
					sql=sql+" and simple_name=?";
					sqlList.add("simple_name");
				}
			}if(medicine.getUpperLimit()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where upper_limit=?";
					sqlList.add("upper_limit");
				}else{
					sql=sql+" and upper_limit=?";
					sqlList.add("upper_limit");
				}
			}if(medicine.getApproveNumber()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where approve_number=?";
					sqlList.add("approve_number");
				}else{
					sql=sql+" and approve_number=?";
					sqlList.add("approve_number");
				}
			}
			if(medicine.getProduceCompany()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where produce_company=?";
					sqlList.add("produce_company");
				}else{
					sql=sql+" and produce_company=?";
					sqlList.add("produce_company");
				}
			}
			if(medicine.getMainComponent()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where main_component=?";
					sqlList.add("main_component");
				}else{
					sql=sql+" and main_component=?";
					sqlList.add("main_component");
				}
			}
			if(medicine.getMedicineEffect()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where medicine_effect=?";
					sqlList.add("medicine_effect");
				}else{
					sql=sql+" and medicine_effect=?";
					sqlList.add("medicine_effect");
				}
			}
			if(medicine.getUseMethod()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where use_method=?";
					sqlList.add("use_method");
				}else{
					sql=sql+" and use_method=?";
					sqlList.add("use_method");
				}
			}
			if(medicine.getMattersNeedAttention()!=null){
				if(sqlList.isEmpty()){
					sql=sql+" where matters_need_attention=?";
					sqlList.add("matters_need_attention");
				}else{
					sql=sql+" and matters_need_attention=?";
					sqlList.add("matters_need_attention");
				}
			}
			if(medicine.getTmedicineClassifyId()!=0){
				if(sqlList.isEmpty()){
					sql=sql+" where t_medicine_classify_id=?";
					sqlList.add("t_medicine_classify_id");
				}else{
					sql=sql+" and t_medicine_classify_id=?";
					sqlList.add("t_medicine_classify_id");
				}
			}
			
		}
		return sql;
	}
	
	public static void setPreparedStatement(PreparedStatement ps,Medicine medicine) throws SQLException{
		for (int i=1;i<=sqlList.size();i++) {
			if("id".equals(sqlList.get(i-1))){
				ps.setInt(i, medicine.getId());
			}
			if("name".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getName());
			}
			if("classification".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getClassification());
			}if("enter_company".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getEnterCompany());
			}if("enter_price".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getEnterPrice());
			}if("shopping_price".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getShoppingPrice());
			}if("validate_number".equals(sqlList.get(i-1))){
				ps.setInt(i, medicine.getValidateNumber());
			}if("sale_price".equals(sqlList.get(i-1))){
				ps.setInt(i, medicine.getSalePrice());
			}if("simple_name".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getSimpleName());
			}if("upper_limit".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getUpperLimit());
			}if("down_limit".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getDownLimit());
			}if("approve_number".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getApproveNumber());
			}if("produce_company".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getProduceCompany());
			}if("main_component".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getMainComponent());	
			}if("medicine_effect".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getMedicineEffect());
			}if("use_method".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getUseMethod());
			}if("matters_need_attention".equals(sqlList.get(i-1))){
				ps.setString(i, medicine.getMattersNeedAttention());
			}if("t_medicine_classify_id".equals(sqlList.get(i-1))){
				ps.setInt(i, medicine.getTmedicineClassifyId());
			}
		}
	}
}
