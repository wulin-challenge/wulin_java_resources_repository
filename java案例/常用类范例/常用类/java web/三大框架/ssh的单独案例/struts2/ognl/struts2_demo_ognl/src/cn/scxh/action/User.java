package cn.scxh.action;

public class User {

	private String username;
	
	private String password;
	
	private int age;
	private Address address;
	
	public User(String name){
		System.out.println("dadfasdf");
		this.username = name;
	}
	
	public User(){}

	public String getUsername() {
		return username;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
