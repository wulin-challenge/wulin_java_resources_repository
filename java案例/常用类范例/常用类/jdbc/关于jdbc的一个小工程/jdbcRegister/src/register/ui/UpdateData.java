package register.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import register.domain.DifferenceObject;
import register.util.DifferenceComponent;
import register.util.StudentModel;

public class UpdateData extends JFrame{
	
	//创建一个更新窗口
	public void updateWindow(JTable jTable,StudentModel studentModel,int id){
		DifferenceObject object=new DifferenceObject();
		object.setJframe(this);
		DifferenceComponent dc=new DifferenceComponent(object);
		this.setLayout(null);
		this.setTitle("更新窗口");
		
		object.setJtable(jTable);
		object.setStudentModel(studentModel);
		
		//id
		dc.jLabelComponent(this, "编号:", 20, 30, 40, 20);
		dc.jTextFieldComponent(this,"编号:", 60, 30, 100, 20);
		
		//name
		dc.jLabelComponent(this, "名字:", 20, 60, 40, 20);
		dc.jTextFieldComponent(this,"名字:", 60, 60, 100, 20);
		
		//gender
		dc.jLabelComponent(this, "性别:", 20, 90, 40, 20);
		dc.jTextFieldComponent(this,"性别:", 60, 90, 100, 20);
		
		//password
		dc.jLabelComponent(this, "密码:", 20, 120, 40, 20);
		dc.jTextFieldComponent(this,"密码:", 60, 120, 100, 20);
		
		//身份证号
		dc.jLabelComponent(this, "身份证号:", 0, 150, 60, 20);
		dc.jTextFieldComponent(this,"身份证号:", 60, 150, 100, 20);
		
		//日期
		dc.jLabelComponent(this, "日期:", 20, 180, 40, 20);
		dc.jTextFieldComponent(this, "日期:", 60, 180, 100, 20);
		
		//班级名
		dc.jLabelComponent(this, "所属班级:", 0, 210, 60, 20);
		dc.jTextFieldComponent(this, "所属班级:", 60, 210, 100, 20);
		
		//班级编号
		dc.jLabelComponent(this, "班级编号:", 0, 240, 60, 20);
		dc.jTextFieldComponent(this, "班级编号:", 60, 240, 100, 20);
		
		dc.jButtonComponent(this, "更新", id,20, 300, 60, 20);
		
		this.setBounds(800,100,300,400);
		this.setVisible(true);
	}
}
