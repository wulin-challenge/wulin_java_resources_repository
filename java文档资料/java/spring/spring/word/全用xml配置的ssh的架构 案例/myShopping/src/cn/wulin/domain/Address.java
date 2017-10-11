package cn.wulin.domain;

import java.util.HashSet;
import java.util.Set;

public class Address {

	private Long id; 
	private String name; 
	private Address parent;
	private Set<Address> children = new HashSet<Address>();
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
	public Address getParent() {
		return parent;
	}
	public void setParent(Address parent) {
		this.parent = parent;
	}
	public Set<Address> getChildren() {
		return children;
	}
	public void setChildren(Set<Address> children) {
		this.children = children;
	}
}
