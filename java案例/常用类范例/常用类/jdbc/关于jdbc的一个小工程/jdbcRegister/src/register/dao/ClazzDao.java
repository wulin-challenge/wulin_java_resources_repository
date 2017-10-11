package register.dao;

import java.util.List;

import register.domain.Clazz;

public interface ClazzDao {
	
	//增加班级
	public void addClazz(Clazz clazz);
	
	//更新班级
	public void updateClazz(Clazz clazz);
	
	//根据id进行查询
	public List<Clazz> queryClazzById(int id);
	
	//查询所有班级
	public List<Clazz> queryClazzs();
	
	//根据id进行删除班级
	public void deleteClassById(int id);
	
	

}
