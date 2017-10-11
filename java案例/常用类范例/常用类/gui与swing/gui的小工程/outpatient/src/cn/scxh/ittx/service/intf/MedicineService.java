package cn.scxh.ittx.service.intf;

import java.util.List;

import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface MedicineService {

	//增加药品
	public void addMedicine(Medicine medicine) throws AddObjectException;
	//删除药品
	public void deleteMedicine(Medicine medicine) throws DeleteObjectException;
	//更新药品
	public void updateMedicine(Medicine medicine) throws UpdateObjectException;
	//不同条件查询药品
	public List<Medicine> differenceConditionQueryMedicines(Medicine medicine) throws QueryObjectException;
	//查询最大值
	public List<Medicine> theLargestNumberOfMedicines(Medicine medicine) throws QueryObjectException;
	//不同条件返回一个数组
	public SharedArrays queryMedicines(Medicine medicine)throws QueryObjectException;
	

}
