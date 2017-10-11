package register.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import register.dao.RegisterDao;
import register.dao.impl.RegisterDaoImpl;
import register.domain.Student;
import register.service.RegisterService;
import register.util.StudentArrays;

public class RegisterServiceImpl implements RegisterService{

	public void register(Student student) {
		RegisterDao registerDao=new RegisterDaoImpl();
		registerDao.register(student);
	}

	public StudentArrays findStudents() {
		RegisterDao registerDao=new RegisterDaoImpl();
		String[] studentOne=new String[]{"id","name","password","gender","identityNumber","registerDate","clazzName","sid"};
		List<Student> studentList=registerDao.findStudents();
		String[][] studentTwo=new String[studentList.size()][studentOne.length];
		int i=0;
		for (Student student : studentList) {
			studentTwo[i][0]=student.getId()+"";
			studentTwo[i][1]=student.getName();
			studentTwo[i][2]=student.getPassword();
			studentTwo[i][3]=student.getGender();
			studentTwo[i][4]=student.getIdentityNumber();
			studentTwo[i][5]=DateFormat.getDateInstance().format(student.getRegisterDate());
			studentTwo[i][6]=student.getClazzname();
			studentTwo[i][7]=student.getSid()+"";
			i++;
		}
		StudentArrays sa=new StudentArrays();
		sa.setStudentOne(studentOne);
		sa.setStudentTwo(studentTwo);
		return sa;
	}

	public List<Student> conditionQuery(Student student) {
		RegisterDao rd=new RegisterDaoImpl();
		return rd.conditionQuery(student);
	}

	public List<Student> findStudentsById(int id) {
		RegisterDao rd=new RegisterDaoImpl();
		return rd.findStudentsById(id);
	}

	public void updateStudentsById(Student student) {

		RegisterDao rd=new RegisterDaoImpl();
		rd.updateStudentsById(student);
	}

	
	public StudentArrays differenceConditionQuery(Student student1) {
		RegisterDao registerDao=new RegisterDaoImpl();
		String[] studentOne=new String[]{"id","name","password","gender","identityNumber","registerDate","clazzName","sid"};
		List<Student> studentList=registerDao.differenceConditionQuery(student1);
		String[][] studentTwo=new String[studentList.size()][studentOne.length];
		int i=0;
		for (Student student : studentList) {
			studentTwo[i][0]=student.getId()+"";
			studentTwo[i][1]=student.getName();
			studentTwo[i][2]=student.getPassword();
			studentTwo[i][3]=student.getGender();
			studentTwo[i][4]=student.getIdentityNumber();
			studentTwo[i][5]=DateFormat.getDateInstance().format(student.getRegisterDate());
			studentTwo[i][6]=student.getClazzname();
			studentTwo[i][7]=student.getSid()+"";
			i++;
		}
		StudentArrays sa=new StudentArrays();
		sa.setStudentOne(studentOne);
		sa.setStudentTwo(studentTwo);
		return sa;
	}
	
	public void deleteById(int id) {
		RegisterDao registerDao=new RegisterDaoImpl();
		registerDao.deleteById(id);
	}
	
	
	public static void main(String[] args) throws Exception {
		RegisterDao rd=new RegisterDaoImpl();
		Student student=new Student();
		//student.setId(1);
		student.setName("dfs");
		student.setIdentityNumber("oo");
		//student.setGender("Ů");
		//DateFormat dateFormat=DateFormat.getDateInstance();
		//Date date =dateFormat.parse("1234-12-21");
		//student.setRegisterDate(date);
		List<Student> studentList=rd.differenceConditionQuery(student);
		if(studentList!=null){
			
			for (Student student2 : studentList) {
				System.out.println(student2.getId());
				System.out.println(student2.getName());
				System.out.println(student2.getPassword());
				System.out.println(student2.getIdentityNumber());
			}
		}
		
	}

	

}
