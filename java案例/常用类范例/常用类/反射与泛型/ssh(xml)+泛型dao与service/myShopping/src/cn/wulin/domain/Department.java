package cn.wulin.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private Long id;
	private String text;//部门名称
	private Boolean leaf;//树的节点类型
	private Department parent;//该部门的上一级
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	private Type type;
	private Set<Department> deptSet = new HashSet<Department>();//该部门所有的子部门
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	public Set<Department> getDeptSet() {
		return deptSet;
	}
	public void setDeptSet(Set<Department> deptSet) {
		this.deptSet = deptSet;
	}
	
}
