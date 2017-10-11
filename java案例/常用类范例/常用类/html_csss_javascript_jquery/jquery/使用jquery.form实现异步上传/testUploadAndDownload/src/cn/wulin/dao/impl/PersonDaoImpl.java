package cn.wulin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.wulin.dao.PersonDao;
import cn.wulin.domain.Person;
import cn.wulin.util.DBUtil;

public class PersonDaoImpl implements PersonDao{

	public List<Person> findAllPerson() {
		List<Person> personList = new ArrayList<Person>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "select * from t_person";
			connection = DBUtil.getContection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Long personId = rs.getLong("personId");
				String username = rs.getString("username");
				String denger = rs.getString("denger");
				String record = rs.getString("record");
				Integer age = rs.getInt("age");
				Integer weight = rs.getInt("weight");
				Integer height = rs.getInt("height");
				Person person = new Person();
				person.setAge(age);
				person.setDenger(denger);
				person.setHeight(height);
				person.setPersonId(personId);
				person.setRecord(record);
				person.setUsername(username);
				person.setWeight(weight);
				personList.add(person);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, connection);
		}
		return personList;
	}

}
