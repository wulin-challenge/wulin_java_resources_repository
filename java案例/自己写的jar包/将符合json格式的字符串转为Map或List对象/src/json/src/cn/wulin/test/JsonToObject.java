package cn.wulin.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.wulin.exception.JsonConversionException;

public class JsonToObject {
	
	/**
	 * 将符合json格式字符串转换为Map<String,Object>对象或List<Object>对象
	 * @param json
	 * @return:得到一个Map对象或者List对象,否则返回为null
	 */
	public Object jsonToMapOrList(String json){
		String judge = this.jsonIsArrOrObj(json);
		if(judge == null){
			try {
				throw new JsonConversionException("json 字符串为null或为 \"\"");
			} catch (JsonConversionException e) {
				e.printStackTrace();
			}
		}
		if("array".equals(judge)){
			JSONArray jsonArray = JSONArray.fromObject(json);
			return this.jsonToList(jsonArray);
		}
		if("object".equals(judge)){
			JSONObject jsonObject = JSONObject.fromObject(json);
			return this.jsonToMap(jsonObject);
		}
		if("error".equals(judge)){
			try {
				throw new JsonConversionException("json 字符串的格式错误!!");
			} catch (JsonConversionException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 判断该json字符串是否为数组或对象
	 * @param json
	 * @return :1.如果该json字符串是数组,则返回"array"
	 * 			2.如果该json字符串是对象,则放回"object"
	 * 			3.如果该json字符串既不是数组,也不是对象,则返回"error"
	 * 			4.如果该json字符串是null,则返回null
	 */
	private String jsonIsArrOrObj(String json){
		if(json == null || "".equals(json)){
			return null;
		}
		if(json.trim().startsWith("[{")){
			try {
				JSONArray.fromObject(json);
				return "array";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		if(json.trim().startsWith("{")){
			try {
				JSONObject.fromObject(json);
				return "object";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		if(!json.trim().startsWith("[{") && !json.trim().startsWith("{")){
			return "error";
		}
		return "error";
	}
	
	/**
	 * 将JSONObject对象转为Map对象
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> jsonToMap(JSONObject json){
		Map<String,Object> columnValMap = new HashMap<String,Object>();
		Set<Object> jsonKeys = json.keySet();
		for (Object key : jsonKeys) {
			Object JsonValObj = json.get(key);
			if(JsonValObj instanceof JSONArray){
				columnValMap.put((String)key,jsonToList((JSONArray) JsonValObj));
			}else if(key instanceof JSONObject){
				columnValMap.put((String)key, jsonToMap((JSONObject) JsonValObj));
			}else{
				columnValMap.put((String)key, JsonValObj);
			}
		}
		 return columnValMap; 
	 }
	
	/**
	 * 将JSONArray数组对象转为List对象
	 * @param jsonArr
	 * @return
	 */
	private Object jsonToList(JSONArray jsonArr){
		List<Object> jsonObjList = new ArrayList<Object>();
		for(Object obj:jsonArr){
			if(obj instanceof JSONArray){
				jsonObjList.add(jsonToList((JSONArray)obj));
			}else if(obj instanceof JSONObject){
				jsonObjList.add(jsonToMap((JSONObject)obj));
			}else{
				jsonObjList.add(obj);
			}
		}
		return jsonObjList;
	}
}
