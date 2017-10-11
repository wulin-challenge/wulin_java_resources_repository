package cn.lh.domain;

/**
 * 单病申报审批表欧
 * @author Administrator
 *
 */
public class Export3 {

	private String user = "";   	 //参保人员
	private String gender = ""; 	 //性别
	private String age = "";   	   	 //年龄
	private String contactPhone = "";//联系电话
	private String company = "";   	  //参保单位
	private String hospitalNumber = "";//医保号码
	private String companyAddressAndFamilyAddress = ""; //单位住址或家庭住址
	private String sicknessName = "" ; //病种名称
	private String medicalTreatmentDate = ""; //诊断时间
	private String medicalTreatmentResource = "";//诊断资料
	private MyDate myDate1 = new MyDate();		 //本人于______年___月___日
	private String hospital = "" ; //医院
	private String sectionCheif = "" ; //科级
	private String doctor = "" ; //医生
	private String sickness = "";//疾病
	private MyDate myDate2 = new MyDate(); //按医嘱应从_____年___月___日至
	private MyDate myDate3 = new MyDate(); //至______年___月___日止进行门诊
	private String medicinal = "" ; //药物
	private String allCost = "" ; //所有费用
	private String medicinalCost = "" ; //药品费用
	private String checkTreatmentCost = "" ; //检查费用
	private String cause = "" ; //原因
	private String countTreatmentCost = "" ; //计算治疗费用
	private String costControl = "" ; //费用控制
	private MyDate myDate4 = new MyDate(); //时间从_____年___月___日起至_____年___月___日止之前一个
	private MyDate myDate5 = new MyDate(); //时间从_____年___月___日起至_____年___月___日止之后一个
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
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getHospitalNumber() {
		return hospitalNumber;
	}
	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}
	public String getCompanyAddressAndFamilyAddress() {
		return companyAddressAndFamilyAddress;
	}
	public void setCompanyAddressAndFamilyAddress(
			String companyAddressAndFamilyAddress) {
		this.companyAddressAndFamilyAddress = companyAddressAndFamilyAddress;
	}
	public String getSicknessName() {
		return sicknessName;
	}
	public void setSicknessName(String sicknessName) {
		this.sicknessName = sicknessName;
	}
	public String getMedicalTreatmentDate() {
		return medicalTreatmentDate;
	}
	public void setMedicalTreatmentDate(String medicalTreatmentDate) {
		this.medicalTreatmentDate = medicalTreatmentDate;
	}
	public String getMedicalTreatmentResource() {
		return medicalTreatmentResource;
	}
	public void setMedicalTreatmentResource(String medicalTreatmentResource) {
		this.medicalTreatmentResource = medicalTreatmentResource;
	}
	public MyDate getMyDate1() {
		return myDate1;
	}
	public void setMyDate1(MyDate myDate1) {
		this.myDate1 = myDate1;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getSectionCheif() {
		return sectionCheif;
	}
	public void setSectionCheif(String sectionCheif) {
		this.sectionCheif = sectionCheif;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getSickness() {
		return sickness;
	}
	public void setSickness(String sickness) {
		this.sickness = sickness;
	}
	public MyDate getMyDate2() {
		return myDate2;
	}
	public void setMyDate2(MyDate myDate2) {
		this.myDate2 = myDate2;
	}
	public MyDate getMyDate3() {
		return myDate3;
	}
	public void setMyDate3(MyDate myDate3) {
		this.myDate3 = myDate3;
	}
	public String getMedicinal() {
		return medicinal;
	}
	public void setMedicinal(String medicinal) {
		this.medicinal = medicinal;
	}
	public String getAllCost() {
		return allCost;
	}
	public void setAllCost(String allCost) {
		this.allCost = allCost;
	}
	public String getMedicinalCost() {
		return medicinalCost;
	}
	public void setMedicinalCost(String medicinalCost) {
		this.medicinalCost = medicinalCost;
	}
	public String getCheckTreatmentCost() {
		return checkTreatmentCost;
	}
	public void setCheckTreatmentCost(String checkTreatmentCost) {
		this.checkTreatmentCost = checkTreatmentCost;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getCountTreatmentCost() {
		return countTreatmentCost;
	}
	public void setCountTreatmentCost(String countTreatmentCost) {
		this.countTreatmentCost = countTreatmentCost;
	}
	public String getCostControl() {
		return costControl;
	}
	public void setCostControl(String costControl) {
		this.costControl = costControl;
	}
	public MyDate getMyDate4() {
		return myDate4;
	}
	public void setMyDate4(MyDate myDate4) {
		this.myDate4 = myDate4;
	}
	public MyDate getMyDate5() {
		return myDate5;
	}
	public void setMyDate5(MyDate myDate5) {
		this.myDate5 = myDate5;
	}
}
