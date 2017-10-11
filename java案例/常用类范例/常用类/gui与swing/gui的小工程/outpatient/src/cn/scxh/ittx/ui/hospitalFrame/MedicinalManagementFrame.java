package cn.scxh.ittx.ui.hospitalFrame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.ui.shared.EditVariousComponent;
import cn.scxh.ittx.ui.shared.MedicinalTree;
import cn.scxh.ittx.util.ConstantUtils;

public class MedicinalManagementFrame {
	private DifferenceObject object5;

	public void medicinalManagement(){
		JFrame jFrame =new JFrame("药品设置");
		//TODO 这个地方没有设置药品的布局管理器
		jFrame.setBounds(ConstantUtils.WIDTH/8, ConstantUtils.HEIGHT/10,ConstantUtils.WIDTH-ConstantUtils.WIDTH/4,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JPanel bigJPanel=new JPanel();
		bigJPanel.setBounds(ConstantUtils.WIDTH/8, ConstantUtils.HEIGHT/10,ConstantUtils.WIDTH-ConstantUtils.WIDTH/4,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6);
		
		jSlitPaneMedicinal(bigJPanel);
		
		
		jFrame.add(bigJPanel);
		jFrame.setVisible(true);
	}
	
	//使用JSplitPane进行布局
	public void jSlitPaneMedicinal(JPanel bigJPanel){
		EditVariousComponent evc=new EditVariousComponent();
		JPanel topJPanel=new JPanel();
		JPanel bottomJPanel=new JPanel();
		JPanel leftBottomJPanel=new JPanel();
		JPanel rightBottomJPanel=new JPanel();
		
		leftBottomJPanel.setPreferredSize(new Dimension(194,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6-60));
		rightBottomJPanel.setPreferredSize(new Dimension(800,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6-60));
		
		
		topJPanel.setPreferredSize(new Dimension(ConstantUtils.WIDTH-ConstantUtils.WIDTH/4-20,60));
		bottomJPanel.setPreferredSize(new Dimension(ConstantUtils.WIDTH-ConstantUtils.WIDTH/4-20,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6-60));
		
		JSplitPane verticalJSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topJPanel,bottomJPanel);
		JSplitPane horizontalJSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftBottomJPanel,rightBottomJPanel);
		this.object5=evc.setTotJPanelComponent(topJPanel);
		MedicinalTree tree=new MedicinalTree(this.object5);
		rightBottomJTabbedPane(rightBottomJPanel);
		tree.createTree(leftBottomJPanel);
		//--------------
		
		
		//--------------
		
		
		bottomJPanel.add(horizontalJSplitPane);
		bigJPanel.add(verticalJSplitPane);
		
	}
	
	//创建一个名为"药品列表"的JTabbedPane
	public void rightBottomJTabbedPane(JPanel rightBottomJPanel){
		JPanel jPanel7=new JPanel();
		jPanel7.setLayout(null);
		DifferenceObject object7=new DifferenceObject();
		this.object5.getDifferenceObjectMap().put("object7", object7);
		object7.getDifferenceObjectMap().put("object5", object5);
		object7.setJpanel(jPanel7);
		JTabbedPane jTabbedPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.add("药品列表",jPanel7);
		jTabbedPane.setPreferredSize(new Dimension(ConstantUtils.WIDTH-ConstantUtils.WIDTH/4-225,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6-60));
		rightBottomJPanel.add(jTabbedPane);
	}
	
	public static void main(String[] args) {
		new MedicinalManagementFrame().medicinalManagement();
	}
}
