package cn.wulin.action.util.help;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import cn.wulin.domain.Department;

public class DepartmentHelp {

	public String getJson(List<Department> departmentList) {
		String start = "[";
		String end = "]";
		String finish = "}";
		//String qtip = ",\"qtip\":";//type的id
		//String qtitle = ",\"qtitle\":";//type的viewAlias
		String rootId = ",\"rootId\":";
		String comma = ","; // 逗号
		String mark = "\""; //引号
		String json = null;
		try {
			for (Department department : departmentList) {
				String id = String.valueOf(department.getType().getId());
				//String viewAlias = department.getType().getViewAlias();
				JsonConfig config = new JsonConfig();
				config.setExcludes(new String[] { "deptSet", "parent", "type" });// 除去deptSet属性
				String departmentJson = JSONObject.fromObject(department, config).toString();
				departmentJson = departmentJson.substring(0, departmentJson.length()-1);
				//departmentJson = departmentJson+qtip+mark+id+mark+qtitle+mark+viewAlias+mark+finish;
				departmentJson = departmentJson+rootId+mark+id+mark+finish;
				if(json == null){
					json = departmentJson;
				}else{
					json = json+comma+departmentJson;
				}
				
			}
			json = start+json+end;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public String getDepartmentGridJson(List<Department> departmentList,int count){
		String begin = "{";
		String finish = "}";
		//String mark = "\"";
		String totalCount = "\"totalCount\":";
		String rows = "\"rows\":";
		String comma = ",";
		String json = null;
		if(departmentList != null && departmentList.size()>0){
			 json= this.getJson(departmentList);
		}else{
			json = "[]";
		}
		json = begin+totalCount+count+comma+rows+json+finish;
		return json;
	}

	/**
	 * 预留方法
	 * 
	 * @param departmentList
	 * @return
	 */
	public String getJsonPrepare(List<Department> departmentList) {
		String start = "[";
		String end = "]";
		String finish = "}";
		String children = ",\"children\":";
		String comma = ","; // 逗号
		String json = null;
		for (Department department : departmentList) {
			try {
				JsonConfig config = new JsonConfig();
				config.setExcludes(new String[] { "deptSet", "parent" });// 除去deptSet属性
				String departmentJson = JSONObject.fromObject(department,
						config).toString();

				if (department.getDeptSet() != null
						&& !department.getDeptSet().isEmpty()) {
					List<Department> deptList = new ArrayList<Department>(
							department.getDeptSet());
					String childrenJson = getJson(deptList);
					departmentJson = departmentJson.substring(0, departmentJson
							.length() - 1);
					departmentJson = departmentJson + children + childrenJson
							+ finish;
				}
				if (json == null) {
					json = departmentJson;
				} else {
					json = json + comma + departmentJson;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		json = start + json + end;
		return json;
	}
}
