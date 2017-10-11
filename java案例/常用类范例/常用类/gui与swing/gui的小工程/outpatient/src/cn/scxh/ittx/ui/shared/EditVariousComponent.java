package cn.scxh.ittx.ui.shared;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.util.ConstantUtils;

public class EditVariousComponent {
	private static EditVariousComponent editVariousComponent;
	public EditVariousComponent(){}
	public synchronized static EditVariousComponent getInstance(){
		if(editVariousComponent==null){
			editVariousComponent=new EditVariousComponent();
		}
		return editVariousComponent;
	}
	
	// topJPanel
	public void topJPanelContext(JPanel topJPanel, DifferenceObject object) {
		topJPanel.setLayout(null);
		DifferenceComponent dc = object.getDifferenceComponent();
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String da = simpleDateFormat.format(d);
		String[] date = new String[] { da };

		dc.jLabelComponent(topJPanel, "起始日期:", 10, 30, 60, 20);
		dc.jComboBoxConponent(topJPanel, "起始日期:", date, 80, 30, 100, 20);

		dc.jLabelComponent(topJPanel, "截止日期:", 200, 30, 60, 20);
		dc.jComboBoxConponent(topJPanel, "截止日期:", date, 270, 30, 100, 20);

		String[] name = new String[] { "证号/姓名", "性别", "婚姻状况", "职业", "联系地址",
				"出诊整理意见", "出诊意见" };
		dc.jLabelComponent(topJPanel, "查找位置:", 390, 30, 60, 20);
		dc.jComboBoxConponent(topJPanel, "查找位置:", name, 460, 30, 100, 20);

		dc.jLabelComponent(topJPanel, "关键字:", 580, 30, 60, 20);
		dc.jTextFieldComponent(topJPanel, "关键字", 650, 30, 60, 20);

	}

	//tabbedPaneJPanel2ContectJPanel21
	public void tabbedPaneJPanel2ContectJPanel21(JPanel jPanel21,DifferenceObject object) {
		jPanel21.setLayout(null);
		
		DifferenceObject o=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(o);
		o.setDifferenceComponent(dc);
		object.getDifferenceObjectMap().put("jPanel21Object", o);
		o.getDifferenceObjectMap().put("object", object);
		o.setJpanel(jPanel21);
		
		
		EditVariousComponent.getInstance().tabbedPaneJPanel21Judge(jPanel21,o);
		tabbedPaneJPanel2ContectJPanel21Component(jPanel21, object);
		
	}
	
	//这是JPanel21的顶部菜单
	public void tabbedPaneJPanel21Judge(JPanel jPanel21,DifferenceObject o){
		DifferenceComponent dc=o.getDifferenceComponent();
		if(o.getFlagList().isEmpty()){
			o.getFlagList().add(true);
		}
		dc.jButtonComponent(jPanel21, ConstantUtils._001, "_001", 4,
				0, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._002, "_002", 4,
				60, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._003, "_003", 4,
				120, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._004, "_004", 4,
				180, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._005, "_005", 4,
				240, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._006, "_006", 4,
				300, 0, 60, 60);
		SetValueOfUI setValue=new SetValueOfUI(o);
		setValue.setIsEnabledOfButton(true);
		
	}

	//JPanel2ContectJPanel21
	private void tabbedPaneJPanel2ContectJPanel21Component(JPanel jPanel21,
			DifferenceObject object) {
		DifferenceObject o=object.getDifferenceObjectMap().get("jPanel21Object");
		DifferenceComponent dc=o.getDifferenceComponent();
		dc.jLabelComponent(jPanel21, "医疗证号:", 0,70,60,20);
		dc.jLabelComponent(jPanel21, "姓名:", 160,70,60,20);
		dc.jLabelComponent(jPanel21, "性别:", 320,70,60,20);
		dc.jLabelComponent(jPanel21, "年龄:", 480,70,60,20);
		GetValueOfUI value=new GetValueOfUI(object);
		value.getTabbedSelectedValue();
		drawingJTableInJPanel21(jPanel21,object);
		
	}
	
	public void tabbedPaneJPanel1ContextComponent(JPanel tabbedPaneJPanel1,
			DifferenceObject object) {
		DifferenceComponent dc = object.getDifferenceComponent();
		String[] nameArray = new String[] { "男", "女" };
		String[] marriedArray = new String[] { "已婚", "未婚" };
		String[] professionArray = new String[] { "农民", "医生", "化妆师" };
		String[] bloodArray = new String[] { "A型", "B型", "O型", "AB型" };

		dc.jLabelComponent(tabbedPaneJPanel1, "医疗证号:", 0, 80, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "医疗证号:", 70, 80, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "患者姓名:", 200, 80, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "患者姓名:", 270, 80, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "性        别:", 0, 120, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "性        别:", nameArray, 70,
				120, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "年        龄:", 200, 120, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "年        龄:", 270, 120, 100,
				20);

		dc.jLabelComponent(tabbedPaneJPanel1, "婚姻状况:", 0, 160, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "婚姻状况:", marriedArray, 70,
				160, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "职        业:", 200, 160, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "职        业:",
				professionArray, 270, 160, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "体        重:", 0, 200, 60, 20);
		dc.jLabelComponent(tabbedPaneJPanel1, "kg", 171, 200, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "体        重:", 70, 200, 100,
				20);

		dc.jLabelComponent(tabbedPaneJPanel1, "血        型:", 200, 200, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "血        型:", bloodArray,
				270, 200, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "联系电话:", 0, 240, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "联系电话:", 70, 240, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "登记日期:", 200, 240, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "登记日期:", 270, 240, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "联系地址:", 0, 280, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "联系地址:", 70, 280, 300, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, " 过 敏 史 :", 0, 320, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, " 过 敏 史 :", 70, 320, 300, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "初诊意见:", 0, 360, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "初诊意见:", 70, 360, 300, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "备        注:", 0, 400, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "备        注:", 70, 400, 300,
				20);
	}
	
