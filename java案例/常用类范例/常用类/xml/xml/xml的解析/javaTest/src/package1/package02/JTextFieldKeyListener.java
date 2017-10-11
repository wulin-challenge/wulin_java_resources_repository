package package1.package02;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextFieldKeyListener {
	
	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setLayout(null);
		jFrame.setBounds(400,100,800,400);
		
		JTextField jtf=new JTextField();
		jtf.setBounds(60,40,100,20);
		
		jtf.addMouseListener(new MouseAdapter() {

			
			public void mouseClicked(MouseEvent e) {
				System.out.println("1111111");
			}

			public void mouseDragged(MouseEvent e) {
				System.out.println("2222");
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("33333");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("55555555");
			}

			public void mouseMoved(MouseEvent e) {
				System.out.println("6666666");
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("666666");
			}

			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("777777777");
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("888888888");
			}
			
		});
		
		jFrame.add(jtf);
		jFrame.setVisible(true);
	}

}
