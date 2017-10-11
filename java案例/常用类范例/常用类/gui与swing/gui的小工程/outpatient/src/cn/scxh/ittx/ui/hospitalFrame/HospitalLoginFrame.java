package cn.scxh.ittx.ui.hospitalFrame;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.util.ConstantUtils;

public class HospitalLoginFrame{	
	public void loginJFrame(){
		DifferenceObject object=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object);
		JFrame jFrame=new JFrame("登录窗口");
		object.setJframe(jFrame);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setBounds(ConstantUtils.WIDTH/4, ConstantUtils.HEIGHT/4, ConstantUtils.WIDTH/2-65, ConstantUtils.HEIGHT/2-59);
		ImageIcon imageIcon=new ImageIcon(ConstantUtils.LOGIN);
		Image image=imageIcon.getImage();
		jFrame.setIconImage(image);
		
		dc.jLabelComponent(jFrame, "用户名:", jFrame.getWidth()-250, jFrame.getHeight()-100, 120, 20);
		dc.jTextFieldComponent(jFrame, "用户名:", jFrame.getWidth()-200, jFrame.getHeight()-100, 120, 20);
		dc.jButtonComponent(jFrame, "确定", 1, jFrame.getWidth()-80, jFrame.getHeight()-100, 60, 20);
		

		dc.jLabelComponent(jFrame, "密码:", jFrame.getWidth()-250, jFrame.getHeight()-80, 120, 20);
		dc.jPasswordFieldComponent(jFrame, "密码:", jFrame.getWidth()-200, jFrame.getHeight()-80, 120, 20);
		dc.jButtonComponent(jFrame, "取消", 1, jFrame.getWidth()-80, jFrame.getHeight()-80, 60, 20);
		
		
		
		
		dc.jLabelComponent(jFrame, imageIcon, "登录图片",0,0,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		jFrame.setVisible(true);
	}
}
