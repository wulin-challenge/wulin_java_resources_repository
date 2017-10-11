package register.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import register.domain.Student;
import register.service.RegisterService;
import register.service.impl.RegisterServiceImpl;

public class RegisterUI {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(null);
		frame.setSize(500, 500);
		// 注册按钮
		JButton jButton = new JButton();
		jButton.setText("注册");
		jButton.setBounds(50, 50, 60, 20);
		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Frame frameRegister = new Frame();
				frameRegister.setLayout(null);
				frameRegister.setBounds(500, 100, 500, 500);

				// 学号的字段标签
				JLabel jLabelId = new JLabel();
				jLabelId.setBounds(100, 80, 35, 20);
				jLabelId.setText("学号 :");
				frameRegister.add(jLabelId);

				// 学号的文本框
				final JTextField jTextFieldId = new JTextField();
				jTextFieldId.setBounds(140, 80, 80, 20);
				frameRegister.add(jTextFieldId);

				// 姓名的字段标签
				JLabel jLabelName = new JLabel();
				jLabelName.setBounds(100, 120, 35, 20);
				jLabelName.setText("姓名 :");
				frameRegister.add(jLabelName);

				// 姓名的文本框
				final JTextField jTextFieldName = new JTextField();
				jTextFieldName.setBounds(140, 120, 80, 20);
				frameRegister.add(jTextFieldName);

				// 密码的字段标签
				JLabel jLabelPassword = new JLabel();
				jLabelPassword.setBounds(100, 160, 35, 20);
				jLabelPassword.setText("密码 :");
				frameRegister.add(jLabelPassword);

				// 密码的文本框
				final JPasswordField jPasswordField = new JPasswordField();
				jPasswordField.setBounds(140, 160, 80, 20);
				frameRegister.add(jPasswordField);

				// 性别的字段标签
				JLabel jLabelGender = new JLabel();
				jLabelGender.setBounds(100, 200, 35, 20);
				jLabelGender.setText("性别:");
				frameRegister.add(jLabelGender);

				// 建立一个ButtonGoup
				final ButtonGroup buttonGroup = new ButtonGroup();

				// 女的字段标签
				JLabel jLabelFemale = new JLabel();
				jLabelFemale.setBounds(140, 200, 20, 20);
				jLabelFemale.setText("女");
				frameRegister.add(jLabelFemale);

				// 建立一个单选钮
				final JRadioButton jRadioButtonFemale = new JRadioButton();
				jRadioButtonFemale.setText("女");
				jRadioButtonFemale.setBounds(155, 200, 20, 20);
				buttonGroup.add(jRadioButtonFemale);
				frameRegister.add(jRadioButtonFemale);

				// 男的字段标签
				JLabel jLabelmale = new JLabel();
				jLabelmale.setBounds(180, 200, 20, 20);
				jLabelmale.setText("男");
				frameRegister.add(jLabelmale);

				// 建立一个单选钮
				final JRadioButton jRadioButtonmale = new JRadioButton();
				jRadioButtonmale.setText("男");
				jRadioButtonmale.setBounds(195, 200, 20, 20);
				buttonGroup.add(jRadioButtonmale);
				frameRegister.add(jRadioButtonmale);
				
				// 身份证号的字段标签
				JLabel jLabelIdentityNumber = new JLabel();
				jLabelIdentityNumber.setBounds(80, 240, 70, 20);
				jLabelIdentityNumber.setText("身份证号 :");
				frameRegister.add(jLabelIdentityNumber);

				// 身份证号的文本框
				final JTextField jTextFieldIdentityNumber = new JTextField();
				jTextFieldIdentityNumber.setBounds(140, 240, 80, 20);
				frameRegister.add(jTextFieldIdentityNumber);

				// 注册日期的字段标签
				JLabel jLabelRegisterDate = new JLabel();
				jLabelRegisterDate.setBounds(80, 280, 70, 20);
				jLabelRegisterDate.setText("注册日期 :");
				frameRegister.add(jLabelRegisterDate);

				// 注册日期的文本框
				final JTextField jTextFieldRegisterDate = new JTextField();
				jTextFieldRegisterDate.setBounds(140, 280, 80, 20);
				frameRegister.add(jTextFieldRegisterDate);
				
				// 提交按钮
				JButton jButtonSubmit = new JButton();
				jButtonSubmit.setText("提交");
				jButtonSubmit.setBounds(300, 300, 60, 20);
				jButtonSubmit.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						Student student=new Student();
						if(jRadioButtonFemale.isSelected()){
							student.setGender(jRadioButtonFemale.getText());
						}else if(jRadioButtonmale.isSelected()){
							student.setGender(jRadioButtonmale.getText());
						}
						DateFormat dateFormat=DateFormat.getDateInstance();
						java.util.Date date=null;
						try {
							date=dateFormat.parse(jTextFieldRegisterDate.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						student.setId(Integer.decode(jTextFieldId.getText()));
						student.setName(jTextFieldName.getText());
						student.setPassword(String.valueOf(jPasswordField.getPassword()));
						student.setIdentityNumber(jTextFieldIdentityNumber.getText());
						student.setRegisterDate(date);
						RegisterService rs=new RegisterServiceImpl();
						rs.register(student);
						String s=jTextFieldId.getText();
					}

				});

				frameRegister.add(jButtonSubmit);

				frameRegister.setVisible(true);

			}

		});
		frame.add(jButton);

		frame.setVisible(true);

	}

}
