package cn.xh.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private Long id;
	private String name;
	private String password;
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	

}
