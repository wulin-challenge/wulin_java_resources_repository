package cn.wulin.dao;

import java.util.List;

import cn.wulin.domain.Person;

public interface PersonDao {
	public List<Person> findAllPerson();
}
