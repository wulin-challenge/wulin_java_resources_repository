package cn.scxh.ittx.domain;

public class Medicine {

	private int id;  //编号
	private String name;  //名字
	private String classification;  //药品类别
	private String standard; //药品规格
	private String enterCompany; //进口单位
	private String enterPrice;  //进口单位
	private String shoppingPrice;  //成本价
	private Integer validateNumber; //验证码
	private Integer salePrice;  //销售价格
	private String simpleName;  //简单名字
	private String upperLimit;  //库存上限
	private String downLimit;    //库存下限
	private String approveNumber;   //批准编号
	private String produceCompany;  //生产公司
	private String mainComponent;  //主要成分
	private String medicineEffect;  //药品功效
	private String useMethod;  //使用方法 
	private String mattersNeedAttention; //注意事项
	private int tmedicineClassifyId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getEnterCompany() {
		return enterCompany;
	}
	public void setEnterCompany(String enterCompany) {
		this.enterCompany = enterCompany;
	}
	public String getEnterPrice() {
		return enterPrice;
	}
	public void setEnterPrice(String enterPrice) {
		this.enterPrice = enterPrice;
	}
	public String getShoppingPrice() {
		return shoppingPrice;
	}
	public void setShoppingPrice(String shoppingPrice) {
		this.shoppingPrice = shoppingPrice;
	}
	public Integer getValidateNumber() {
		return validateNumber;
	}
	public void setValidateNumber(Integer validateNumber) {
		this.validateNumber = validateNumber;
	}
	public Integer getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	public String getDownLimit() {
		return downLimit;
	}
	public void setDownLimit(String downLimit) {
		this.downLimit = downLimit;
	}
	
	public String getApproveNumber() {
		return approveNumber;
	}
	public void setApproveNumber(String approveNumber) {
		this.approveNumber = approveNumber;
	}
	public String getProduceCompany() {
		return produceCompany;
	}
	public void setProduceCompany(String produceCompany) {
		this.produceCompany = produceCompany;
	}
	public String getMainComponent() {
		return mainComponent;
	}
	public void setMainComponent(String mainComponent) {
		this.mainComponent = mainComponent;
	}
	public String getMedicineEffect() {
		return medicineEffect;
	}
	public void setMedicineEffect(String medicineEffect) {
		this.medicineEffect = medicineEffect;
	}
	public String getUseMethod() {
		return useMethod;
	}
	public void setUseMethod(String useMethod) {
		this.useMethod = useMethod;
	}
	public String getMattersNeedAttention() {
		return mattersNeedAttention;
	}
	public void setMattersNeedAttention(String mattersNeedAttention) {
		this.mattersNeedAttention = mattersNeedAttention;
	}
	public int getTmedicineClassifyId() {
		return tmedicineClassifyId;
	}
	public void setTmedicineClassifyId(int tmedicineClassifyId) {
		this.tmedicineClassifyId = tmedicineClassifyId;
	}
	
	
	
}
