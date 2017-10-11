package package3.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import package3.service.UserService;
import package3.service.serviceImpe.UserServiceImpl;

public class UserUI {
	
	public static void main(String[] args) {
		final UserService userService=new UserServiceImpl();
		
		
		final Frame frame=new Frame();
		frame.setLayout(null);//设置布局管理器
		frame.setLocation(250, 250);
		frame.setSize(400,400);
		
		JButton jButton=new JButton("刷新");
		jButton.setBounds(60, 40, 60, 20);
		
		
		
	
		final UserModel userModel=new UserModel();
		userModel.setUserString(userService.findAll());
		
		final JTable jTable=new JTable(userModel);
		JScrollPane jscrollPane=new JScrollPane(jTable);
		
		
	
		jButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				userModel.setUserString(userService.findAll1());
				jTable.updateUI();
			}
		});
		frame.add(jButton);
		jscrollPane.setBounds(25,80,300,200);
		frame.add(jscrollPane);
		
		
		frame.setVisible(true);
	}
}
