package cn.scxh.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class RegisterFrame extends JFrame {
	public void launchFrame(){
		this.setBounds(200, 200, 300, 300);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				setVisible(false);
			}
			
		});
		
		this.setVisible(true);
	}

}
