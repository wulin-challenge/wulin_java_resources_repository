package register.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import register.domain.Clazz;
import register.domain.DifferenceObject;
import register.domain.Student;
import register.service.ClazzService;
import register.service.RegisterService;
import register.service.impl.ClazzServiceImpl;
import register.service.impl.RegisterServiceImpl;

public class SetValueOfUI {
	private DifferenceObject object;
	public SetValueOfUI(){}
	public SetValueOfUI(DifferenceObject object){
		this.object=object;
	}

	//设置更新值
	public void setUpdateValue(){
		Student student=new Student();
		JTextField difference=object.getJtextFieldMap().get("编号:");
		student.setId(Integer.parseInt(difference.getText()));
		difference=object.getJtextFieldMap().get("名字:");
		student.setName(difference.getText());
		difference=object.getJtextFieldMap().get("性别:");
		student.setGender(difference.getText());
		difference=object.getJtextFieldMap().get("密码:");
		student.setPassword(difference.getText());
		difference=object.getJtextFieldMap().get("身份证号:");
		student.setIdentityNumber(difference.getText());
		difference=object.getJtextFieldMap().get("日期:");
		try {
			DateFormat dateFormat=DateFormat.getDateInstance();
			Date date=dateFormat.parse(difference.getText());
			student.setRegisterDate(date);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		student.setClazzname(object.getJtextFieldMap().get("所属班级:").getText());
		student.setSid(Integer.parseInt(object.getJtextFieldMap().get("班级编号:").getText()));
		RegisterService rs=new RegisterServiceImpl();
		rs.updateStudentsById(student);
		object.getStudentModel().setSa(rs.findStudents());
		object.getJtable().updateUI();
	}
	public void setClazzValue(int id) {
		ClazzService cs=new ClazzServiceImpl();
		List<Clazz> clazzList=cs.queryClazzById(id);
		Clazz clazz=clazzList.get(0);
		object.getJtextFieldMap().get("编号:").setText(String.valueOf(clazz.getId()));
		object.getJtextFieldMap().get("名字:").setText(clazz.getName());
		
	}
}
