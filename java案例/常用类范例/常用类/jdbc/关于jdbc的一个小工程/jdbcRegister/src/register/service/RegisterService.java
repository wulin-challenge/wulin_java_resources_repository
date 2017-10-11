package register.service;

import java.util.List;
import register.domain.Student;
import register.util.StudentArrays;

public interface RegisterService {
	
	//添加学生
	public void register(Student student);
	//查找所有学生
	public StudentArrays findStudents();
	//条件查找
	public List<Student> conditionQuery(Student student);
	
	//根据id查找学生
	public List<Student> findStudentsById(int id);
	
	//根据id进行更新
	public void updateStudentsById(Student student);
	
	//不同条件查询
	public StudentArrays differenceConditionQuery(Student student);
	
	//通过Id进行删除
	public void deleteById(int id);
}
