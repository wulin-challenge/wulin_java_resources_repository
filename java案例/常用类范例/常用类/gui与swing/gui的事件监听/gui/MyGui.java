package package1.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyGui {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(null);
		frame.setLocation(300, 300);
		frame.setSize(320, 300);

		final JTextField jTextField = new JTextField();
		jTextField.setBounds(50, 50, 50, 20);
		frame.add(jTextField);

		JLabel jLabel = new JLabel();
		jLabel.setText("+");
		jLabel.setBounds(115, 50, 20, 20);
		frame.add(jLabel);

		final JTextField jTextField1 = new JTextField();
		jTextField1.setBounds(140, 50, 50, 20);
		frame.add(jTextField1);

		final JTextField jTextField2 = new JTextField();
		jTextField2.setBounds(250, 50, 50, 20);
		frame.add(jTextField2);

		JButton jButton = new JButton("=");

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 int sum= Integer.parseInt(jTextField.getText())+Integer.parseInt(jTextField1.getText());
				 
				 jTextField2.setText(sum+"");
				

			}

		});
		

		jButton.setBounds(200, 50, 45, 20);
		frame.add(jButton);


		frame.setVisible(true);
	}
}
