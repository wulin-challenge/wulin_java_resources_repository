package register.util;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import register.domain.DifferenceObject;
import register.ui.ClazzUI;
import register.ui.RegisterJFrame;
import register.ui.UpdateClazzUI;

public class DifferenceListener {
	DifferenceObject object;
	public DifferenceListener(){}
	public DifferenceListener(DifferenceObject object){
		this.object=object;
	}
	
	//共享的监听
	public void sharedListener(JFrame jFrame, JButton jButton,final String name ,final int id) {
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if("提交".equals(name)){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getRegisterValue();
				}
				if("更新".equals(name )&& id>0){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setUpdateValue();
				}if("刷新".equals(name)){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getRefreshClazzValue();
				}if("更新".equals(name )&& id==-2){
					int i=new UpdateClazzUI(object).updateClazzWindow();
					SetValueOfUI setValue=new SetValueOfUI(object);
					if(!(i==-1)){
						setValue.setClazzValue(i);
					}
				}if("更新".equals(name )&& id==-3){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getClazzValue();
				}if("添加".equals(name )&& id==-2){
					new UpdateClazzUI(object).addClazzWindow();
				}if("添加".equals(name )&& id==-3){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getAddClazzValue();
				}if("删除".equals(name )&& id==-2){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getDeleteClazzValue();
				}
			}
		});
	}
	
	//共享的监听重构
	public void sharedListener(Frame frame, JButton jButton,final String name ,final int id) {
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if("搜索".equals(name)){					
					GetValueOfUI value=new GetValueOfUI(object);
					value.getSearchingValue();
				}
				if("删除".equals(name)){					
					GetValueOfUI value=new GetValueOfUI(object);
					value.getDeleteValue();
				}
				if("注册".equals(name)){					
					RegisterJFrame registerJFrame=new RegisterJFrame(object);
					registerJFrame.registerJFarme();
				}if("班级".equals(name)){					
					new ClazzUI().clazzWindow();
				}
			}
		});
	}
}
