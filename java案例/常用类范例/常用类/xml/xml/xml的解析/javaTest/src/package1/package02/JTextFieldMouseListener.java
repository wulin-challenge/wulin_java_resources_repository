package package1.package02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextFieldMouseListener {
	
	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setLayout(null);
		jFrame.setBounds(400,100,800,400);
		
		JTextField jtf=new JTextField();
		jtf.setBounds(60,40,100,20);
		jtf.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				System.out.println("hhhhhhhh");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("iiiiiiiiiiii");
			}

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("jjjjjjjjjjjjjjj");
			}
			
			
		});
		
		jFrame.add(jtf);
		jFrame.setVisible(true);
	}

}
