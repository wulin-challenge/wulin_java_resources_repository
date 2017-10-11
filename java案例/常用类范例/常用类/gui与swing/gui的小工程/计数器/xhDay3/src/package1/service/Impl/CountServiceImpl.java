package package1.service.Impl;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import package1.service.CountService;

public class CountServiceImpl implements CountService {

	JTextField jTextField;
	String jButtonStrings;// 集体输出
	String jButtonString;// 输入
	Integer number1; // 数字1
	Integer number;// 数字
	Integer result;// 结果
	String operation;// 运算符
	boolean flag = true;

	// 得到一个窗体
	public Frame getFrame() {
		Frame frame = new Frame();
		frame.setLayout(null);
		frame.setLocation(300, 300);
		frame.setSize(320, 300);
		return frame;
	}

	// 得到一个文本框
	public void getJTextField(Frame frame) {
		JTextField jTextField1 = new JTextField();
		jTextField1.setBounds(40, 40, 250, 20);
		this.jTextField = jTextField1;
		frame.add(jTextField1);
	}

	// 得到一个按钮
	public JButton getJButton(String buttonString, int i, int j, int k, int l) {
		JButton jButton = new JButton(buttonString);
		jButton.setBounds(i, j, k, l);
		return jButton;
	}

	// 操作按钮
	public void handleButton(CountService countService, Frame frame) {

		JButton jButton2 = countService.getJButton("-", 85, 70, 45, 20);
		countService.buttonListener(jButton2);
		frame.add(jButton2);

		JButton jButton3 = countService.getJButton("*", 130, 70, 45, 20);
		countService.buttonListener(jButton3);
		frame.add(jButton3);

		JButton jButton4 = countService.getJButton("/", 175, 70, 45, 20);
		countService.buttonListener(jButton4);
		frame.add(jButton4);

		JButton jButton_1 = countService.getJButton("1", 85, 90, 45, 20);
		countService.buttonListener(jButton_1);
		frame.add(jButton_1);

		JButton jButton_2 = countService.getJButton("2", 130, 90, 45, 20);
		countService.buttonListener(jButton_2);
		frame.add(jButton_2);

		JButton jButton_3 = countService.getJButton("3", 175, 90, 45, 20);
		countService.buttonListener(jButton_3);
		frame.add(jButton_3);

		JButton jButton_4 = countService.getJButton("4", 85, 110, 45, 20);
		countService.buttonListener(jButton_4);
		frame.add(jButton_4);

		JButton jButton_5 = countService.getJButton("5", 130, 110, 45, 20);
		countService.buttonListener(jButton_5);
		frame.add(jButton_5);

		JButton jButton_6 = countService.getJButton("6", 175, 110, 45, 20);
		countService.buttonListener(jButton_6);
		frame.add(jButton_6);

		JButton jButton_7 = countService.getJButton("7", 85, 130, 45, 20);
		countService.buttonListener(jButton_7);
		frame.add(jButton_7);

		JButton jButton_8 = countService.getJButton("8", 130, 130, 45, 20);
		countService.buttonListener(jButton_8);
		frame.add(jButton_8);

		JButton jButton_9 = countService.getJButton("9", 175, 130, 45, 20);
		countService.buttonListener(jButton_9);
		frame.add(jButton_9);
		// 这是加
		JButton jButton1 = countService.getJButton("+", 85, 150, 45, 20);
		countService.buttonListener(jButton1);
		frame.add(jButton1);

		JButton jButton_0 = countService.getJButton("0", 130, 150, 45, 20);
		countService.buttonListener(jButton_0);
		frame.add(jButton_0);

		// 这是=
		JButton jButton5 = countService.getJButton("=", 175, 150, 45, 20);
		countService.buttonListener(jButton5);
		frame.add(jButton5);
	}

	// 按钮监听器
	public void buttonListener(final JButton jButton) {
		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String jButtonString = jButton.getText();
				if (jButtonStrings == null && jButtonString != null) {
					jButtonStrings = jButtonString;
					jTextField.setText(jButtonStrings);
				} else {
					jButtonStrings += jButtonString;
					jTextField.setText(jButtonStrings);
				}
				

				// 为数字赋值
				if (number == null && jButtonString != null
						&& jButtonString.matches("[0-9]")) {
					number = Integer.parseInt(jButtonString);
				} else if (number != null && jButtonString != null
						&& jButtonString.matches("[0-9]")) {
					number = Integer.parseInt((number + "") + jButtonString);
					System.out.println(number+"=-=-=-=-");
				}
				if (flag && !jButtonString.matches("[0-9]")&&!"=".equals(jButtonString)) {
					result = number;
					operation = jButtonString;
					flag = false;
					number=null;
					System.out.println("haha");
				} else {
					System.out.println(number+"===");
					if ("+".equals(operation)&&!jButtonString.matches("[0-9]")) {
						operation = jButtonString;
						result = result + number;
						number = null;

					} else if ("-".equals(operation)&&!jButtonString.matches("[0-9]")) {
						operation = jButtonString;
						result = result - number;
						number = null;
					} else if ("*".equals(operation)&&!jButtonString.matches("[0-9]")) {
						operation = jButtonString;
						result = result * number;
						number = null;
					} else if ("/".equals(operation)&&!jButtonString.matches("[0-9]")) {
						operation = jButtonString;
						result = result / number;
						number = null;
					}  
					if ("=".equals(jButtonString)) {
						if ("+".equals(operation)) {
							result = result + number;
							number = null;
						} else if ("-".equals(operation)) {
							result = result - number;
							number = null;
						} else if ("*".equals(operation)) {
							result = result * number;
							number = null;
						} else if ("/".equals(operation)) {
							result = result / number;
							number = null;
						}
						
						if(jButtonStrings!=null){
							jTextField.setText(jButtonStrings+ result);
							
						}
					}
				}
			}
		});
	}
}
