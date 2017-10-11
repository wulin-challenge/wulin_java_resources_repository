package cn.scxh.ittx.ui.shared;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.ui.hospitalFrame.MedicinalManagementFrame;
import cn.scxh.ittx.ui.hospitalFrame.MedicineAddOrUpdateFrame;
import cn.scxh.ittx.ui.hospitalFrame.PatientConsultFrame;

public class DifferenceListener extends WindowAdapter{
	String result=null;
	DifferenceObject object;
	public DifferenceListener(){}
	public DifferenceListener(DifferenceObject object){
		this.object=object;
	}
	
	//共享的监听
	public void sharedListener(final JFrame jFrame, JButton jButton,final String name ,final int validate) {
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if("确定".equals(name)&&validate==1){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getFirstConfirmValue();
				}if("取消".equals(name)&&validate==1){
					jFrame.dispose();
				}if("IMG02".equals(name)&&validate==1){
					PatientConsultFrame pcf=new PatientConsultFrame();
					pcf.patientConsult();
				}
				if("IMG03".equals(name)&&validate==1){
					PatientConsultFrame pcf=new PatientConsultFrame();
					pcf.patientConsult();
				}
				if("IMG07".equals(name)&&validate==1){
					new MedicinalManagementFrame().medicinalManagement();
				}
			}
		});
	}
	
	//JPanel共享监听
	int i=1;
	public String sharedListener(final JPanel jPanel,final JButton jButton, final String name,
			final int validate) {
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if("M1".equals(name)&&validate==5){
					MedicineAddOrUpdateFrame frame=new MedicineAddOrUpdateFrame();
					frame.medicineAddOrUpdateFrame(object);
				}if("M2".equals(name)&&validate==5){
					SetValueOfUI setValue=new SetValueOfUI(object);
					int id=setValue.isSelectedOfJPanel7();
					if(id!=0){
						MedicineAddOrUpdateFrame frame=new MedicineAddOrUpdateFrame();
						frame.medicineUpdateFrame(object);
					}
				}if("M3".equals(name)&&validate==5){
					SetValueOfUI setValue=new SetValueOfUI(object);
					int id=setValue.isSelectedOfJPanel7();
					if(id!=0){
						setValue.setDeleteFromJPanel7(id);
					}
				}
				
				if("保存".equals(name)&&validate==5){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getDataFromJPanel8();
				}if("取消".equals(name)&&validate==5){
					object.getJframe().dispose();
				}if("保存".equals(name)&&validate==6){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getDataFromJPanel9();
					
				}if("取消".equals(name)&&validate==6){
					object.getJframe().dispose();
				}
				
				
				if("_001".equals(name)&&validate==3){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(false);
					setValue.settabbedPaneJPanel1ContextComponent();
				
				}if("_002".equals(name)&&validate==3){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(false);
					GetValueOfUI value=new GetValueOfUI(object);
					List<Patient> patientList=value.updateTabbedPaneJPanel1ContextComponent();
					if(patientList!=null){
						setValue.setUpdateValue(patientList);
					}
				
				}if("_003".equals(name)&&validate==3){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(false);
					GetValueOfUI value=new GetValueOfUI(object);
					value.deleteValue();
				}if("_004".equals(name)&&validate==3&&"_001".equals(object.getFlag())){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(true);
					GetValueOfUI value=new GetValueOfUI(object);
						Patient patient=value.getTabbedPaneJPanel1ContextComponent();
						value.addValue(patient);
						
						object.setFlag(null);
					
				}if("_004".equals(name)&&validate==3&&"_002".equals(object.getFlag())){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(true);
					GetValueOfUI value=new GetValueOfUI(object);
					Patient patient=value.getTabbedPaneJPanel1ContextComponent();
					value.updateValue(patient);
					object.setFlag(null);
				}if("_005".equals(name)&&validate==3){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(true);
					object.setFlag(null);
				}
				
				
				if("_001".equals(name)&&validate==4){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(false);
					setValue.setSkipToAddJPanel21();
					
					object.setFlag("_001");
				}if("_002".equals(name)&&validate==4){
					
					GetValueOfUI value=new GetValueOfUI(object);
					value.updateDateOfJPanel21();
					
					
					
					
				}if("_003".equals(name)&&validate==4){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setDeleteOfJPanel21();
					object.setFlag("_003");
					object.setFlag(null);
				}if("_004".equals(name)&&validate==4&&"_001".equals(object.getFlag())){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(true);
					
					GetValueOfUI value=new GetValueOfUI(object);
					value.getValueToJPane();
					object.setFlag(null);
				}if("_004".equals(name)&&validate==4&&"_002".equals(object.getFlag())){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.confirmUpdateOfJPanel21();
					setValue.setIsEnabledOfButton(true);
				}
				if("_005".equals(name)&&validate==4){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(true);
					object.setFlag(null);
				}
				
			}
		});
		return result;
	}
	
	//windowListener

	

	
	
	
	
	
	
}
