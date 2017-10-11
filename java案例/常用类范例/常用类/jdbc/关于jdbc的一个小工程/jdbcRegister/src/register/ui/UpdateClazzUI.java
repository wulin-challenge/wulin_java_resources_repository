package register.ui;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import register.domain.DifferenceObject;
import register.util.DifferenceComponent;

public class UpdateClazzUI extends JFrame{
	private DifferenceObject object;
	public UpdateClazzUI(){}
	public UpdateClazzUI(DifferenceObject object){
		this.object = object;
	}


	public int updateClazzWindow(){
		object.getJframeMap().put("updateClazz", this);
		int id=-1;
		JTable jTable=object.getJtable();
		int[] i=jTable.getSelectedRows();
		int j=jTable.getSelectedRowCount();
		if(i.length==0||j>1){
			JOptionPane.showMessageDialog(null, "请选择一条记录");
		}else{
			id=Integer.parseInt((String)jTable.getValueAt(i[0], 0));
		this.setLayout(null);
		this.setBounds(300, 200, 200,200);
		DifferenceComponent dc=new DifferenceComponent(object);
		//---------------------------------
	
		//id
		dc.jLabelComponent(this, "编号:", 20, 30, 40, 20);
		dc.jTextFieldComponent(this,"编号:", 60, 30, 100, 20);
		
		//name
		dc.jLabelComponent(this, "名字:", 20, 60, 40, 20);
		dc.jTextFieldComponent(this,"名字:", 60, 60, 100, 20);
		
		dc.jButtonComponent(this, "更新", -3, 60, 100, 60, 20);
		
		//---------------------------------		
		this.setVisible(true);
		}
		return id;
	}
	
	public int addClazzWindow(){
		object.getJframeMap().put("addClazz", this);
		int id=-1;
		this.setLayout(null);
		this.setBounds(300, 200, 200,200);
		DifferenceComponent dc=new DifferenceComponent(object);
		//---------------------------------
	
		//id
		dc.jLabelComponent(this, "编号:", 20, 30, 40, 20);
		dc.jTextFieldComponent(this,"编号:", 60, 30, 100, 20);
		
		//name
		dc.jLabelComponent(this, "名字:", 20, 60, 40, 20);
		dc.jTextFieldComponent(this,"名字:", 60, 60, 100, 20);
		
		dc.jButtonComponent(this, "添加", -3, 60, 100, 60, 20);
		
		//---------------------------------		
		this.setVisible(true);
		
		return id;
	}
}
