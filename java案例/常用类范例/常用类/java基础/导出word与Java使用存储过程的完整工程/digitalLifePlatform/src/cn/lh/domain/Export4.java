package cn.lh.domain;

/**
 * 社会保障卡申领登记表(新版20140716)
 * @author Administrator
 *
 */
public class Export4 {

	private String countyName = "" ; //县/市/区名称
	private String townName = "" ; //镇（社区）名称
	private String villageName = "" ; //村/单位名称
	private String username = ""; //姓名
	private String gender = ""; //性别
	private String nation = ""; //民族
	private String postCode = ""; //邮政编码
	private IdentifyNumber  identifyNumber = new IdentifyNumber();
	private String communicationAddress = "" ; //通信地址
	private String headerPicture = ""; //一寸白底彩照
	private PhoneNumber phoneNumber1 = new PhoneNumber();//手机号码
	private PhoneNumber phoneNumber2 = new PhoneNumber();//座机号码
	private String chinaBank = "" ; //中国银行
	private String businessBank = "" ; //工商银行
	private String buildBank = ""; //建设银行
	private String agricultureBank = "" ; //农业银行
	private String postBank = ""; //邮政银行
	private String villageBank = ""; //农村合作;银行
	private String leShanBusinessBank = "" ; //乐山商业银行
	private String frontIdentifyCopyPicture = "" ; //正面省份证复印件
	private String reverseSideIdentifyCopyPicture = "" ; //反面省份证复印件
	
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
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
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public IdentifyNumber getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(IdentifyNumber identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getCommunicationAddress() {
		return communicationAddress;
	}
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}
	public String getHeaderPicture() {
		return headerPicture;
	}
	public void setHeaderPicture(String headerPicture) {
		this.headerPicture = headerPicture;
	}
	public PhoneNumber getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(PhoneNumber phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	public PhoneNumber getPhoneNumber2() {
		return phoneNumber2;
	}
	public void setPhoneNumber2(PhoneNumber phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	public String getChinaBank() {
		return chinaBank;
	}
	public void setChinaBank(String chinaBank) {
		this.chinaBank = chinaBank;
	}
	public String getBusinessBank() {
		return businessBank;
	}
	public void setBusinessBank(String businessBank) {
		this.businessBank = businessBank;
	}
	public String getBuildBank() {
		return buildBank;
	}
	public void setBuildBank(String buildBank) {
		this.buildBank = buildBank;
	}
	public String getAgricultureBank() {
		return agricultureBank;
	}
	public void setAgricultureBank(String agricultureBank) {
		this.agricultureBank = agricultureBank;
	}
	public String getPostBank() {
		return postBank;
	}
	public void setPostBank(String postBank) {
		this.postBank = postBank;
	}
	public String getVillageBank() {
		return villageBank;
	}
	public void setVillageBank(String villageBank) {
		this.villageBank = villageBank;
	}
	public String getLeShanBusinessBank() {
		return leShanBusinessBank;
	}
	public void setLeShanBusinessBank(String leShanBusinessBank) {
		this.leShanBusinessBank = leShanBusinessBank;
	}
	public String getFrontIdentifyCopyPicture() {
		return frontIdentifyCopyPicture;
	}
	public void setFrontIdentifyCopyPicture(String frontIdentifyCopyPicture) {
		this.frontIdentifyCopyPicture = frontIdentifyCopyPicture;
	}
	public String getReverseSideIdentifyCopyPicture() {
		return reverseSideIdentifyCopyPicture;
	}
	public void setReverseSideIdentifyCopyPicture(
			String reverseSideIdentifyCopyPicture) {
		this.reverseSideIdentifyCopyPicture = reverseSideIdentifyCopyPicture;
	}
}
