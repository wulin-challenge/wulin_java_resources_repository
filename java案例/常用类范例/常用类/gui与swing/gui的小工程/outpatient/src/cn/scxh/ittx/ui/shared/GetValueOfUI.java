package cn.scxh.ittx.ui.shared;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.impl.MedicineServiceImpl;
import cn.scxh.ittx.service.impl.PatientServiceImpl;
import cn.scxh.ittx.service.impl.SickCaseServiceImpl;
import cn.scxh.ittx.service.intf.MedicineService;
import cn.scxh.ittx.service.intf.PatientService;
import cn.scxh.ittx.service.intf.SickCaseService;
import cn.scxh.ittx.ui.form.FormLoginValidate;
import cn.scxh.ittx.ui.hospitalFrame.HospitalHomePageFrame;
import cn.scxh.ittx.util.SharedModel;

public class GetValueOfUI {
	private DifferenceObject object;

	public GetValueOfUI() {
	}

	public GetValueOfUI(DifferenceObject object) {
		this.object = object;
	}

	public void getFirstConfirmValue() {
		User user = new User();
		user.setName(object.getJtextFieldMap().get("用户名:").getText());
		user.setPassword(String.valueOf(object.getJpasswordField()
				.getPassword()));
		FormLoginValidate flv = new FormLoginValidate();
		Map<String, String> loginValidateError = flv.userLoginValidate(user);
		if (loginValidateError != null) {
			SetValueOfUI setValue = new SetValueOfUI(object);
			setValue.setLoginErrorResponse(loginValidateError);
		} else {
			object.getJframe().setVisible(false);
			HospitalHomePageFrame hhpf = new HospitalHomePageFrame();
			hhpf.hospitalHomePage();

		}
	}

