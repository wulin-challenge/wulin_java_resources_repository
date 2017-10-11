package cn.scxh.ittx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.dao.intf.MedicineDao;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.util.DBConnection;

public class MedicineDaoImpl implements MedicineDao{

	//添加药品
	public void addMedicine(Medicine medicine) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO t_medicine(id,name,classification,standard," +
					"enter_company,enter_price,shopping_price,validate_number,sale_price," +
					"simple_name,upper_limit,down_limit,approve_number,produce_company," +
					"main_component,medicine_effect,use_method,matters_need_attention,t_medicine_classify_id) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, medicine.getId());
			ps.setString(2, medicine.getName());
			ps.setString(3, medicine.getClassification());
			ps.setString(4, medicine.getStandard());
			ps.setString(5, medicine.getEnterCompany());
			ps.setString(6, medicine.getEnterPrice());
			ps.setString(7,medicine.getShoppingPrice());
			ps.setInt(8, medicine.getValidateNumber());
			ps.setInt(9, medicine.getSalePrice());
			ps.setString(10,medicine.getSimpleName());
			ps.setString(11,medicine.getUpperLimit());
			ps.setString(12, medicine.getDownLimit());
			ps.setString(13, medicine.getApproveNumber());
			ps.setString(14, medicine.getProduceCompany());
			ps.setString(15, medicine.getMainComponent());
			ps.setString(16, medicine.getMedicineEffect());
			ps.setString(17, medicine.getUseMethod());
			ps.setString(18, medicine.getMattersNeedAttention());
			ps.setInt(19,medicine.getTmedicineClassifyId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	//删除药品
	public void deleteMedicine(Medicine medicine) throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="DELETE FROM t_medicine where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1,medicine.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	//根据不用条件查询药品
	public List<Medicine> differenceConditionQueryMedicines(Medicine medicine)
			throws SQLException {
		
		List<Medicine> medicineList=new ArrayList<Medicine>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
			connection = DBConnection.getConnection();
			String sql=VariousConditionsQueryMedicine.getSql(medicine);
			ps=connection.prepareStatement(sql);
			VariousConditionsQueryMedicine.setPreparedStatement(ps, medicine);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String classification=rs.getString("classification");
				String standard=rs.getString("standard");
				String enterCompany=rs.getString("enter_company");
				String enterPrice=rs.getString("enter_price");
				String shoppingPrice=rs.getString("shopping_price");
				int validateNumber=rs.getInt("validate_number");
				int salePrice=rs.getInt("sale_price");
				String simpleName=rs.getString("simple_name");
				String upperLimit=rs.getString("upper_limit");
				String downLimit=rs.getString("down_limit");
				String approveNumber=rs.getString("approve_number");
				String produceCompany=rs.getString("produce_company");
				String mainComponent=rs.getString("main_component");
				String medicineEffect=rs.getString("medicine_effect");
				String useMethod=rs.getString("use_method");
				String mattersNeedAttention=rs.getString("matters_need_attention");
				int tmedicineClassifyId=rs.getInt("t_medicine_classify_id");
				Medicine m =new Medicine();
				
				m.setId(id);
				m.setName(name);
				m.setClassification(classification);
				m.setStandard(standard);
				m.setEnterCompany(enterCompany);
				m.setEnterPrice(enterPrice);
				m.setShoppingPrice(shoppingPrice);
				m.setValidateNumber(validateNumber);
				m.setSalePrice(salePrice);
				m.setSimpleName(simpleName);
				m.setUpperLimit(upperLimit);
				m.setDownLimit(downLimit);
				m.setApproveNumber(approveNumber);
				m.setProduceCompany(produceCompany);
				m.setMainComponent(mainComponent);
				m.setMedicineEffect(medicineEffect);
				m.setUseMethod(useMethod);
				m.setMattersNeedAttention(mattersNeedAttention);
				m.setTmedicineClassifyId(tmedicineClassifyId);
				
				medicineList.add(m);
			}
			DBConnection.close(rs,ps, connection);
		return medicineList;
		
	}

	//查询最大数
	public List<Medicine> theLargestNumberOfMedicines(Medicine medicine)
			throws SQLException {
		List<Medicine> medicineList=new ArrayList<Medicine>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        connection=DBConnection.getConnection();
        String sql="SELECT max(id) FROM t_medicine";
        ps=connection.prepareStatement(sql);
        rs=ps.executeQuery();
        if(rs.next()){
        	String id=rs.getString("max(id)");
        	Medicine medicine1=new Medicine();
        	medicine1.setId(Integer.parseInt(id));
        	medicineList.add(medicine1);
        }
        return medicineList;
	}

	//更新药品
	public void updateMedicine(Medicine medicine) throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="UPDATE t_medicine set id=?,name=?,classification=?,standard=?," +
					"enter_company=?,enter_price=?,shopping_price=?,validate_number=?,sale_price=?," +
					"simple_name=?,upper_limit=?,down_limit=?,approve_number=?,produce_company=?," +
					"main_component=?,medicine_effect=?,use_method=?,matters_need_attention=?,t_medicine_classify_id=? where id=?";
			ps=connection.prepareStatement(sql);
			ps.setInt(1, medicine.getId());
			ps.setString(2, medicine.getName());
			ps.setString(3, medicine.getClassification());
			ps.setString(4, medicine.getStandard());
			ps.setString(5, medicine.getEnterCompany());
			ps.setString(6, medicine.getEnterPrice());
			ps.setString(7,medicine.getShoppingPrice());
			ps.setInt(8, medicine.getValidateNumber());
			ps.setInt(9, medicine.getSalePrice());
			ps.setString(10,medicine.getSimpleName());
			ps.setString(11,medicine.getUpperLimit());
			ps.setString(12, medicine.getDownLimit());
			ps.setString(13, medicine.getApproveNumber());
			ps.setString(14, medicine.getProduceCompany());
			ps.setString(15, medicine.getMainComponent());
			ps.setString(16, medicine.getMedicineEffect());
			ps.setString(17, medicine.getUseMethod());
			ps.setString(18, medicine.getMattersNeedAttention());
			ps.setInt(19,medicine.getTmedicineClassifyId());
			ps.setInt(20, medicine.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	
	public List<Medicine> queryMedicineClassification() throws SQLException {
	
        return null;
	}
	

}
