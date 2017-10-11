package register.service.impl;

import java.text.DateFormat;
import java.util.List;

import register.dao.ClazzDao;
import register.dao.RegisterDao;
import register.dao.impl.ClazzDaoImpl;
import register.dao.impl.RegisterDaoImpl;
import register.domain.Clazz;
import register.domain.Student;
import register.service.ClazzService;
import register.util.StudentArrays;

public class ClazzServiceImpl implements ClazzService{

	public void addClazz(Clazz clazz) {
		ClazzDao clazzDao=new ClazzDaoImpl();
		clazzDao.addClazz(clazz);
	}

	public void deleteClassById(int id) {
		ClazzDao clazzDao=new ClazzDaoImpl();
		clazzDao.deleteClassById(id);
	}

	@Override
	public List<Clazz> queryClazzById(int id) {
		ClazzDao clazzDao=new ClazzDaoImpl();
		return clazzDao.queryClazzById(id);
	}

	public List<Clazz> queryClazzs() {
		ClazzDao clazzDao=new ClazzDaoImpl();
		return clazzDao.queryClazzs();
	}

	public void updateClazz(Clazz clazz) {
		ClazzDao clazzDao=new ClazzDaoImpl();
		clazzDao.updateClazz(clazz);
	}
	
	public StudentArrays findClazzs() {
		String[] clazzOne=new String[]{"id","name",};
		ClazzDao clazzDao=new ClazzDaoImpl();
		List<Clazz> clazzList=clazzDao.queryClazzs();
		String[][] clazzTwo=new String[clazzList.size()][clazzOne.length];
		int i=0;
		for (Clazz clazz : clazzList) {
			clazzTwo[i][0]=String.valueOf(clazz.getId());
			clazzTwo[i][1]=clazz.getName();
			i++;
		}
		StudentArrays sa=new StudentArrays();
		sa.setStudentOne(clazzOne);
		sa.setStudentTwo(clazzTwo);
		return sa;
	}

}
