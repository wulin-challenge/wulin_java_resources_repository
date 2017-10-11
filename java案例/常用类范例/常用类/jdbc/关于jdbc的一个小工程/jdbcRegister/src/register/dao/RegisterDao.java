package register.dao;

import java.util.List;

import register.domain.Student;

public interface RegisterDao {
	
	//添加学生
	public void register(Student student);
	
	//查找所有student
	public List<Student> findStudents();
	
	//条件查询
	public List<Student> conditionQuery(Student student);
	
	//根据id进行查找
	public List<Student> findStudentsById(int id);
	
	//根据id进行更新
	public void updateStudentsById(Student student);
	
	//不同条件查询
	public List<Student> differenceConditionQuery(Student student);
	
	//通过Id进行删除
	public void deleteById(int id);

}
