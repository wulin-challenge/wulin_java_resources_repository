package cn.wulin.service.impl;

import java.util.List;

import cn.wulin.dao.PersonDao;
import cn.wulin.dao.impl.PersonDaoImpl;
import cn.wulin.domain.Person;
import cn.wulin.service.PersonService;

public class PersonServiceImpl implements PersonService{

	public List<Person> findAllPerson() {
		PersonDao personDao = new PersonDaoImpl();
		return personDao.findAllPerson();
	}

}
