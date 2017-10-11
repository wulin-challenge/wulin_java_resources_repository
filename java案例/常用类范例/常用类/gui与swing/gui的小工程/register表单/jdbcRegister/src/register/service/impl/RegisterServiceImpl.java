package register.service.impl;

import register.dao.RegisterDao;
import register.dao.impl.RegisterDaoImpl;
import register.domain.Student;
import register.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

	public void register(Student student) {
		RegisterDao registerDao=new RegisterDaoImpl();
		registerDao.register(student);
	}

}
