package cn.scxh.ittx.ui.hospitalFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.util.ConstantUtils;

public class HospitalHomePageFrame {
	
	public void hospitalHomePage(){
		DifferenceObject object=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object);
		JFrame jFrame=new JFrame("医院首页");
		object.setJframe(jFrame);
		jFrame.setLayout(null);
		ImageIcon imageIcon=new ImageIcon(ConstantUtils._1700);
		jFrame.setBounds(0,0, ConstantUtils.WIDTH, ConstantUtils.HEIGHT);
		hospitalHomePageComponent(jFrame,dc,object);
		
		
		dc.jLabelComponent(jFrame, imageIcon, "医院首页图片", 0,0,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		jFrame.setVisible(true);
	}
	
	public void hospitalHomePageComponent(JFrame jFrame,DifferenceComponent dc,DifferenceObject object){
		
		dc.jButtonComponent(jFrame, ConstantUtils.IMG01, "IMG01", 1,0,0,60,60);
		dc.jButtonComponent(jFrame, ConstantUtils.IMG02, "IMG02", 1,70,0,60,60);
		dc.jButtonComponent(jFrame, ConstantUtils.IMG03, "IMG03", 1,140,0,60,60);
		dc.jButtonComponent(jFrame, ConstantUtils.IMG04, "IMG04", 1,210,0,60,60);
		dc.jButtonComponent(jFrame, ConstantUtils.IMG05, "IMG05", 1,280,0,60,60);
		dc.jButtonComponent(jFrame, ConstantUtils.IMG06, "IMG06", 1,350,0,60,60);
		dc.jButtonComponent(jFrame, ConstantUtils.IMG07, "IMG07", 1,420,0,60,60);
	}
	
	public static void main(String[] args) {

		HospitalHomePageFrame hhpf=new HospitalHomePageFrame();
		hhpf.hospitalHomePage();
	}

}