	public Patient getTabbedPaneJPanel1ContextComponent() {
		Patient patient = new Patient();
		patient.setId(object.getJtextFieldMap().get("医疗证号:").getText());
		System.out.println(object.getJtextFieldMap().get("医疗证号:").getText());
		patient.setName(object.getJtextFieldMap().get("患者姓名:").getText());
		patient.setSex((String) object.getJcomboBoxMap().get("性        别:")
				.getSelectedItem());
		patient.setBlood((String) object.getJcomboBoxMap().get("血        型:")
				.getSelectedItem());
		try {
			patient.setAge(Integer.parseInt(object.getJtextFieldMap().get(
					"年        龄:").getText()));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "亲!年龄不能为空或非数字字符.");
		}
		patient.setMarried((String) object.getJcomboBoxMap().get("婚姻状况:")
				.getSelectedItem());
		patient.setJob((String) object.getJcomboBoxMap().get("职        业:")
				.getSelectedItem());
		try {
			patient.setWeight(Integer.parseInt(object.getJtextFieldMap().get(
					"体        重:").getText()));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "亲!体重不能为空或非数字字符.");
		}
		patient
				.setPhoneNumber(object.getJtextFieldMap().get("联系电话:")
						.getText());
		try {
			patient.setRegisterTime(DateFormat.getDateInstance().parse(
					new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		patient.setAddress(object.getJtextFieldMap().get("联系地址:").getText());
		patient.setAllergy(object.getJtextFieldMap().get(" 过 敏 史 :").getText());
		patient.setRemark(object.getJtextFieldMap().get("备        注:")
				.getText());
		return patient;
	}

	public void addValue(Patient patient) {
		PatientService ps = new PatientServiceImpl();
		try {
			ps.addPatient(patient);
		} catch (AddObjectException e1) {
			e1.printStackTrace();
		}
		try {
			ps.queryPatients(null);
			object.getSharedModel().setPatientArrays(ps.queryPatients(null));
			object.getJtable().updateUI();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	// 得到table中的选中值
	public List<Patient> updateTabbedPaneJPanel1ContextComponent() {
		JTable jTable = object.getJtable();
		int i = jTable.getSelectedRow();
		List<Patient> patientList = null;
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "请选中一行");
		} else {
			String id = (String) jTable.getValueAt(i, 0);
			PatientService ps = new PatientServiceImpl();

			Patient patient = new Patient();
			patient.setId(id);
			try {
				patientList = ps.differenceConditionQueryPatients(patient);
			} catch (QueryObjectException e) {
				e.printStackTrace();
			}
		}
		return patientList;
	}

	// 得到bottonLeftJPanel中的table中的选中值 ,并对选中行做了鼠标监听
	public void getTabbedSelectedValue() {
		final JTable jTable = object.getJtable();
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int i = jTable.getSelectedRow();
				if (i != -1) {
					String id = (String) jTable.getValueAt(i, 0);
					PatientService ps = new PatientServiceImpl();
					object.setId(id);
					Patient patient = new Patient();
					patient.setId(id);
					try {
						List<Patient> patientList = ps
								.differenceConditionQueryPatients(patient);

						SetValueOfUI.getInstance(object).setValueOfJPanel21(
								patientList);
					} catch (QueryObjectException e1) {
						e1.printStackTrace();
					}
				}
				getTableOfJPanel21();
			}

		});
	}

	// 从数据库中获得药物类别数据
	public String[] getMedicineClassification() {
		String[] classification = new String[] { "皮肤科常用药", "皮肤科中药", "西药成分外用药",
				"中药成分外用药", "内科用药", "儿科用药", "中成药", "收费项目", "消耗品项", "报销类" };

		return classification;
	}

	// 从数据库中获得药物类别数据
	public String[] getMedicineUnit() {
		String[] unit = new String[] { "袋", "箱", "包", "千克", "支", "瓶", "盒", "u" };

		return unit;
	}

	// 在JPanel21创建一个JTable表
	private void getTableOfJPanel21() {
		try {
			DifferenceObject o = object.getDifferenceObjectMap().get(
					"jPanel21Object");
			JPanel jPanel21 = o.getJpanel();
			SickCaseService sc = new SickCaseServiceImpl();
			SickCase sickCase = new SickCase();
			sickCase.setPatientIdFk(object.getId());
			if (o.getJtable() == null && o.getSharedModel() == null) {
				SharedModel sharedModel = new SharedModel();
				sharedModel.setPatientArrays(sc.querySickCase(sickCase));
				JTable jTable = new JTable(sharedModel);
				o.setJtable(jTable);
				o.setSharedModel(sharedModel);
				JScrollPane jScrollPane = new JScrollPane(jTable);
				jScrollPane.setBounds(0, 450, 1000, 100);
				jPanel21.add(jScrollPane);

			} else {
				o.getSharedModel().setPatientArrays(sc.querySickCase(sickCase));
				o.getJtable().updateUI();
			}
			SetValueOfUI setValue = new SetValueOfUI(object);
			setValue.comeBackDataFromJPanel21();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}

	}

	// 得到Id编号
	public String getLargestId(List<SickCase> variousList) {
		String id = null;
		if (!variousList.isEmpty()) {
			String frontSubstring = String.valueOf(variousList.get(0).getId())
					.substring(0, 8);
			String afterSubstring = String.valueOf(variousList.get(0).getId())
					.substring(8);
			Date date = new Date();
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String[] dateArray = dateString.split("-");
			String s = null;
			for (String string : dateArray) {
				if (s == null) {
					s = string;
				} else {
					s = s + string;
				}
			}
			if (frontSubstring.equals(s)) {
				id = s + String.valueOf(Integer.parseInt(afterSubstring) + 1);
			} else {
				id = s + 1;
			}
		}
		return id;
	}

	public void updateValue(Patient patient) {
		PatientService ps = new PatientServiceImpl();
		try {
			ps.updatePatient(patient);
		} catch (UpdateObjectException e1) {
			e1.printStackTrace();
		}
		try {
			ps.queryPatients(null);
			object.getSharedModel().setPatientArrays(ps.queryPatients(null));
			object.getJtable().updateUI();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	public void deleteValue() {
		JTable jTable = object.getJtable();
		int[] i = jTable.getSelectedRows();
		if (i.length == 0) {
			JOptionPane.showMessageDialog(null, "请至少选择一行");
		} else {
			int j = JOptionPane.showConfirmDialog(null, "确认删除吗?", null, 0, 0);
			PatientService ps = new PatientServiceImpl();
			if (j == 0) {
				for (int k = 0; k < i.length; k++) {
					String id = (String) jTable.getValueAt(i[k], 0);
					Patient patient = new Patient();
					patient.setId(id);
					try {
						ps.deletePatient(patient);
					} catch (DeleteObjectException e) {
						e.printStackTrace();
					}
				}
				try {
					object.getSharedModel().setPatientArrays(
							ps.queryPatients(null));
					jTable.updateUI();
				} catch (QueryObjectException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 从JPanel21中获取值并将其存放到数据库中
	public void getValueToJPane() {
		SickCaseService sc = new SickCaseServiceImpl();
		SickCase sickCase = new SickCase();
		try {
			List<SickCase> sickCaseList = sc.theLargestNumberOfSikeCase();
			if (!sickCaseList.isEmpty()) {
				sickCase.setId(Integer.parseInt(getLargestId(sickCaseList)));
			}
		} catch (QueryObjectException e1) {
			e1.printStackTrace();
		}
		getDateValueFromJPanel21(sickCase);

		try {
			sc.addSickCase(sickCase);
		} catch (AddObjectException e) {
			e.printStackTrace();
		}
		updateJTableOfJPanel21();
	}

	// 从JPanel21表单中获取到值
	public void getDateValueFromJPanel21(SickCase sickCase) {
		sickCase.setMainSymptom(object.getJtextFieldMap().get("主         诉:")
				.getText());
		sickCase.setNowSymptom(object.getJtextFieldMap().get("现  病  史:")
				.getText());
		sickCase.setPastSymptom(object.getJtextFieldMap().get("即  往  史:")
				.getText());
		sickCase.setPersonalSymptom(object.getJtextFieldMap().get("个  人  史:")
				.getText());
		sickCase.setBodyTest(object.getJtextFieldMap().get("体格检查:").getText());
		sickCase.setLabTest(object.getJtextFieldMap().get("实验检查:").getText());
		sickCase.setExamination(object.getJtextFieldMap().get("诊断:").getText());
		sickCase.setAdvice(object.getJtextFieldMap().get("处理意见:").getText());
		sickCase.setOtherExplain(object.getJtextFieldMap().get("其他说明:")
				.getText());
		try {
			sickCase.setExaminationTime(DateFormat.getDateInstance().parse(
					new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (object.getDifferenceObjectMap().get("object").getId() != null) {
			sickCase.setPatientIdFk(object.getDifferenceObjectMap().get(
					"object").getId());
		}
	}

	// 更新JPanel21的表单JTable
	public void updateJTableOfJPanel21() {
		SickCaseService scs = new SickCaseServiceImpl();
		try {
			SickCase sCase = new SickCase();
			sCase.setPatientIdFk(object.getDifferenceObjectMap().get("object")
					.getId());
			object.getSharedModel().setPatientArrays(scs.querySickCase(sCase));
			object.getJtable().updateUI();

		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	// 更新JPanel21表单中的值
	public void updateDateOfJPanel21() {
		JTable jTable = object.getJtable();
		if (jTable == null) {
			JOptionPane.showMessageDialog(null, "亲!请在病人表单中选中一个客户");
		} else {
			int j = jTable.getRowCount();
			if (j == 0) {
				JOptionPane.showMessageDialog(null, "亲!该用户没有病例,不能修改.");
			} else {
				int i = jTable.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "亲!请选择一条记录.");
				} else {
					SetValueOfUI setValue = new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(false);
					object.setFlag("_002");
				}
			}
		}
	}
	
	//共享得到值方法
	public void getSharedValue(Medicine medicine){
		medicine.setId(Integer.parseInt(object.getJtextFieldMap().get("药品编号:")
				.getText()));
		medicine.setName(object.getJtextFieldMap().get("药品名称:").getText());
		medicine.setClassification((String) object.getJcomboBoxMap().get(
				"药品类别:").getSelectedItem());
		medicine.setStandard(object.getJtextFieldMap().get("药品规格:").getText());
		medicine.setEnterCompany((String) object.getJcomboBoxMap().get("进货单位:")
				.getSelectedItem());
		System.out.println(object.getJcomboBoxMap().get("进货单位:")
				.getSelectedItem());

		medicine
				.setEnterPrice(object.getJtextFieldMap().get("药品进价:").getText());
		medicine.setShoppingPrice(object.getJtextFieldMap().get("成本价格:")
				.getText());
		try {
			medicine.setValidateNumber(Integer.parseInt(object
					.getJtextFieldMap().get("条形编码:").getText()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "亲!条形编码为数字且不能为空");
			return;
			// e1.printStackTrace();
		}
		try {
			medicine.setSalePrice(Integer.parseInt(object.getJtextFieldMap()
					.get("销售价格:").getText()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "亲!销售价格为数字且不能为空");
			return;
			// e1.printStackTrace();
		}
		medicine
				.setSimpleName(object.getJtextFieldMap().get("药品简拼:").getText());
		medicine
				.setUpperLimit(object.getJtextFieldMap().get("库存上限:").getText());
		medicine.setDownLimit(object.getJtextFieldMap().get("库存下限:").getText());
		medicine.setApproveNumber(object.getJtextFieldMap().get("批准文号:")
				.getText());
		medicine.setProduceCompany(object.getJtextFieldMap().get("生成厂家:")
				.getText());
		medicine.setMainComponent(object.getJtextFieldMap().get("主要成分:")
				.getText());
		medicine.setMedicineEffect(object.getJtextFieldMap().get("对象功效:")
				.getText());
		medicine.setUseMethod(object.getJtextFieldMap().get("使用方法:").getText());
		medicine.setMattersNeedAttention(object.getJtextFieldMap().get("注意事项:")
				.getText());

	}

	//从JPanel8的表单中得到值
	public void getDataFromJPanel8() {

		MedicineService ms = new MedicineServiceImpl();
		Medicine medicine=new Medicine();
		getSharedValue(medicine);
		try {
			ms.addMedicine(medicine);
			int id = 0;
			try {
				id = ms.theLargestNumberOfMedicines(null).get(0).getId() + 1;
			} catch (QueryObjectException e) {
				e.printStackTrace();
			}
			object.getJtextFieldMap().get("药品编号:").setText(String.valueOf(id));
			reflushJPanleTable();

		} catch (AddObjectException e) {
			e.printStackTrace();
		}
	}

	// 刷新JPanel8的表数据
	public void reflushJPanleTable() {
		DifferenceObject object7 = object.getDifferenceObjectMap().get(
				"object5").getDifferenceObjectMap().get("object7");
		String classification = (String) object.getJcomboBoxMap().get("药品类别:")
				.getSelectedItem();
		Medicine medicine = new Medicine();
		medicine.setClassification(classification);
		MedicineService ms = new MedicineServiceImpl();
		SharedModel sharedModel = object7.getSharedModel();
		try {
			sharedModel.setPatientArrays(ms.queryMedicines(medicine));
			object7.getJtable().updateUI();

		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	//从JPanel9的表单中得到值
	public void getDataFromJPanel9() {
		MedicineService ms = new MedicineServiceImpl();
		Medicine medicine=new Medicine();
		getSharedValue(medicine);
		try {
			ms.updateMedicine(medicine);
			reflushJPanleTable();

		} catch (UpdateObjectException e) {
			e.printStackTrace();
		}
	}

}
