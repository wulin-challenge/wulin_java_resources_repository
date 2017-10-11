package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.Medicine;

public interface MedicineDao {
	//增加药品
	public void addMedicine(Medicine medicine) throws SQLException;
	//删除药品
	public void deleteMedicine(Medicine medicine) throws SQLException;
	//更新药品
	public void updateMedicine(Medicine medicine) throws SQLException;
	//不同条件查询药品
	public List<Medicine> differenceConditionQueryMedicines(Medicine medicine) throws SQLException;
	//查询最大值
	public List<Medicine> theLargestNumberOfMedicines(Medicine medicine) throws SQLException;
	//查询药物类别
	public List<Medicine> queryMedicineClassification()throws SQLException;
}
