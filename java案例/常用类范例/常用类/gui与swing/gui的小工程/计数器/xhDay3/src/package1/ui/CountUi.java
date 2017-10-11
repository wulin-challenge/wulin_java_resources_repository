package package1.ui;

import java.awt.Frame;

import javax.swing.JButton;

import package1.service.CountService;
import package1.service.Impl.CountServiceImpl;

public class CountUi {
	static CountService countService=new CountServiceImpl();
	
	public static void main(String[] args) {
		//得到一个窗体
		Frame frame=countService.getFrame();
		//得到一个文本框
		countService.getJTextField(frame);
		//得到操作按钮
		countService.handleButton(countService,frame);
		
		
		frame.setVisible(true);
	}

}
