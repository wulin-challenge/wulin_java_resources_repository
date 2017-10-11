package cn.wulin.domain.help;

import java.util.HashSet;
import java.util.Set;

import cn.wulin.domain.Department;
import cn.wulin.domain.Type;

public class DepartmentHelp {

	private String id;
	private String text;//部门名称
	private Boolean leaf;//树的节点类型
	private Department parent;//该部门的上一级
	private Type type;
	
	private String nodeName; // 添加的节点名称
	private String parentName; // 所添加节点的父节点
	private String typeName; // 添加节点的所属的类型

	private String page; // 当前页
	private String start; // 开始记录
	private String limit; // 每页显示的条数
	
	private String departmentId; //部门编号
	private String departmentIds;

	private Set<Department> deptSet = new HashSet<Department>();//该部门所有的子部门
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Set<Department> getDeptSet() {
		return deptSet;
	}
	public void setDeptSet(Set<Department> deptSet) {
		this.deptSet = deptSet;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentIds() {
		return departmentIds;
	}
	public void setDepartmentIds(String departmentIds) {
		this.departmentIds = departmentIds;
	}
}
