package package1.package01;

import junit.framework.TestCase;

public class StudentTest extends TestCase {

	public static void main(String[] args) {
		Student student=new Student();
		student.setId(2);
		student.setName("haha");
		Student student1=new Student();
		student1.setId(2);
		student1.setName("haha");
		Student student2=student;
		Student student3=student;
		student3.setId(1);
		student3.setName("hh");
		System.out.println(student.equals(student2));
		System.out.println(student.equals(student1));
		System.out.println(student.equals(student));
		System.out.println(student.equals(student3)+"::"+student.getName()+"::"+student3.getName());
		System.out.println(new String("haha").equals(new String("haha")));
		System.out.println(new StringBuffer("haha").equals(new StringBuffer("haha")));
	}
}
