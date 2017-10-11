package package1.package02;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextFieldListener {
	
	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setLayout(null);
		jFrame.setBounds(400,100,800,400);
		
		JTextField jtf=new JTextField();
		jtf.setBounds(60,40,100,20);
		
		jtf.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				System.out.println("1111111111");
			}
			
			public void insertUpdate(DocumentEvent e) {
				System.out.println("22222222");
			}
			
			public void changedUpdate(DocumentEvent e) {
				System.out.println("3333333");
			}
		});
		
		jFrame.add(jtf);
		jFrame.setVisible(true);
	}

}
