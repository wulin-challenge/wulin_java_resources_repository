package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.Patient;

public interface PatientDao {
	//添加病人
	public void addPatient(Patient patient) throws SQLException;
	//删除病人
	public void deletePatient(Patient patient) throws SQLException;
	//更新病人
	public void updatePatient(Patient patient) throws SQLException;
	//不同条件查询病人
	public List<Patient> differenceConditionQueryPatients(Patient patient) throws SQLException;
	//得到最大的编号
	public List<Patient> theLargestNumberOfPatients()throws SQLException;
}
