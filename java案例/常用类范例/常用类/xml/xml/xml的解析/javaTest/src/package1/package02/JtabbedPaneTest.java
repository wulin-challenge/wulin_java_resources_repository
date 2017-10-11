package package1.package02;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class JtabbedPaneTest {
	public static void main(String[] args) {
		JtabbedPaneTest jp=new JtabbedPaneTest();
		jp.jSplitPane1();
	}
	
	public void jSplitPane1(){
		JFrame jFrame=new JFrame();
		jFrame.setBounds(0, 0, 1500, 750);
		JPanel big=new JPanel();
		JPanel left=new JPanel();
		JPanel right=new JPanel();
		JPanel top=new JPanel();
		JPanel bottom=new JPanel();
		
		top.setPreferredSize(new Dimension(1500,100));
		
		left.setPreferredSize(new Dimension(700,800));
		right.setPreferredSize(new Dimension(1500, 750));
		
		JSplitPane jspBottom=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);
		bottom.add(jspBottom);
		JSplitPane jspVertical=new JSplitPane(JSplitPane.VERTICAL_SPLIT,top,bottom);
		
		
		JTabbedPane jTabbedPane=new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		JPanel leftTab=new JPanel();
		JPanel rightTab=new JPanel();
		
		jTabbedPane.addTab("left",leftTab);
		jTabbedPane.addTab("right",rightTab);
		jTabbedPane.setPreferredSize(new Dimension(1500,800));
		right.add(jTabbedPane);
		
		big.add(top);
		big.add(jspVertical);
		jFrame.add(big);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}


}
