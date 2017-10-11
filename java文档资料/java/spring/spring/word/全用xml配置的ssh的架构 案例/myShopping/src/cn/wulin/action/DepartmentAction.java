package cn.wulin.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.wulin.action.util.ActionUtil;
import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Department;
import cn.wulin.domain.Type;
import cn.wulin.domain.help.DepartmentHelp;

public class DepartmentAction extends ModelDrivenBaseAction<DepartmentHelp> {

	private static final long serialVersionUID = -7139463632928072890L;
	
	/** 添加部门 */
	public String add() throws Exception {
		return null;
	}
	
	public String findAllTop() throws Exception {
		departmentService.findAllTop();
		return null;
	}
	
	public String delete() throws Exception {
		departmentService.deletes(ActionUtil.getLongArray(model.getDepartmentIds()));
		return null;
	}

	public String list() throws Exception{
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			Long myId = ActionUtil.getId(model.getId());
			int first = ActionUtil.getInt(model.getStart());
			int max = ActionUtil.getInt(model.getLimit());
			Long departmentId = null;
			if(model.getDepartmentId() != null){
				departmentId = Long.valueOf(model.getDepartmentId());
			}
			List<Department> departmentList = departmentService.findPage(myId,first, max,departmentId);
			int count = departmentService.getAllRecords(myId,departmentId);
			String json= ActionUtil.getDepartmentGridJson(departmentList,count);
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
		Long myId = ActionUtil.getId(model.getId());
		Department department = null;
		/*if(myId != null){
			department = departmentService.findEntity(myId);
			Long typeId = department.getType().getId();
			if(typeId == 2l){
				//articleService.findChildren(myId);
			}else{
				departmentMethod1(myId);
			}
		}else{
			departmentMethod1(myId);
		}*/
		departmentMethod1(myId);
		
		return null;
	}
	
	private void departmentMethod1(Long myId) throws Exception{
		List<Department> departmentList = departmentService.findChildren(myId);
		String json = ActionUtil.getDepartmentJson(departmentList);
		response.getWriter().write(json);
	}
	
	private DepartmentHelp Temp(){
		Department department = new Department();
		department.setId(null);
		department.setParent(null);
		department.setText("开发部");
		Type type = new Type();
		type.setId(2l);
		type.setName("IT");
		type.setParent(null);
		type.setViewAlias("departmentView");
		
		typeService.saveEntity(type);
		
		department.setType(type);
		
		
		DepartmentHelp departmentHelp = new DepartmentHelp();
		departmentHelp.setDepartmentId("1");
		departmentHelp.setDepartmentIds("2");
		departmentHelp.setId("root");
		departmentHelp.setTypeName("root");
		departmentHelp.setLeaf(false);
		departmentHelp.setLimit("20");
		departmentHelp.setNodeName("研发一部");
		departmentHelp.setPage("1");
		departmentHelp.setText("部门");
		departmentHelp.setType(type);
		departmentHelp.setStart("1");
		departmentHelp.setParentName("root");
		departmentHelp.setParent(department);
		Set<Department> setDepartment = new HashSet<Department>();
		setDepartment.add(department);
		departmentHelp.setDeptSet(setDepartment);
		return departmentHelp;
	}

	public String setTreeSave() throws Exception {
		
		//model = Temp();
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		System.out.println("11111111111111");
		Long id = ActionUtil.getId(model.getTypeName());
		Type type = typeService.findEntity(id);
		Department department = new Department();
		department.setText(model.getNodeName());
		department.setType(type);
		department.setLeaf(false);
		try {
			if (model.getParentName().equals("root")) {
				department.setParent(null);
				departmentService.saveEntity(department);
			} else {
				Long parentId = ActionUtil.getId(model.getParentName());
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
}
