package cn.scxh.ittx.service.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;

import cn.scxh.ittx.dao.impl.PatientDaoImpl;
import cn.scxh.ittx.dao.intf.PatientDao;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.intf.PatientService;

public class PatientServiceImpl implements PatientService{

	public List<Patient> differenceConditionQueryPatients(Patient patient) throws QueryObjectException{
		PatientDao ps=new PatientDaoImpl();
		try {
			return ps.differenceConditionQueryPatients(patient);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		
	}

	public void addPatient(Patient patient) throws AddObjectException {
		PatientDao ps=new PatientDaoImpl();
		try {
			ps.addPatient(patient);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddObjectException();
		}
	}

	public void deletePatient(Patient patient) throws DeleteObjectException {
		PatientDao ps=new PatientDaoImpl();
		try {
			ps.deletePatient(patient);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteObjectException();
		}
		
	}

	public void updatePatient(Patient patient) throws UpdateObjectException {
		PatientDao ps=new PatientDaoImpl();
		try {
			ps.updatePatient(patient);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateObjectException();
		}
	}

	public SharedArrays queryPatients(Patient patient)
			throws QueryObjectException {
		SharedArrays patientArrarys=new SharedArrays();
		PatientDao pd=new PatientDaoImpl();
		String[] patientOneDimensional=new String[]{"id","name","sex","age","married","job","weight","blood",
				  "phone_number","register_time","address","allergy","remark"};
		String[][] patientTwoDimensional;
		
		try {
			List<Patient> patientList=pd.differenceConditionQueryPatients(patient);
			patientTwoDimensional=new String[patientList.size()][patientOneDimensional.length];
			int i=0;
			for(Patient p:patientList){
				patientTwoDimensional[i][0]=p.getId();
				patientTwoDimensional[i][1]=p.getName();
				patientTwoDimensional[i][2]=p.getSex();
				patientTwoDimensional[i][3]=String.valueOf(p.getAge());
				patientTwoDimensional[i][4]=p.getMarried();
				patientTwoDimensional[i][5]=p.getJob();
				patientTwoDimensional[i][6]=String.valueOf(p.getWeight());
				patientTwoDimensional[i][7]=p.getBlood();
				patientTwoDimensional[i][8]=String.valueOf(p.getPhoneNumber());
				patientTwoDimensional[i][9]=DateFormat.getDateInstance().format(p.getRegisterTime());
				patientTwoDimensional[i][10]=p.getAddress();
				patientTwoDimensional[i][11]=p.getAllergy();
				patientTwoDimensional[i][12]=p.getRemark();
				i++;
				
			}
			patientArrarys.setSharedOneArray(patientOneDimensional);
			patientArrarys.setSharedTwoArray(patientTwoDimensional);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		return patientArrarys;
	}

	public List<Patient> theLargestNumberOfPatients() throws QueryObjectException
			{
		PatientDao ps=new PatientDaoImpl();
		try {
			return ps.theLargestNumberOfPatients();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		
	}

}
