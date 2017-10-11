package cn.scxh.ittx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.scxh.ittx.dao.intf.PatientDao;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.util.DBConnection;

public class PatientDaoImpl implements PatientDao {

	public List<Patient> differenceConditionQueryPatients(Patient patient) throws SQLException{
		List<Patient> patientList=new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
			connection = DBConnection.getConnection();
			String sql=VariousConditionsQueryPatient.getSql(patient);
			ps=connection.prepareStatement(sql);
			VariousConditionsQueryPatient.setPreparedStatement(ps, patient);
			rs=ps.executeQuery();
			while(rs.next()){
				String id=rs.getString("id");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				int age=rs.getInt("age");
				String married=rs.getString("married");
				String job=rs.getString("job");
				int weight=rs.getInt("weight");
				String blood=rs.getString("blood");
				String phoneNumber=rs.getString("phone_number");
				java.util.Date registerTime=rs.getDate("register_time");
				String address=rs.getString("address");
				String allergy=rs.getString("allergy");
				String remark=rs.getString("remark");
				Patient p =new Patient();
				p.setId(id);
				p.setName(name);
				p.setAge(age);
				p.setSex(sex);
				p.setMarried(married);
				p.setJob(job);
				p.setWeight(weight);
				p.setBlood(blood);
				p.setPhoneNumber(phoneNumber);
				p.setRegisterTime(registerTime);
				p.setAddress(address);
				p.setAllergy(allergy);
				p.setRemark(remark);
				
				patientList.add(p);
			}
			DBConnection.close(rs,ps, connection);
		return patientList;
	}

	public void addPatient(Patient patient) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO t_patient(id,name,sex,age,married,job,weight," +
					"blood,phone_number,register_time,address,allergy,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, patient.getId());
			ps.setString(2, patient.getName());
			ps.setString(3, patient.getSex());
			ps.setInt(4, patient.getAge());
			ps.setString(5, patient.getMarried());
			ps.setString(6, patient.getJob());
			ps.setInt(7,patient.getWeight());
			ps.setString(8, patient.getBlood());
			ps.setString(9, patient.getPhoneNumber());
			ps.setDate(10,new java.sql.Date(patient.getRegisterTime().getTime()));
			ps.setString(11,patient.getAddress());
			ps.setString(12, patient.getAllergy());
			ps.setString(13, patient.getRemark());
			ps.execute();
			DBConnection.close(ps, connection);
		
	}

	public void deletePatient(Patient patient) throws SQLException {

		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="DELETE FROM t_patient where id=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1,patient.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	public void updatePatient(Patient patient)throws SQLException {

		Connection connection=null;
		PreparedStatement ps=null;
			connection=DBConnection.getConnection();
			String sql="UPDATE t_patient set id=?,name=?,sex=?,age=?,married=?,job=?,weight=?," +
					"blood=?,phone_number=?,register_time=?,address=?,allergy=?,remark=? where id=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, patient.getId());
			ps.setString(2, patient.getName());
			ps.setString(3, patient.getSex());
			ps.setInt(4, patient.getAge());
			ps.setString(5, patient.getMarried());
			ps.setString(6, patient.getJob());
			ps.setInt(7,patient.getWeight());
			ps.setString(8, patient.getBlood());
			ps.setString(9, patient.getPhoneNumber());
			ps.setDate(10,new java.sql.Date(patient.getRegisterTime().getTime()));
			ps.setString(11,patient.getAddress());
			ps.setString(12, patient.getAllergy());
			ps.setString(13, patient.getRemark());
			ps.setString(14, patient.getId());
			ps.execute();
			DBConnection.close(ps, connection);
	}

	@Override
	public List<Patient> theLargestNumberOfPatients() throws SQLException {
		List<Patient> patientList=new ArrayList<Patient>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        connection=DBConnection.getConnection();
        String sql="SELECT max(id) FROM t_patient";
        ps=connection.prepareStatement(sql);
        rs=ps.executeQuery();
        if(rs.next()){
        	String id=rs.getString("max(id)");
        	Patient patient=new Patient();
        	patient.setId(id);
        	patientList.add(patient);
        }
			
		return patientList;
	}

}
