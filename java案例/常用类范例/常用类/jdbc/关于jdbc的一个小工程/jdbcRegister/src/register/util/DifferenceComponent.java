package register.util;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import register.domain.DifferenceObject;

public class DifferenceComponent {
	private DifferenceObject object;
	public DifferenceComponent(){}
	public DifferenceComponent(DifferenceObject object){
		this.object=object;
	}
	
	//jRadioButton
	public JRadioButton jRadioButtonComponent(JFrame jFrame,String name,boolean isSelected ,int x,int y,int width,int height){
		JRadioButton jRadioButton=new JRadioButton(name,isSelected);
		jRadioButton.setText(name);
		object.getButtonGroup().add(jRadioButton);
		object.getJradioButtonMap().put(name, jRadioButton);
		jRadioButton.setBounds(x, y, width, height);
		jFrame.add(jRadioButton);
		return jRadioButton;
	}
	
	//jRadioButton重构
	public JRadioButton jRadioButtonComponent(Frame frame,String name ,boolean isSelected,int x,int y,int width,int height){
		JRadioButton jRadioButton=new JRadioButton(name,isSelected);
		jRadioButton.setText(name);
		object.getButtonGroup().add(jRadioButton);
		object.getJradioButtonMap().put(name, jRadioButton);
		jRadioButton.setBounds(x, y, width, height);
		frame.add(jRadioButton);
		return jRadioButton;
	}
	
	//JLabel
	public JLabel jLabelComponent(JFrame jFrame,String name ,int x,int y,int width,int height){
		JLabel jLable=new JLabel(name);
		jLable.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLable);
		jFrame.add(jLable);
		return jLable;
	}
	
	//JLabel重构
	public JLabel jLabelComponent(Frame Frame,String name ,int x,int y,int width,int height){
		JLabel jLable=new JLabel(name);
		jLable.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLable);
		Frame.add(jLable);
		return jLable;
	}
	
	//JTextField
	public JTextField jTextFieldComponent(JFrame jFrame,String name ,int x,int y,int width,int height){
		JTextField jTextField=new JTextField();
		object.getJtextFieldMap().put(name, jTextField);
		jTextField.setBounds(x, y, width, height);
		jFrame.add(jTextField);
		return jTextField;
	}
	
	//JPasswordField
	public JPasswordField jPasswordFieldComponent(JFrame jFrame,String name ,int x,int y,int width,int height){
		JPasswordField jPasswordField=new JPasswordField();
		object.setJpasswordField(jPasswordField);
		jPasswordField.setBounds(x, y, width, height);
		jFrame.add(jPasswordField);
		return jPasswordField;
	}
	
	
	//JCombobox
	public JComboBox jComboBoxConponent(JFrame jFrame,String[] name ,int x,int y,int width,int height){
		JComboBox jComboBoxCField=new JComboBox(name);
		object.setJcomboBox(jComboBoxCField);
		jComboBoxCField.setBounds(x, y, width, height);
		jFrame.add(jComboBoxCField);
		return jComboBoxCField;
	}
	
	
	
	
	
	
	//JPasswordField重构
	public JPasswordField jPasswordFieldComponent(Frame frame,String name ,int x,int y,int width,int height){
		JPasswordField jPasswordField=new JPasswordField();
		object.setJpasswordField(jPasswordField);
		jPasswordField.setBounds(x, y, width, height);
		frame.add(jPasswordField);
		return jPasswordField;
	}
	
	
	//JTextField重构
	public JTextField jTextFieldComponent(Frame Frame,String name ,int x,int y,int width,int height){
		JTextField jTextField=new JTextField();
		object.getJtextFieldMap().put(name, jTextField);
		jTextField.setBounds(x, y, width, height);
		Frame.add(jTextField);
		return jTextField;
	}
	
	//JButton
	public JButton jButtonComponent(JFrame jFrame,String name,final int id,int x,int y,int width,int height){
		DifferenceListener dl=new DifferenceListener(object);
		JButton jButton=new JButton(name);
		jButton.setBounds(x, y, width, height);
		if("更新".equals(name )&&id>0){
			GetValueOfUI value=new GetValueOfUI(object);
			value.getUpdateValue(id);
			dl.sharedListener(jFrame,jButton,name,id);
		}
		if("提交".equals(name )){ 
			dl.sharedListener(jFrame,jButton,name,0);
		}if("刷新".equals(name )){ 
			dl.sharedListener(jFrame,jButton,name,0);
		}if("更新".equals(name )&& id ==-2){
			dl.sharedListener(jFrame,jButton,name,-2);
		}if("更新".equals(name )&& id ==-3){
			dl.sharedListener(jFrame,jButton,name,-3);
		}if("添加".equals(name )&& id ==-2){
			dl.sharedListener(jFrame,jButton,name,-2);
		}if("添加".equals(name )&& id ==-3){
			dl.sharedListener(jFrame,jButton,name,-3);
		}if("删除".equals(name )&& id ==-2){
			dl.sharedListener(jFrame,jButton,name,-2);
		}
		jFrame.add(jButton);
		return jButton;
	}
	
	//JButton重构
	public JButton jButtonComponent(Frame frame,String name,final int id,int x,int y,int width,int height){
		DifferenceListener dl=new DifferenceListener(object);
		JButton jButton=new JButton(name);
		jButton.setBounds(x, y, width, height);
		if("搜索".equals(name )){
			dl.sharedListener(frame, jButton,name,0);
		}if("删除".equals(name)){
			dl.sharedListener(frame, jButton,name,0);
		}if("注册".equals(name)){
			dl.sharedListener(frame, jButton,name,0);
		}if("班级".equals(name)){
			dl.sharedListener(frame, jButton,name,0);
		}
		frame.add(jButton);
		return jButton;
	}

}
