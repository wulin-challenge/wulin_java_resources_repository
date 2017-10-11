package cn.scxh.ittx.ui.hospitalFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.MedicineServiceImpl;
import cn.scxh.ittx.service.intf.MedicineService;
import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.ui.shared.GetValueOfUI;
import cn.scxh.ittx.ui.shared.SetValueOfUI;

public class MedicineAddOrUpdateFrame {
	private DifferenceObject object;
	public MedicineAddOrUpdateFrame(){}
	public MedicineAddOrUpdateFrame(DifferenceObject object){
		this.object=object;
	}

	//共用的组件
	public void sharedComponent(DifferenceComponent dc,JPanel jPanel){
		dc.jLabelComponent(jPanel, "药品编号:", 30,20,60,20);
		dc.jTextFieldComponent(jPanel, "药品编号:", 100,20,150,20);
		dc.jLabelComponent(jPanel, "药品名称:", 300,20,60,20);
		dc.jTextFieldComponent(jPanel, "药品名称:", 370,20,150,20);
		
		dc.jLabelComponent(jPanel, "药品类别:", 30,60,60,20);
		dc.jComboBoxConponent(jPanel, "药品类别:", new GetValueOfUI().getMedicineClassification(),100,60,150,20);
		dc.jLabelComponent(jPanel, "药品规格:", 300,60,60,20);
		dc.jTextFieldComponent(jPanel, "药品规格:", 370,60,150,20);
		
		dc.jLabelComponent(jPanel, "进货单位:", 30,100,60,20);
		dc.jComboBoxConponent(jPanel, "进货单位:", new GetValueOfUI().getMedicineUnit(),100,100,150,20);
		dc.jLabelComponent(jPanel, "药品进价:", 300,100,100,20);
		dc.jTextFieldComponent(jPanel, "药品进价:", 370,100,150,20);
		
		dc.jLabelComponent(jPanel, "成本价格:", 30,140,60,20);
		dc.jTextFieldComponent(jPanel, "成本价格:", 100,140,150,20);
		dc.jLabelComponent(jPanel, "条形编码:", 300,140,60,20);
		dc.jTextFieldComponent(jPanel, "条形编码:", 370,140,150,20);
		
		dc.jLabelComponent(jPanel, "销售价格:", 30,180,60,20);
		dc.jTextFieldComponent(jPanel, "销售价格:", 100,180,150,20);
		dc.jLabelComponent(jPanel, "药品简拼:", 300,180,60,20);
		dc.jTextFieldComponent(jPanel, "药品简拼:", 370,180,150,20);
		
		dc.jLabelComponent(jPanel, "库存上限:", 30,220,60,20);
		dc.jTextFieldComponent(jPanel, "库存上限:", 100,220,150,20);
		dc.jLabelComponent(jPanel, "库存下限:", 300,220,60,20);
		dc.jTextFieldComponent(jPanel, "库存下限:", 370,220,150,20);
		
		dc.jLabelComponent(jPanel, "批准文号:", 30,260,60,20);
		dc.jTextFieldComponent(jPanel, "批准文号:", 100,260,420,20);
		
		dc.jLabelComponent(jPanel, "生成厂家:", 30,300,60,20);
		dc.jTextFieldComponent(jPanel, "生成厂家:", 100,300,420,20);
		
		dc.jLabelComponent(jPanel, "主要成分:", 30,350,60,20);
		dc.jTextFieldComponent(jPanel, "主要成分:", 100,340,420,40);
		
		dc.jLabelComponent(jPanel, "对象功效:", 30,400,60,20);
		dc.jTextFieldComponent(jPanel, "对象功效:", 100,390,420,40);
		
		dc.jLabelComponent(jPanel, "使用方法:", 30,450,60,20);
		dc.jTextFieldComponent(jPanel, "使用方法:", 100,440,420,40);
		
		dc.jLabelComponent(jPanel, "注意事项:", 30,510,60,20);
		dc.jTextFieldComponent(jPanel, "注意事项:", 100,490,420,60);
		
	}
	
	//更新或增加的各种组件
	public void medicineAddOrUpdateComponent(JFrame jFrame,JPanel jPanel8,DifferenceObject object5){
		DifferenceObject object8=new DifferenceObject();
		object5.getDifferenceObjectMap().put("object8",object8);
		object8.getDifferenceObjectMap().put("object5",object5);
		DifferenceComponent dc=new DifferenceComponent(object8);
		object8.setDifferenceComponent(dc);
		object8.setJpanel(jPanel8);
		object8.setJframe(jFrame);
		sharedComponent(dc,jPanel8);
		dc.jButtonComponent(jPanel8, "保存", 5, 200,560,60,20);
		dc.jButtonComponent(jPanel8, "取消", 5, 350,560,60,20);
		MedicineService ms=new MedicineServiceImpl();
		int id=0;
		try {
			id=ms.theLargestNumberOfMedicines(null).get(0).getId()+1;
			object8.getJtextFieldMap().get("药品编号:").setText(String.valueOf(id));
			object8.getJtextFieldMap().get("药品编号:").setEditable(false);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}
	
	//创建一个更新的窗体
	public void medicineUpdateFrame(DifferenceObject object5){
		JFrame jFrame=new JFrame();
		closeJFrame(jFrame);
		JPanel jPanel9=new JPanel();
		jFrame.setBounds(400,60,600,650);
		jPanel9.setLayout(null);
		jPanel9.setBounds(400,60,600,650);
		medicineUpdateComponent(jFrame,jPanel9,object5);
		
		jFrame.add(jPanel9);
		jFrame.setVisible(true);
	}
	
	private void medicineUpdateComponent(JFrame jFrame, JPanel jPanel9,
			DifferenceObject object5) {
		DifferenceObject object9=new DifferenceObject();
		object5.getDifferenceObjectMap().put("object9",object9);
		object9.getDifferenceObjectMap().put("object5",object5);
		DifferenceComponent dc=new DifferenceComponent(object9);
		object9.setDifferenceComponent(dc);
		object9.setJpanel(jPanel9);
		object9.setJframe(jFrame);
		sharedComponent(dc,jPanel9);
		
		SetValueOfUI setValue=new SetValueOfUI(object9);
		int id=setValue.isSelectedOfJPanel7();
		if(id!=0){
			setValue.setDataToJPanel9(id);
		}
		
		dc.jButtonComponent(jPanel9, "保存", 6, 200,560,60,20);
		dc.jButtonComponent(jPanel9, "取消", 6, 350,560,60,20);
	}
	//创建一个增加或更新的窗体
	public void medicineAddOrUpdateFrame(DifferenceObject object5){
		JFrame jFrame=new JFrame();
		closeJFrame(jFrame);
		JPanel jPanel8=new JPanel();
		jFrame.setBounds(400,60,600,650);
		jPanel8.setLayout(null);
		jPanel8.setBounds(400,60,600,650);
		medicineAddOrUpdateComponent(jFrame,jPanel8,object5);
		
		jFrame.add(jPanel8);
		jFrame.setVisible(true);
	}
	public void closeJFrame(final JFrame jFrame) {
		jFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
	}
}




