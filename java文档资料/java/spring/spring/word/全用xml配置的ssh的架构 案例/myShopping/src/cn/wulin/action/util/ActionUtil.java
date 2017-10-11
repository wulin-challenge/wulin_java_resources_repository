package cn.wulin.action.util;

import java.util.List;

import cn.wulin.action.util.help.DepartmentHelp;
import cn.wulin.domain.Department;

public class ActionUtil{
	
	/**
	 * 得到jsonTree
	 * @param departmentList
	 * @return
	 */
	/*public static String getDepartmentJson(List<Department> departmentList){
		String json = null;
		DepartmentHelp help = new DepartmentHelp();
		json = help.getJson(departmentList);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"deptSet","parent"});
		JSONArray departmentJson = JSONArray.fromObject(departmentList, config);
		json = departmentJson.toString();
		return json;
	}*/
	
	/*
	 * 得到Long[]
	 */
	public static Long[] getLongArray(String parameter){
		String[] arrays= parameter.split(",");
		Long[] parameters = new Long[arrays.length];
		for (int i=0;i<arrays.length;i++) {
			parameters[i] = Long.valueOf(arrays[i]);
		}
		return parameters;
	}
	
	/**
	 * 得到json字符串
	 */
	public static String getDepartmentGridJson(List<Department> departmentList,int count){
		DepartmentHelp help = new DepartmentHelp();
		String json = help.getDepartmentGridJson(departmentList,count);
		if(json == null){
			json = "";
		}
		return json;
	}
	
	/**
	 * 得到json字符串
	 * @param departmentList
	 * @return
	 */
	public static String getDepartmentJson(List<Department> departmentList){
		DepartmentHelp help = new DepartmentHelp();
		String json = help.getJson(departmentList);
		if(json == null){
			json = "";
		}
		return json;
	}
	
	/**
	 * 将字符串转换为Long数
	 * @param id
	 * @return
	 */
	public static Long getId(String id){
		Long myId = null;
		if(!id.equals("root")){
			myId = Long.valueOf(id);
		}
		return myId;
	}
	
	/**
	 * 将字符串转换为整形参数
	 * @param s
	 * @return
	 */
	public static int getInt(String s){
		int i= 0;
		if(s != null){
			i = Integer.parseInt(s);
		}
		return i;
	}
}
