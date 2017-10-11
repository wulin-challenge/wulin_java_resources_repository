package cn.scxh.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainFrame {
	public void launchFrame(){
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItem1 = new JMenuItem("New");
		JMenuItem menu2 = new JMenu("Convert line");
		JMenuItem menuItem21 = new JMenuItem("Convert line11");
		
		JMenuItem menuItem3 = new JMenuItem("ÐÂÔö");
		menuItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RegisterFrame().launchFrame();
			}
		});
		
		menu2.add(menuItem21);
		menu.add(menuItem1);
		menu.add(menu2);
		menu.add(menuItem3);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.launchFrame();
	}
}
