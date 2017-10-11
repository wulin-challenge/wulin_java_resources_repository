package cn.scxh.ittx.service.intf;

import java.util.List;

import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface PatientService {
	//添加病人
	public void addPatient(Patient patient)throws AddObjectException;
	//删除病人
	public void deletePatient(Patient patient)throws DeleteObjectException;
	//更新病人
	public void updatePatient(Patient patient)throws UpdateObjectException;
	//不同条件查询病人
	public List<Patient> differenceConditionQueryPatients(Patient patient)  throws QueryObjectException;

	public SharedArrays queryPatients(Patient patient)throws QueryObjectException;
	//得到最大的编号
	public List<Patient> theLargestNumberOfPatients()throws QueryObjectException;
}
