package cn.wulin.domain;

public class User {
	
	public User() {}
	
	public User(String username, Integer age) {
		super();
		this.username = username;
		this.age = age;
	}

	/**
	 * 用户姓名
	 */
	private String username; 
	
	/**
	 * 用户年龄
	 */
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "username : "+username+" , age : "+age;
	}
	
	
}
