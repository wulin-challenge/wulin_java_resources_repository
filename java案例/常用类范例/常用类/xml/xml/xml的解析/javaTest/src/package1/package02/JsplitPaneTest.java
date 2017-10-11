package package1.package02;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JsplitPaneTest {
	public static void main(String[] args) {
		JsplitPaneTest jpt=new JsplitPaneTest();
		jpt.jSplitPane();
	}
	
	public void jSplitPane(){
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
		
		
		big.add(top);
		big.add(jspVertical);
		jFrame.add(big);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

}
