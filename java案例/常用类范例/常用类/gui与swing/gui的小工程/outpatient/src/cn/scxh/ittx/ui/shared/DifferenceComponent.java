package cn.scxh.ittx.ui.shared;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.scxh.ittx.domain.DifferenceObject;

public class DifferenceComponent {
	private static DifferenceComponent differenceComponent;
	private JLabel jLabel;
	private String flag=null;
	private DifferenceObject object;
	public DifferenceComponent(){}
	public DifferenceComponent(DifferenceObject object){
		this.object=object;
	}
	public synchronized static DifferenceComponent getInstance(DifferenceObject object){
		if(differenceComponent==null){
			differenceComponent=new DifferenceComponent(object);
		}
		return differenceComponent;
	}
	public JLabel jLabel(String flag){
		if(this.jLabel==null||!this.flag.equals(flag)){
			this.jLabel=new JLabel();
			this.flag=flag;
			}
		return jLabel;
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
	
	
	//JLabel
	public JLabel jLabelComponent(JFrame jFrame,String name ,int x,int y,int width,int height){
		JLabel jLable=new JLabel(name);
		jLable.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLable);
		jFrame.add(jLable);
		return jLable;
	}
	
	//JLabel
	public JLabel jLabelComponent(JPanel jPanel,String name ,int x,int y,int width,int height){
		JLabel jLable=new JLabel(name);
		jLable.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLable);
		jPanel.add(jLable);
		return jLable;
	}
	
	//单列JLabel
	public JLabel jLabelComponent(JPanel jPanel,String name ,int x,int y,int width,int height,String flag){	
		JLabel jLabel=jLabel(flag);
		jLabel.setText(name);
		jLabel.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLabel);
		jPanel.add(jLabel);
		return jLabel;
	}
	
	public JLabel jLabelComponent(JFrame jFrame,ImageIcon imageicon ,String name ,int x,int y,int width,int height){
		JLabel jLable=new JLabel(imageicon);
		jLable.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLable);
		jFrame.add(jLable);
		return jLable;
	}
	
	public JLabel jLabelComponent(JFrame jFrame,JPanel jPanel,ImageIcon imageicon ,String name ,int x,int y,int width,int height){
		JLabel jLable=new JLabel(imageicon);
		jLable.setBounds(x, y, width, height);
		object.getJlabelMap().put(name, jLable);
		jPanel.add(jLable);
		jFrame.add(jPanel);
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
	
	//JTextField
	public JTextField jTextFieldComponent(JPanel jPanel,String name ,int x,int y,int width,int height){
		JTextField jTextField=new JTextField();
		object.getJtextFieldMap().put(name, jTextField);
		jTextField.setBounds(x, y, width, height);
		jPanel.add(jTextField);
		return jTextField;
	}
	
	//JTextFieldColumns
	public JTextField jTextFieldComponent(JPanel jPanel,String name ,int columns,int x,int y,int width,int height){
		JTextField jTextField=new JTextField();
		object.getJtextFieldMap().put(name, jTextField);
		jTextField.setBounds(x, y, width, height);
		jTextField.setColumns(columns);
		jPanel.add(jTextField);
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
	public JComboBox jComboBoxConponent(JFrame jFrame,String flagName,String[] name ,int x,int y,int width,int height){
		JComboBox jComboBoxCField=new JComboBox(name);
		object.getJcomboBoxMap().put(flagName, jComboBoxCField);
		jComboBoxCField.setBounds(x, y, width, height);
		jFrame.add(jComboBoxCField);
		return jComboBoxCField;
	}
	
	//JCombobox
	public JComboBox jComboBoxConponent(JPanel jPanel,String flagName,String[] name ,int x,int y,int width,int height){
		JComboBox jComboBoxCField=new JComboBox(name);
		object.getJcomboBoxMap().put(flagName, jComboBoxCField);
		jComboBoxCField.setBounds(x, y, width, height);
		jPanel.add(jComboBoxCField);
		return jComboBoxCField;
	}
	
	//JButton
	public JButton jButtonComponent(JFrame jFrame,String name,final int validate,int x,int y,int width,int height){
		DifferenceListener dl=new DifferenceListener(object);
		JButton jButton=new JButton(name);
		jButton.setBounds(x, y, width, height);
		if("确定".equals(name)&&validate==1){
			dl.sharedListener(jFrame, jButton, name, validate);
		}
		if("取消".equals(name)&&validate==1){
			dl.sharedListener(jFrame, jButton, name, validate);
		}
		
		jFrame.add(jButton);
		return jButton;
	}
	
	//JButton
	public JButton jButtonComponent(JPanel jPanel,String name,final int validate,int x,int y,int width,int height){
		DifferenceListener dl=new DifferenceListener(object);
		JButton jButton=new JButton(name);
		jButton.setBounds(x, y, width, height);
		if("确定".equals(name)&&validate==1){
			dl.sharedListener(jPanel, jButton, name, validate);
		}if("保存".equals(name)&&validate==5){
			dl.sharedListener(jPanel, jButton, name, validate);
		}if("取消".equals(name)&&validate==5){
			dl.sharedListener(jPanel, jButton, name, validate);
		}if("保存".equals(name)&&validate==6){
			dl.sharedListener(jPanel, jButton, name, validate);
		}if("取消".equals(name)&&validate==6){
			dl.sharedListener(jPanel, jButton, name, validate);
		}
		
		jPanel.add(jButton);
		return jButton;
	}
	
	//JButton
	public JButton jButtonComponent(JPanel jPanel,String imagePath,String name,final int validate,int x,int y,int width,int height){
		JButton jButton=null;
		ImageIcon imageIcon=new ImageIcon(imagePath);
		DifferenceListener dl=new DifferenceListener(object);
	    if(object.getJbuttonMap().isEmpty()){
	    	jButton=new JButton(imageIcon);
	    object.getJbuttonMap().put(name, jButton);
		}else if(object.getJbuttonMap().containsKey(name)){
			jButton=object.getJbuttonMap().get(name);
			
		}else{
			jButton=new JButton(imageIcon);
		    object.getJbuttonMap().put(name, jButton);
		}
	    jButton.setBounds(x, y, width, height);
		
	    if("M1".equals(name)&&validate==5){
	    	dl.sharedListener(jPanel, jButton, name, validate);
	    }
	    if("M2".equals(name)&&validate==5){
	    	dl.sharedListener(jPanel, jButton, name, validate);
	    } if("M3".equals(name)&&validate==5){
	    	dl.sharedListener(jPanel, jButton, name, validate);
	    }
	    
		if("_001".equals(name)&&validate==3){
			dl.sharedListener(jPanel, jButton, name, validate);
			
		}if("_002".equals(name)&&validate==3){
			dl.sharedListener(jPanel, jButton, name, validate);
			
		}if("_003".equals(name)&&validate==3){
			dl.sharedListener(jPanel, jButton, name, validate);
			
		}if("_004".equals(name)&&validate==3){
			dl.sharedListener(jPanel, jButton, name, validate);
		}
		if("_005".equals(name)&&validate==3){
			dl.sharedListener(jPanel, jButton, name, validate);
		}
		
		if("_001".equals(name)&&validate==4){
			dl.sharedListener(jPanel, jButton, name, validate);
			
		}if("_002".equals(name)&&validate==4){
			dl.sharedListener(jPanel, jButton, name, validate);
			
		}if("_003".equals(name)&&validate==4){
			dl.sharedListener(jPanel, jButton, name, validate);
			
		}if("_004".equals(name)&&validate==4){
			dl.sharedListener(jPanel, jButton, name, validate);
		}
		if("_005".equals(name)&&validate==4){
			dl.sharedListener(jPanel, jButton, name, validate);
		}
		
		jPanel.add(jButton);
		return jButton;
	}
	
	//JButton
	public JButton jButtonComponent(JFrame jFrame,String imagePath,String name,final int validate,int x,int y,int width,int height){
		ImageIcon imageIcon=new ImageIcon(imagePath);
		DifferenceListener dl=new DifferenceListener(object);
		JButton jButton=new JButton(imageIcon);
		jButton.setBounds(x, y, width, height);
		
		if("IMG02".equals(name)&&validate==1){
			dl.sharedListener(jFrame, jButton, name, validate);
		}
		if("IMG03".equals(name)&&validate==1){
			dl.sharedListener(jFrame, jButton, name, validate);
		}
		if("IMG07".equals(name)&&validate==1){
			dl.sharedListener(jFrame, jButton, name, validate);
		}
		
		
		jFrame.add(jButton);
		return jButton;
	}

}
