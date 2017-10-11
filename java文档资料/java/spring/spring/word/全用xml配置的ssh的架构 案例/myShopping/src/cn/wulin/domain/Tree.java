package cn.wulin.domain;

import java.util.HashSet;
import java.util.Set;

public class Tree {
	private String id;//接收前台传过来的Id
	private Long treeId;//映射到数据库的Id号
	private String text;
	private Boolean leaf;
	private Tree parent;
	private Set<Tree> children = new HashSet<Tree>();
	private String service;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTreeId() {
		return treeId;
	}
	public void setTreeId(Long treeId) {
		this.treeId = treeId;
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
	public Tree getParent() {
		return parent;
	}
	public void setParent(Tree parent) {
		this.parent = parent;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Set<Tree> getChildren() {
		return children;
	}
	public void setChildren(Set<Tree> children) {
		this.children = children;
	}
}
