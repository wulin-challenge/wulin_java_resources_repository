package register.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import register.domain.DifferenceObject;
import register.service.ClazzService;
import register.service.impl.ClazzServiceImpl;
import register.util.DifferenceComponent;
import register.util.StudentModel;

public class ClazzUI extends JFrame{
	DifferenceObject object;
	public ClazzUI(){}
	public ClazzUI(DifferenceObject object){
		this.object=object;
	}

	public void clazzWindow(){
		this.setLayout(null);
		this.setBounds(800, 100, 350,400);
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ClazzService clazzService=new ClazzServiceImpl();
		StudentModel studentModel=new StudentModel(1);
		studentModel.setSa(clazzService.findClazzs());
		JTable jTable=new JTable(studentModel);
		//---------------------------------
		differenceComponentClazz(this,studentModel,jTable);
		
		//---------------------------------
		JScrollPane jScrollPane=new JScrollPane(jTable);
		jScrollPane.setBounds(10, 100, 300,200);
		this.add(jScrollPane);
		this.setVisible(true);
	}
	
	//班级刷新按钮
	public void differenceComponentClazz(JFrame jFrame,StudentModel studentModel,JTable jTable){
		DifferenceObject object=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object);
		object.setJframe(jFrame);
		object.setStudentModel(studentModel);
		object.setJtable(jTable);
		dc.jButtonComponent(jFrame, "刷新", 0, 20, 20, 60, 20);
		dc.jButtonComponent(jFrame, "更新", -2, 80, 20, 60, 20);
		dc.jButtonComponent(jFrame, "添加", -2, 140, 20, 60, 20);
		dc.jButtonComponent(jFrame, "删除", -2, 200, 20, 60, 20);
	}
}









