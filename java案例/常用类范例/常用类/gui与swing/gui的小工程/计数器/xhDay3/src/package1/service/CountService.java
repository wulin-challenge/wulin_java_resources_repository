package package1.service;

import java.awt.Frame;

import javax.swing.JButton;

public interface CountService {
	//得到chuangt
	public Frame getFrame();
	
	//得到文本框
	public void getJTextField(Frame frame);
	
	//得到一个按钮
	public JButton getJButton(String buttonString,int i,int j,int k,int l);
	
	//操作按钮
	public void handleButton(CountService countService,Frame frame);
	
	public void buttonListener(JButton jButton);
	
}
