package cn.wulin.domain;

import java.util.HashSet;
import java.util.Set;

public class Apple {

	private Long id;
	private String text;
	private Boolean leaf;
	private Tree parent;
	private Set<Tree> children = new HashSet<Tree>();
	private Tree Tree;
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
	public Tree getParent() {
		return parent;
	}
	public void setParent(Tree parent) {
		this.parent = parent;
	}
	public Set<Tree> getChildren() {
		return children;
	}
	public void setChildren(Set<Tree> children) {
		this.children = children;
	}
	public Tree getTree() {
		return Tree;
	}
	public void setTree(Tree tree) {
		Tree = tree;
	}
}
