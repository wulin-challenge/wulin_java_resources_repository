package cn.scxh.service.impl;

import cn.scxh.dao.impl.StudentDaoImpl;
import cn.scxh.dao.intf.StudentDao;
import cn.scxh.model.Student;
import cn.scxh.service.intf.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public void register(Student student) {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.addStudent(student);
		
	}

}
