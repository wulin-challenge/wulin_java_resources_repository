package com.bjhy.criminal.search.timer.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 获取查询字段及值的工具类
 * @author wangbowen
 * @date 2015-12-10
 *
 */
public class FieldsValuesUtils {
	/**
	 * 获取Insert表的字段和字段值
	 * 
	 * @param map
	 *            Map<String, Object> 通过 Map("fields")获取字段 , Map("mark")获取占位符
	 *            Map("values")获取字段值
	 * @return
	 */
	public static   Map<String, Object> getInsertFieldsValues(Map<String, Object> map) {
		Map<String, Object> newMap = new HashMap<String, Object>();
		Set<String> fields = map.keySet();
		StringBuffer sb = new StringBuffer();
		StringBuffer sbValues = new StringBuffer();
		List<Object> values = new ArrayList<Object>();
		for (String field : fields) {
			values.add(map.get(field) != null ? map.get(field).toString(): null);
			sb.append(field + ",");
			sbValues.append("?,");
		}
		String fs = sb.substring(0, sb.length() - 1);
		String valueStr = sbValues.substring(0, sbValues.length() - 1);
		newMap.put("fields", fs);
		newMap.put("mark", valueStr);
		newMap.put("values", values);
		return newMap;
	}
	/**
	 * 获取Update表的字段和字段值
	 * 
	 * @param map
	 *            Map<String, Object> 通过 Map("fields")获取字段 , Map("values")获取字段值
	 * @return
	 */
	public static Map<String, Object> getUpdateFieldsValues(
			Map<String, Object> map) {
		Map<String, Object> newMap = new HashMap<String, Object>();
		Set<String> fields = map.keySet();
		StringBuffer sb = new StringBuffer();
		List<String> values = new ArrayList<>();
		for (String field : fields) {
		   values.add(map.get(field) != null ? map.get(field).toString(): null);
			sb.append(field + "=");
			sb.append("?,");
		}
		String fs = sb.substring(0, sb.length() - 1);
		newMap.put("fields", fs);
		newMap.put("values", values);
		return newMap;
	}
	/**
	 * 根据表名获取删除语句
	 * @param tableName 表名
	 * @return delete 语句
	 */
	public static String deleteTemplateSql(String tableName){
		  //删除模板sql
		return "delete  from "+tableName.toUpperCase();
	}
	
	/**
	 * 根据表名获取新增语句
	 * @param tableName 表名
	 * @return insert 语句
	 */
	public static String insertTemplateSql(String tableName){
		  //新增模板sql
		return "insert into "+tableName.toUpperCase()+"(#[fields]) values(#[values]) ";
	}
}