	// tabbedPaneJPanel1
	public void tabbedPaneJPanel1Context(JPanel tabbedPaneJPanel1,
			DifferenceObject object) {

		tabbedPaneJPanel1.setLayout(null);

		

		EditVariousComponent.getInstance().tabbedPaneJPanel1Judge(tabbedPaneJPanel1,object);
		tabbedPaneJPanel1ContextComponent(tabbedPaneJPanel1, object);
	}
	
	// tabbedPaneJPanel1 的 judge
	public void tabbedPaneJPanel1Judge(JPanel tabbedPaneJPanel1,DifferenceObject object){
		DifferenceComponent dc = object.getDifferenceComponent();
		if(object.getFlagList().isEmpty()){
			object.getFlagList().add(true);
		}
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._001, "_001", 3,
					0, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._002, "_002", 3,
					60, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._003, "_003", 3,
					120, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._006, "_006", 3,
					300, 0, 60, 60);
	
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._004, "_004", 3,
					180, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._005, "_005", 3,
					240, 0, 60, 60);
			SetValueOfUI setValue=new SetValueOfUI(object);
			setValue.setIsEnabledOfButton(true);
		
	}
	
	//drawingJTable
	private void drawingJTableInJPanel21(JPanel jPanel21,
			DifferenceObject object) {
		DifferenceObject o=object.getDifferenceObjectMap().get("jPanel21Object");
		DifferenceComponent dc=o.getDifferenceComponent();
		dc.jLabelComponent(jPanel21, "就诊日期:", 640,70,60,20);
		dc.jTextFieldComponent(jPanel21, "就诊日期", 710,70,100,20);
		dc.jLabelComponent(jPanel21, "主        诉:", 0,90,60,20);
		dc.jTextFieldComponent(jPanel21, "主         诉:", 70,90,740,20);
		dc.jLabelComponent(jPanel21, "现  病  史:", 0,120,60,20);
		dc.jTextFieldComponent(jPanel21, "现  病  史:", 2, 70,110,740,40);
		dc.jLabelComponent(jPanel21, "即  往  史:", 0,160,60,20);
		dc.jTextFieldComponent(jPanel21, "即  往  史:", 2, 70,150,740,40);
		dc.jLabelComponent(jPanel21, "个  人  史:", 0,200,60,20);
		dc.jTextFieldComponent(jPanel21, "个  人  史:", 2, 70,190,740,40);
		dc.jLabelComponent(jPanel21, "体格检查:", 0,250,60,20);
		dc.jTextFieldComponent(jPanel21, "体格检查:", 2, 70,230,740,60);
		dc.jLabelComponent(jPanel21, "实验检查:", 0,300,60,20);
		dc.jTextFieldComponent(jPanel21, "实验检查:", 2, 70,290,740,40);
		dc.jLabelComponent(jPanel21, "诊断:", 0,340,60,20);
		dc.jTextFieldComponent(jPanel21, "诊断:", 2, 70,330,740,40);
		dc.jLabelComponent(jPanel21, "处理意见:", 0,380,60,20);
		dc.jTextFieldComponent(jPanel21, "处理意见:", 2, 70,370,740,40);
		dc.jLabelComponent(jPanel21, "其他说明:", 0,420,60,20);
		dc.jTextFieldComponent(jPanel21, "其他说明:", 2, 70,410,740,40);
		
	}
	
	//药品设置的顶部菜单JPanel1中的组件
	public DifferenceObject setTotJPanelComponent(JPanel topJPanel) {
		topJPanel.setLayout(null);
		DifferenceObject object5=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object5);
		object5.setDifferenceComponent(dc);
		object5.setJpanel(topJPanel);
		dc.jButtonComponent(topJPanel,ConstantUtils.M1, "M1", 5, 0,0,60,60);
		dc.jButtonComponent(topJPanel,ConstantUtils.M2, "M2", 5, 60,0,60,60);
		dc.jButtonComponent(topJPanel,ConstantUtils.M3, "M3", 5, 120,0,60,60);
		return object5;
	}
	
	//编辑JPanel10中的各种组件
	public void editJPanel10Component(DifferenceObject object10) {
		DifferenceComponent dc=object10.getDifferenceComponent();
		JPanel jPanel10=object10.getJpanel();
		
		dc.jLabelComponent(jPanel10, "查找关键字", 0,5,70,20);
		dc.jTextFieldComponent(jPanel10, "查找关键字", 71,5,100,20);
		dc.jLabelComponent(jPanel10, "的信息", 172,5,50,20);
		dc.jButtonComponent(jPanel10, "搜索", 10, 215,5,60,20);
		dc.jLabelComponent(jPanel10, "1.鼠标选择西药后方右键[点击下级目录]可增加更", 0,35,300,20);
		dc.jLabelComponent(jPanel10, "多分类,其他操作同理.", 10,55,300,20);
		dc.jLabelComponent(jPanel10, "2.鼠标选择所建的对应分类后右键[添加药方,数量", 0,75,300,20);
		dc.jLabelComponent(jPanel10, "用法],可新建更多经验方,用量,用法.", 10,95,300,20);
		dc.jLabelComponent(jPanel10, "3.建议你手动展开下面目录后,再进行手动搜索", 0,115,300,20);
	}
	
	

}
