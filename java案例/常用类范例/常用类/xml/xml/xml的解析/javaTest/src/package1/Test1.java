package package1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Test1 extends JFrame {
	public static void main(String[] args) {
		Test1 test1=new Test1();
		test1.getWindow();

	}

	public void getWindow() {
		this.setLayout(null);
		this.setBounds(100, 100, 600, 600);
		JTabbedPane tabbedPane = new JTabbedPane();
		JLabel jLabel=new JLabel("jLabel");
		jLabel.setBounds(10,10,60,20);

		// In this case the look and feel renders the title for the tab.
		tabbedPane.addTab("Tab", jLabel);
		tabbedPane.setBounds(10,40,60,20);
		// In this case the custom component is responsible for rendering the
		// title of the tab.
		//tabbedPane.addTab(null, this);
		//tabbedPane.setTabComponentAt(0, new JLabel("Tab"));
		this.add(tabbedPane);
		this.add(jLabel);
		this.setVisible(true);
	}

}
