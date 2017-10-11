package cn.wulin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.wulin.action.util.ActionUtil;
import cn.wulin.domain.Department;
import cn.wulin.domain.Type;
import cn.wulin.service.DepartmentService;
import cn.wulin.service.TypeService;

import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {

	private static final long serialVersionUID = -7139463632928072890L;
	private DepartmentService departmentService;
	private TypeService typeService;
	private String id;
	private String nodeName; // 添加的节点名称
	private String parentName; // 所添加节点的父节点
	private String typeName; // 添加节点的所属的类型

	private String page; // 当前页
	private String start; // 开始记录
	private String limit; // 每页显示的条数
	
	private String query; //部门编号

	/** 添加部门 */
	public String add() throws Exception {
		return null;
	}

	public String list() throws Exception{
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			Long myId = ActionUtil.getId(id);
			int first = ActionUtil.getInt(this.start);
			int max = ActionUtil.getInt(this.limit);
			Long query = null;
			if(this.query != null){
				query = Long.valueOf(this.query);
			}
			List<Department> departmentList = departmentService.findPage(myId,
					first, max,query);
			int count = departmentService.getAllRecords(myId);
			String json = ActionUtil.getDepartmentGridJson(departmentList,
					count);
			System.out.println(json);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 得到部门Tree */
	public String getTree() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Long myId = ActionUtil.getId(id);
		List<Department> departmentList = departmentService.findChildren(myId);
		String json = ActionUtil.getDepartmentJson(departmentList);
		response.getWriter().write(json);
		return null;
	}

	public String setTreeSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Long id = ActionUtil.getId(this.typeName);
		Type type = typeService.findEntity(id);
		Department department = new Department();
		department.setText(nodeName);
		department.setType(type);
		department.setLeaf(false);
		try {
			if (parentName.equals("root")) {
				department.setParent(null);
				departmentService.saveEntity(department);
			} else {
				Long parentId = ActionUtil.getId(parentName);
				Department parent = departmentService.findEntity(parentId);
				department.setParent(parent);
				departmentService.saveEntity(department);
			}
			response.getWriter().write("{\"information\":\"success\"}");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("{\"informent\":\"fail\"}");
		}
		return null;
	}

	// -----set and get-----------

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
