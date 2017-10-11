package cn.lh.domain;

import java.util.ArrayList;
import java.util.List;

import cn.lh.util.DataUtil;

/**
 * 3个医院异地登记审批表
 * @author Administrator
 *
 */
public class Export2 {

	private String company = ""; //参保单位
	private String salary = "";  //支付待遇
	private String user = "";    //参保人员
	private String gender = "";  //性别
	private String age = "";		//年龄
	private String hospitalNumber = "";//医保号码
	private String address = ""; //异地居住详细地址
	private String contactPerson = ""; //异地居住地联系人
	private String contactPhoneNumber = "";//联系电话
	private String identityCardCopyPicture = "";//身份证复印件
	private String hospitalGrade1 = "";//定点医院级别1
	private String hospitalAddress1 = "";//定点医院地址1
	private List<String> hospitalAddress1List = new ArrayList<String>();
	private String hospitalAddress1Of5Char = "";
	private List<String> hospitalAddress1ListElimilate5Char = new ArrayList<String>();
	private String hospitalGrade2 = "";//定点医院级别2
	private String hospitalAddress2 = "";//定点医院地址2
	private List<String> hospitalAddress2List = new ArrayList<String>();
	private String hospitalAddress2Of5Char = "";
	private List<String> hospitalAddress2ListElimilate5Char = new ArrayList<String>();
	private String hospitalGrade3 = "";//定点医院级别3
	private String hospitalAddress3 = "";//定点医院地址3
	private List<String> hospitalAddress3List = new ArrayList<String>();
	private String hospitalAddress3Of5Char = "";
	private List<String> hospitalAddress3ListElimilate5Char = new ArrayList<String>();
	private String outsideHospitalAddress = "";//异地医院地址
	private List<String> outsideHospitalAddressList = new ArrayList<String>();
	private String outsideHospitalAddressOf5Char = "";
	private List<String> outsideHospitalAddressListElimilate5Char = new ArrayList<String>();
	private String outsideGovernmentAddress = "";//异地居委会地址
	private List<String> outsideGovernmentAddressList = new ArrayList<String>();
	private String outsideGovernmentAddressOf5Char = "";
	private List<String> outsideGovernmentAddressListElimilate5Char = new ArrayList<String>();
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	public String getHospitalNumber() {
		return hospitalNumber;
	}
	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public String getIdentityCardCopyPicture() {
		return identityCardCopyPicture;
	}
	public void setIdentityCardCopyPicture(String identityCardCopyPicture) {
		this.identityCardCopyPicture = identityCardCopyPicture;
	}
	public String getHospitalGrade1() {
		return hospitalGrade1;
	}
	public void setHospitalGrade1(String hospitalGrade1) {
		this.hospitalGrade1 = hospitalGrade1;
	}
	public String getHospitalAddress1() {
		return hospitalAddress1;
	}
	public void setHospitalAddress1(String hospitalAddress1) {
		this.hospitalAddress1 = hospitalAddress1;
		this.setHospitalAddress1Of5Char(DataUtil.getRowsContextOfString(this.getHospitalAddress1(), 5));
		this.setHospitalAddress1ListElimilate5Char(DataUtil.getRowsContextOfString2(this.getHospitalAddress1(), 5, 8));
	}
	public String getHospitalGrade2() {
		return hospitalGrade2;
	}
	public void setHospitalGrade2(String hospitalGrade2) {
		this.hospitalGrade2 = hospitalGrade2;
	}
	public String getHospitalAddress2() {
		return hospitalAddress2;
	}
	public void setHospitalAddress2(String hospitalAddress2) {
		this.hospitalAddress2 = hospitalAddress2;
		this.setHospitalAddress2Of5Char(DataUtil.getRowsContextOfString(this.getHospitalAddress2(), 5));
		this.setHospitalAddress2ListElimilate5Char(DataUtil.getRowsContextOfString2(this.getHospitalAddress2(), 5, 8));
	}
	public String getHospitalGrade3() {
		return hospitalGrade3;
	}
	public void setHospitalGrade3(String hospitalGrade3) {
		this.hospitalGrade3 = hospitalGrade3;
	}
	public String getHospitalAddress3() {
		return hospitalAddress3;
	}
	public void setHospitalAddress3(String hospitalAddress3) {
		this.hospitalAddress3 = hospitalAddress3;
		this.setHospitalAddress3Of5Char(DataUtil.getRowsContextOfString(this.getHospitalAddress3(), 5));
		this.setHospitalAddress3ListElimilate5Char(DataUtil.getRowsContextOfString2(this.getHospitalAddress3(), 5, 8));
	}
	public String getOutsideHospitalAddress() {
		return outsideHospitalAddress;
	}
	public void setOutsideHospitalAddress(String outsideHospitalAddress) {
		this.outsideHospitalAddress = outsideHospitalAddress;
		this.setOutsideHospitalAddressOf5Char(DataUtil.getRowsContextOfString(this.getOutsideHospitalAddress(), 5));
		this.setOutsideHospitalAddressListElimilate5Char(DataUtil.getRowsContextOfString2(this.getOutsideHospitalAddress(), 5, 8));
	}
	public String getOutsideGovernmentAddress() {
		return outsideGovernmentAddress;
	}
	public void setOutsideGovernmentAddress(String outsideGovernmentAddress) {
		this.outsideGovernmentAddress = outsideGovernmentAddress;
		this.setOutsideGovernmentAddressOf5Char(DataUtil.getRowsContextOfString(this.getOutsideGovernmentAddress(), 5));
		this.setOutsideGovernmentAddressListElimilate5Char(DataUtil.getRowsContextOfString2(this.getOutsideGovernmentAddress(), 5, 8));
	}
	public List<String> getHospitalAddress1List() {
		return hospitalAddress1List;
	}
	public void setHospitalAddress1List(List<String> hospitalAddress1List) {
		this.hospitalAddress1List = hospitalAddress1List;
	}
	public List<String> getHospitalAddress2List() {
		return hospitalAddress2List;
	}
	public void setHospitalAddress2List(List<String> hospitalAddress2List) {
		this.hospitalAddress2List = hospitalAddress2List;
	}
	public List<String> getHospitalAddress3List() {
		return hospitalAddress3List;
	}
	public void setHospitalAddress3List(List<String> hospitalAddress3List) {
		this.hospitalAddress3List = hospitalAddress3List;
	}
	public List<String> getOutsideHospitalAddressList() {
		return outsideHospitalAddressList;
	}
	public void setOutsideHospitalAddressList(
			List<String> outsideHospitalAddressList) {
		this.outsideHospitalAddressList = outsideHospitalAddressList;
	}
	public List<String> getOutsideGovernmentAddressList() {
		return outsideGovernmentAddressList;
	}
	public void setOutsideGovernmentAddressList(
			List<String> outsideGovernmentAddressList) {
		this.outsideGovernmentAddressList = outsideGovernmentAddressList;
	}
	public String getHospitalAddress1Of5Char() {
		return hospitalAddress1Of5Char;
	}
	public void setHospitalAddress1Of5Char(String hospitalAddress1Of5Char) {
		this.hospitalAddress1Of5Char = hospitalAddress1Of5Char;
	}
	public List<String> getHospitalAddress1ListElimilate5Char() {
		return hospitalAddress1ListElimilate5Char;
	}
	public void setHospitalAddress1ListElimilate5Char(
			List<String> hospitalAddress1ListElimilate5Char) {
		this.hospitalAddress1ListElimilate5Char = hospitalAddress1ListElimilate5Char;
	}
	public String getHospitalAddress2Of5Char() {
		return hospitalAddress2Of5Char;
	}
	public void setHospitalAddress2Of5Char(String hospitalAddress2Of5Char) {
		this.hospitalAddress2Of5Char = hospitalAddress2Of5Char;
	}
	public List<String> getHospitalAddress2ListElimilate5Char() {
		return hospitalAddress2ListElimilate5Char;
	}
	public void setHospitalAddress2ListElimilate5Char(
			List<String> hospitalAddress2ListElimilate5Char) {
		this.hospitalAddress2ListElimilate5Char = hospitalAddress2ListElimilate5Char;
	}
	public String getHospitalAddress3Of5Char() {
		return hospitalAddress3Of5Char;
	}
	public void setHospitalAddress3Of5Char(String hospitalAddress3Of5Char) {
		this.hospitalAddress3Of5Char = hospitalAddress3Of5Char;
	}
	public List<String> getHospitalAddress3ListElimilate5Char() {
		return hospitalAddress3ListElimilate5Char;
	}
	public void setHospitalAddress3ListElimilate5Char(
			List<String> hospitalAddress3ListElimilate5Char) {
		this.hospitalAddress3ListElimilate5Char = hospitalAddress3ListElimilate5Char;
	}
	public String getOutsideHospitalAddressOf5Char() {
		return outsideHospitalAddressOf5Char;
	}
	public void setOutsideHospitalAddressOf5Char(
			String outsideHospitalAddressOf5Char) {
		this.outsideHospitalAddressOf5Char = outsideHospitalAddressOf5Char;
	}
	public List<String> getOutsideHospitalAddressListElimilate5Char() {
		return outsideHospitalAddressListElimilate5Char;
	}
	public void setOutsideHospitalAddressListElimilate5Char(
			List<String> outsideHospitalAddressListElimilate5Char) {
		this.outsideHospitalAddressListElimilate5Char = outsideHospitalAddressListElimilate5Char;
	}
	public String getOutsideGovernmentAddressOf5Char() {
		return outsideGovernmentAddressOf5Char;
	}
	public void setOutsideGovernmentAddressOf5Char(
			String outsideGovernmentAddressOf5Char) {
		this.outsideGovernmentAddressOf5Char = outsideGovernmentAddressOf5Char;
	}
	public List<String> getOutsideGovernmentAddressListElimilate5Char() {
		return outsideGovernmentAddressListElimilate5Char;
	}
	public void setOutsideGovernmentAddressListElimilate5Char(
			List<String> outsideGovernmentAddressListElimilate5Char) {
		this.outsideGovernmentAddressListElimilate5Char = outsideGovernmentAddressListElimilate5Char;
	}
}
