package cn.scxh.ittx.domain;

public class MedicineClassify {

	private int id;  //药物分类编号
	private String name; //药物分类名称
	private int pid; //药物分类的上一级的编号
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
