package register.domain;

import java.util.Date;

public class Student {
	
	private Integer id;  //学号
	private String name; //姓名
	private String password;  //密码
	private String gender;  //性别
	private String identityNumber;  //身份证号码
	private Date registerDate;  //注册日期
	private String clazzName;  //班级名字
	private int sid; //班级的外键
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getClazzname() {
		return clazzName;
	}
	public void setClazzname(String clazzname) {
		this.clazzName = clazzname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
