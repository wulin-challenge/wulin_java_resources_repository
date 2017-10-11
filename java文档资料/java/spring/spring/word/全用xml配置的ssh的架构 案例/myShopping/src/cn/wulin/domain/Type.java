package cn.wulin.domain;

import java.util.HashSet;
import java.util.Set;

public class Type {

	private Long id;
	private String name;      //类别名称
	private String viewAlias;  //Ext显示的别名
	private Type parent;
	private Set<Type> typeSet = new HashSet<Type>();
	
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
	public String getViewAlias() {
		return viewAlias;
	}
	public void setViewAlias(String viewAlias) {
		this.viewAlias = viewAlias;
	}
	public Type getParent() {
		return parent;
	}
	public void setParent(Type parent) {
		this.parent = parent;
	}
	public Set<Type> getTypeSet() {
		return typeSet;
	}
	public void setTypeSet(Set<Type> typeSet) {
		this.typeSet = typeSet;
	}
	
}
