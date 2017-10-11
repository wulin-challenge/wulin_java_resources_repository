package cn.scxh.ittx.service.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.MedicineClassify;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface MedicineClassifyService {

	//增加药物分类
	public void addMedicineClassify(MedicineClassify classify) throws AddObjectException;
	//删除药物分类
	public void deleteMedicineClassify(MedicineClassify classify) throws DeleteObjectException;
	//更新药物分类
	public void updateMedicineClassify(MedicineClassify classify) throws UpdateObjectException;
	//不同条件查询
	public List<MedicineClassify> differenceConditionQueryMedicineClassify(MedicineClassify classify) throws QueryObjectException;
	//根据id查询最大值
	public List<MedicineClassify> theLargestNumberOfMedicineClassify(MedicineClassify classify) throws QueryObjectException;
	//得到父亲
	public List<MedicineClassify> getParent(MedicineClassify classify) throws QueryObjectException;
	//得到孩子
	public List<MedicineClassify> getChildren(MedicineClassify classify) throws QueryObjectException; 
	//得到树根
	public List<MedicineClassify> getMedicineRoot(MedicineClassify classify) throws QueryObjectException; 
	//通过父亲的id与孩子的名字的得到孩子的id
	public List<MedicineClassify> getChildrenBynameAndId(MedicineClassify classify) throws QueryObjectException ;
}
