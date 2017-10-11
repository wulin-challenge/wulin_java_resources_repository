package register.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import register.domain.Clazz;
import register.domain.DifferenceObject;
import register.domain.Student;
import register.service.ClazzService;
import register.service.RegisterService;
import register.service.impl.ClazzServiceImpl;
import register.service.impl.RegisterServiceImpl;

public class GetValueOfUI {
	private DifferenceObject object;
	public GetValueOfUI(){}
	public GetValueOfUI(DifferenceObject object){
		this.object=object;
	}
	
	//得到注册值
	public void getRegisterValue(){
		Student student=new Student();
		student.setId(Integer.decode(object.getJtextFieldMap().get("学号:").getText()));
		student.setName(object.getJtextFieldMap().get("姓名:").getText());
		student.setPassword(String.valueOf(object.getJpasswordField().getPassword()));
		JRadioButton jRadioButtonFemale=object.getJradioButtonMap().get("女");
		JRadioButton jRadioButtonmale=object.getJradioButtonMap().get("男");
		if(jRadioButtonFemale.isSelected()){
			student.setGender(jRadioButtonFemale.getText());
		}if(jRadioButtonmale.isSelected()){
			student.setGender(jRadioButtonmale.getText());
		}
		try {
			student.setRegisterDate(DateFormat.getDateInstance().parse(object.getJtextFieldMap().get("注册日期:").getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setIdentityNumber(object.getJtextFieldMap().get("身份证号:").getText());
		String str=(String)object.getJcomboBox().getSelectedItem();
		student.setClazzname(str);
		ClazzService cs=new ClazzServiceImpl();
		List<Clazz> clazzList=cs.queryClazzs();
		int i=0;
		for (Clazz clazz : clazzList) {
			if(str.equals(clazz.getName())){
				student.setSid(clazz.getId());
				break;
			}
			i++;
		}
		RegisterService rs=new RegisterServiceImpl();
		rs.register(student);
		object.getStudentModel().setSa(rs.findStudents());
		object.getJtable().updateUI();
	}
	
	//得到更新值
	public void getUpdateValue(int id){
		RegisterService rs=new RegisterServiceImpl();
		List<Student> studentList=rs.findStudentsById(id);
		Student student=studentList.get(0);
		JTextField jTextFieldId=object.getJtextFieldMap().get("编号:");
		jTextFieldId.setText(""+student.getId());
		jTextFieldId.setEditable(false);
		JTextField jTextFieldName=object.getJtextFieldMap().get("名字:");
		jTextFieldName.setText(student.getName());
		JTextField jTextFieldPassword=object.getJtextFieldMap().get("密码:");
		jTextFieldPassword.setText(student.getPassword());
		JTextField jTextFieldGender=object.getJtextFieldMap().get("性别:");
		jTextFieldGender.setText(student.getGender());
		JTextField jTextFieldIdentityNumber=object.getJtextFieldMap().get("身份证号:");
		jTextFieldIdentityNumber.setText(student.getIdentityNumber());
		JTextField jTextFieldRegisterDate=object.getJtextFieldMap().get("日期:");
		jTextFieldRegisterDate.setText(DateFormat.getDateInstance().format(student.getRegisterDate()));
		object.getJtextFieldMap().get("所属班级:").setText(student.getClazzname());
		object.getJtextFieldMap().get("班级编号:").setText(String.valueOf(student.getSid()));
	}
	public void getSearchingValue() {
		Student student=new Student();
		RegisterService rs=new RegisterServiceImpl();
		if(!"".equals(object.getJtextFieldMap().get("身份证号:").getText())){
			student.setIdentityNumber(object.getJtextFieldMap().get("身份证号:").getText());
		}if(!"".equals(object.getJtextFieldMap().get("姓名:").getText())){
			student.setName(object.getJtextFieldMap().get("姓名:").getText());
		}if(!"".equals(String.valueOf(object.getJpasswordField().getPassword()))){
			student.setPassword(String.valueOf(object.getJpasswordField().getPassword()));
		}
		StudentArrays studentArrays=rs.differenceConditionQuery(student);
		object.getStudentModel().setSa(studentArrays);
		object.getJtable().updateUI();
	}
	public void getDeleteValue() {
		JTable jTable=object.getJtable();
		int[] rows=jTable.getSelectedRows();
		if(rows.length<=0){
			JOptionPane.showMessageDialog(null, "请选择一条记录!");
		}else{
			int flag=JOptionPane.showConfirmDialog(null, "确认要删除吗?", "删除", 0, 0);
			if(flag==0){
				RegisterService rs=new RegisterServiceImpl();
				for(int i=0;i<rows.length;i++){
					Integer id=Integer.parseInt((String)jTable.getValueAt(rows[i], 0));
					rs.deleteById(id);
				}
				object.getStudentModel().setSa(rs.findStudents());
				object.getJtable().updateUI();
			}
		}
		
	}
	
	//刷新班级
	public void getRefreshClazzValue() {
		StudentArrays studentArray=new ClazzServiceImpl().findClazzs();
		object.getStudentModel().setSa(studentArray);
		object.getJtable().updateUI();
	}
	
	public void getClazzValue() {
		Clazz clazz=new Clazz();
		clazz.setId(Integer.parseInt(object.getJtextFieldMap().get("编号:").getText()));
		clazz.setName((object.getJtextFieldMap().get("名字:").getText()));
		new ClazzServiceImpl().updateClazz(clazz);
		StudentArrays studentArray=new ClazzServiceImpl().findClazzs();
		object.getStudentModel().setSa(studentArray);
		object.getJtable().updateUI();
		object.getJframeMap().get("updateClazz").setVisible(false);
		
	}
	public void getAddClazzValue() {
		Clazz clazz=new Clazz();
		clazz.setId(Integer.parseInt(object.getJtextFieldMap().get("编号:").getText()));
		clazz.setName(object.getJtextFieldMap().get("名字:").getText());
		ClazzService cs=new ClazzServiceImpl();
		cs.addClazz(clazz);
		StudentArrays studentArray=cs.findClazzs();
		object.getStudentModel().setSa(studentArray);
		object.getJtable().updateUI();
	}
	public void getDeleteClazzValue() {
		JTable jTable=object.getJtable();
		int[] i=jTable.getSelectedRows();
		if(i.length==0){
			JOptionPane.showMessageDialog(null, "请至少选择一条记录 !");
		}else{
			int j =JOptionPane.showConfirmDialog(null,"确定要删除吗?",null,0,0);
			if(j==0){
				ClazzService cs=new ClazzServiceImpl();
				for(int k=0;k<i.length;k++){
					int id=Integer.parseInt((String)jTable.getValueAt(i[k], 0));
					cs.deleteClassById(id);
				}
				StudentArrays studentArray=cs.findClazzs();
				object.getStudentModel().setSa(studentArray);
				object.getJtable().updateUI();
			}
		}
		
	}
	public String[] getClazzName() {
		ClazzService cs=new ClazzServiceImpl();
		List<Clazz> clazzList=cs.queryClazzs();
		String[] name=new String[clazzList.size()];
		int i=0;
		for (Clazz clazz : clazzList) {
			name[i]=clazz.getName();
			i++;
		}
		return name;
	}
}





