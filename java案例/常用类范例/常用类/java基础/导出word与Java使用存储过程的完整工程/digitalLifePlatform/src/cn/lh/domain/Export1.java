package cn.lh.domain;

import java.util.ArrayList;
import java.util.List;

import cn.lh.util.DataUtil;

/**
 * 资阳市医疗保险特殊疾病申报审批表
 * @author Administrator
 *
 */
public class Export1 {
	private String username = ""; //参保人员
	private String gender = "";//性别
	private String age = "";//年龄
	private String address;//参保地址
	private String medicalNumber = "";//医保号码
	private String phoneNumber = "";//电话号码
	private String sicknessName = "";//疾病名称
	private List<String> sicknessNameList = new ArrayList<String>();
	private String hospitalDate = "";//诊断日期
	private String checkingResource = "";//检查资料
	private List<String> checkingResourceList = new ArrayList<String>();
	private String headPicture = "";//图片名称
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMedicalNumber() {
		return medicalNumber;
	}
	public void setMedicalNumber(String medicalNumber) {
		this.medicalNumber = medicalNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSicknessName() {
		return sicknessName;
	}
	public void setSicknessName(String sicknessName) {
		this.sicknessName = sicknessName;
		this.setSicknessNameList(DataUtil.getRowsContextOfString(this.getSicknessName().trim(), 11, 2));
	}
	public String getHospitalDate() {
		return hospitalDate;
	}
	public void setHospitalDate(String hospitalDate) {
		this.hospitalDate = hospitalDate;
	}
	public String getCheckingResource() {
		return checkingResource;
	}
	public void setCheckingResource(String checkingResource) {
		this.checkingResource = checkingResource;
		this.setCheckingResourceList(DataUtil.getRowsContextOfString(this.getCheckingResource().trim(), 23, 3));
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public List<String> getSicknessNameList() {
		return sicknessNameList;
	}
	public void setSicknessNameList(List<String> sicknessNameList) {
		this.sicknessNameList = sicknessNameList;
	}
	public List<String> getCheckingResourceList() {
		return checkingResourceList;
	}
	public void setCheckingResourceList(List<String> checkingResourceList) {
		this.checkingResourceList = checkingResourceList;
	}
}
