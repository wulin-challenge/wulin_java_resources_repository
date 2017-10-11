package register.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import register.domain.DifferenceObject;
import register.service.impl.RegisterServiceImpl;
import register.util.DifferenceComponent;
import register.util.StudentModel;

public class SecondFrame {
	// 创建一个窗体
	public Frame createFrame() {
		Frame frame = new Frame();
		frame.setLayout(null);
		frame.setLocation(300,200);
		frame.setSize(500, 500);
		return frame;
	}
	
	//创建一个列表窗口
	public void createListWindow(){
		Frame frame=createFrame();
		JButton jButton=new JButton("刷新");
		jButton.setBounds(60, 40, 60, 20);
		final StudentModel studentModel=StudentModel.getInstance();
		studentModel.setSa(new RegisterServiceImpl().findStudents());
		final JTable jTable=new JTable(studentModel);
		//-------------------------------------------------------
		differenceQuery(frame,jTable,studentModel);
		getAButton( frame ,jTable,studentModel);
		deleteButton(frame ,jTable,studentModel);
		registerButton(frame,jTable,studentModel);
		findClazzButton(frame,jTable,studentModel);
		
		//============================================================
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				studentModel.setSa(new RegisterServiceImpl().findStudents());
			jTable.updateUI();
			}
		});
		JScrollPane jscrollPane=new JScrollPane(jTable);
		jscrollPane.setBounds(25,150,450,200);
		frame.add(jscrollPane);
		frame.add(jButton);
		frame.setVisible(true);
	}
	//查看班级按钮
	public void findClazzButton(Frame frame,JTable jTable,StudentModel studentModel){
		DifferenceObject object=new DifferenceObject();
		object.setJtable(jTable);
		object.setStudentModel(studentModel);
		DifferenceComponent dc=new DifferenceComponent(object);
		dc.jButtonComponent(frame, "班级", 0, 300, 40, 60, 20);
	}
	
	
	//新建一个删除按钮
	public void deleteButton(Frame frame,JTable jTable,StudentModel studentModel){
		DifferenceObject object=new DifferenceObject();
		object.setJtable(jTable);
		object.setStudentModel(studentModel);
		DifferenceComponent dc=new DifferenceComponent(object);
		dc.jButtonComponent(frame, "删除", 0, 180, 40, 60, 20);
	}
	//注册按钮
	public void registerButton(Frame frame,final JTable jTable,final StudentModel studentModel){
		final DifferenceObject object=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object);
		object.setJtable(jTable);
		object.setStudentModel(studentModel);
		dc.jButtonComponent(frame, "注册", 0, 240, 40, 60, 20);
	}
	
	//多条件查询呢图形
	public void differenceQuery(Frame frame,final JTable jTable,final StudentModel studentModel){
		final DifferenceObject object=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object);
		object.setJtable(jTable);
		object.setStudentModel(studentModel);
		//身份证标签
		dc.jLabelComponent(frame, "身份证号:", 20, 80, 80, 20);
		dc.jTextFieldComponent(frame,"身份证号:", 80, 80, 100, 20);
		//姓名标签
		dc.jLabelComponent(frame, "姓名:", 190, 80, 80, 20);
		dc.jTextFieldComponent(frame,"姓名:",225, 80, 100, 20);
		//密码标签
		dc.jLabelComponent(frame, "密码:", 330, 80, 80, 20);
		dc.jPasswordFieldComponent(frame,"密码:",365, 80, 100, 20);
		
		dc.jButtonComponent(frame, "搜索", 0, 365, 120, 60, 20);
	}
	
	//更新
	public void getAButton(Frame frame,final JTable jTable,final StudentModel studentModel){
		JButton jButton=new JButton("更新");
		jButton.setBounds(120, 40, 60, 20);
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int j=jTable.getSelectedRowCount();
				int i=jTable.getSelectedRow();
				if(i==-1||j!=1){
					JOptionPane.showMessageDialog(null, "只能选择一行",null,JOptionPane.WARNING_MESSAGE);
				}else{
					int id=Integer.parseInt((String)jTable.getValueAt(i, 0));
					new UpdateData(). updateWindow(jTable,studentModel,id);
				}
			}
		});
		frame.add(jButton);
	}
}
