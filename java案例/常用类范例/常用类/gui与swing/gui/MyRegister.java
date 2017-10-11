package package2.gui;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyRegister {
	public static void main(String[] args) {
		Frame frame=new Frame("注册界面");
		frame.setLayout(null);//布局管理器
		
		frame.setLocation(333,200);
		frame.setSize(350,350);
		
		//用户名
		JLabel jLabel=new JLabel();
		jLabel.setText("用户名：");
		jLabel.setBounds(100,40,60,80);
		frame.add(jLabel);
		
		JTextField jtf=new JTextField();
		jtf.setBounds(150,70,100,20);
		frame.add(jtf);
		
		//密码
		JLabel jLabel2=new JLabel();
		jLabel2.setText("    密码：");
		jLabel2.setBounds(100,70,60,80);
		frame.add(jLabel2);
		
		JPasswordField jpf=new JPasswordField();
		jpf.setBounds(150,100,100,20);
		frame.add(jpf);
		
		//复选框
		JLabel jLabel3=new JLabel();
		jLabel3.setText("    爱好：");
		jLabel3.setBounds(100,100,60,80);
		frame.add(jLabel3);
		
		JLabel jLabel4=new JLabel();
		jLabel4.setText("唱歌");
		jLabel4.setBounds(150,100,60,80);
		frame.add(jLabel4);
		
		JCheckBox jcb=new JCheckBox();
		jcb.setBounds(175,130,20,20);
		frame.add(jcb);
		
		JLabel jLabel5=new JLabel();
		jLabel5.setText("跳舞");
		jLabel5.setBounds(200,100,60,80);
		frame.add(jLabel5);
		
		JCheckBox jcb1=new JCheckBox();
		jcb1.setBounds(225,130,20,20);
		frame.add(jcb1);
		
		JLabel jLabel6=new JLabel();
		jLabel6.setText("画画");
		jLabel6.setBounds(250,100,60,80);
		frame.add(jLabel6);
		
		JCheckBox jcb2=new JCheckBox();
		jcb2.setBounds(275,130,20,20);
		frame.add(jcb2);
		
		//性别
		JLabel jLabel7=new JLabel();
		jLabel7.setText("    性别：");
		jLabel7.setBounds(100,160,100,20);
		frame.add(jLabel7);
		
		JLabel jLabel8=new JLabel();
		jLabel8.setText("男");
		jLabel8.setBounds(150,160,100,20);
		frame.add(jLabel8);
		
		JRadioButton jrb=new JRadioButton();
		jrb.setBounds(160,160,20,20);
		frame.add(jrb);
		
		
		JLabel jLabel9=new JLabel();
		jLabel9.setText("女");
		jLabel9.setBounds(195,160,100,20);
		frame.add(jLabel9);
		
		JRadioButton jrb1=new JRadioButton();
		jrb1.setBounds(205,160,20,20);
		frame.add(jrb1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(jLabel8);
		bg.add(jLabel9);
		
		//下拉框
		JLabel jLabel10=new JLabel();
		jLabel10.setText("    城市：");
		jLabel10.setBounds(100,190,100,20);
		frame.add(jLabel10);
		
		JComboBox jcb_=new JComboBox();
		jcb_.setBounds(150,190,100,20);
		frame.add(jcb_);
		
		//提交
		JButton jb=new JButton("提交");
		jb.setBounds(160,220,60,20);
		frame.add(jb);
		
		//显示图形
		frame.setVisible(true);
	}
}
