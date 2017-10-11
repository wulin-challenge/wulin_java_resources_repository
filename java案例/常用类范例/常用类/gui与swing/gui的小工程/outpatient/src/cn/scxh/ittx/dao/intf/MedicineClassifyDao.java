package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.MedicineClassify;

public interface MedicineClassifyDao {

	//增加药物分类
	public void addMedicineClassify(MedicineClassify classify) throws SQLException;
	//删除药物分类
	public void deleteMedicineClassify(MedicineClassify classify) throws SQLException;
	//更新药物分类
	public void updateMedicineClassify(MedicineClassify classify) throws SQLException;
	//不同条件查询
	public List<MedicineClassify> differenceConditionQueryMedicineClassify(MedicineClassify classify) throws SQLException;
	//根据id查询最大值
	public List<MedicineClassify> theLargestNumberOfMedicineClassify(MedicineClassify classify) throws SQLException;
	//得到父亲
	public List<MedicineClassify> getParent(MedicineClassify classify) throws SQLException;
	//得到孩子
	public List<MedicineClassify> getChildren(MedicineClassify classify) throws SQLException; 
	//得到树根
	public List<MedicineClassify> getMedicineRoot(MedicineClassify classify) throws SQLException; 
	//通过父亲的id与孩子的名字的得到孩子的id
	public List<MedicineClassify> getChildrenBynameAndId(MedicineClassify classify) throws SQLException ;
}
