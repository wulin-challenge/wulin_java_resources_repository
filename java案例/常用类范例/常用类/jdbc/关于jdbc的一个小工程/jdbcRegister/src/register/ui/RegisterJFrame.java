package register.ui;

import javax.swing.JFrame;

import register.domain.DifferenceObject;
import register.util.DifferenceComponent;
import register.util.GetValueOfUI;

public class RegisterJFrame extends JFrame{
	private DifferenceObject object;
	public RegisterJFrame(){
	}
	public RegisterJFrame(DifferenceObject object){
		this.object = object;
	}
	public void registerJFarme(){
		DifferenceComponent dc=new DifferenceComponent(object);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(500, 100, 500, 500);

		// 学号的字段标签
		dc.jLabelComponent(this, "学号:", 100, 80, 35, 20);
		dc.jTextFieldComponent(this, "学号:", 140, 80, 80, 20);

		// 姓名的字段标签
		dc.jLabelComponent(this, "姓名:", 100, 120, 35, 20);
		dc.jTextFieldComponent(this, "姓名:", 140, 120, 80, 20);

		// 密码的字段标签
		dc.jLabelComponent(this, "密码:",100, 160, 35, 20);
		dc.jPasswordFieldComponent(this, "密码:", 140, 160, 80, 20);

		// 性别的字段标签
		dc.jLabelComponent(this, "性别:",100, 200, 35, 20);

		// 女的字段标签
		dc.jLabelComponent(this, "女",140, 200, 20, 20);
		dc.jRadioButtonComponent(this,"女",true, 155, 200, 20, 20);
		// 男的字段标签
		dc.jLabelComponent(this,"男",180, 200, 20, 20);
		dc.jRadioButtonComponent(this, "男",false, 195, 200, 20, 20);
		
		// 身份证号的字段标签
		dc.jLabelComponent(this, "注册日期:", 80, 240, 70, 20);
		dc.jTextFieldComponent(this, "注册日期:", 140, 240, 80, 20);

		// 注册日期的字段标签
		dc.jLabelComponent(this, "身份证号:", 80, 280, 70, 20);
		dc.jTextFieldComponent(this, "身份证号:", 140, 280, 80, 20);
		
		//设置班级
		dc.jLabelComponent(this, "所属班级:",80, 320, 70, 20);
		GetValueOfUI value=new GetValueOfUI();
		String[] name=value.getClazzName();
		dc.jComboBoxConponent(this, name, 140, 320, 80, 20);
		//dc.jTextFieldComponent(this, "所属班级:", 140, 320, 80, 20);
		
		// 提交按钮
		dc.jButtonComponent(this, "提交", 0,300, 380, 60, 20);
		this.setVisible(true);
	}
}
