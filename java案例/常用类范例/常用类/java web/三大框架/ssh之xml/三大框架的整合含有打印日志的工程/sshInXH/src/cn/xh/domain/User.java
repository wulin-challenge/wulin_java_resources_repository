package cn.xh.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Long id;
	private String name;
	private String password;
	private Set<Upload> uploadSet=new HashSet<Upload>();
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
	public Set<Upload> getUploadSet() {
		return uploadSet;
	}
	public void setUploadSet(Set<Upload> uploadSet) {
		this.uploadSet = uploadSet;
	}
	
	

}
