package cn.wulin.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.util.JSONUtils;
import net.sf.json.xml.JSONTypes;

public class JsonToObject {


	public static void main(String[] args) {
		JsonToObject jsonTest = new JsonToObject();
		String jsonObject  = jsonTest.getJsonObjectString();
		String jsonArray = jsonTest.getJsonArrayString();
		//JSONObject jsonObj = jsonTest.jsonToJavaObject(jsonObject);
//		Map<String,Object> jsonMap = jsonTest.JsonToMap(jsonObj);
//		List<Object> listObj = (List<Object>) jsonMap.get("passports");
//		for (Object object : listObj) {
//			Map<String,Object> jsonMap1 = (Map<String, Object>) object;
//			System.out.println(jsonMap1.get("name"));
//		}
//		System.out.println(jsonMap.get("lendperson"));
		//JSONUtils.isObject(obj)
		JSONObject jsonObject2 = null;
		JSONArray jsonArray2 = null;
		Object json = null;
		try {
			json = JSONArray.fromObject(jsonArray);
		} catch (Exception e) {
			json = JSONObject.fromObject(jsonArray);
		}
		if(json instanceof JSONObject){
			System.out.println("object");
		}else if(json instanceof JSONArray){
			System.out.println("array");
			
		}else{
			System.out.println("格式错误");
		}
		
		//System.out.println(json.isArray());
		
		
		
		
	}
			
	
	public JSONObject jsonToJavaObject(String json){
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject;
	}
	
	public JSONArray jsonToJavaArray(String json){
		JSONArray jsonArray = JSONArray.fromObject(json);
		return jsonArray;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> JsonToMap(JSONObject json){
		Map<String,Object> columnValMap = new HashMap<String,Object>();
		Set<Object> jsonKeys = json.keySet();
		for (Object key : jsonKeys) {
			Object JsonValObj = json.get(key);
			if(JsonValObj instanceof JSONArray){
				columnValMap.put((String)key,JsonToList((JSONArray) JsonValObj));
			}else if(key instanceof JSONObject){
				columnValMap.put((String)key, JsonToMap((JSONObject) JsonValObj));
			}else{
				columnValMap.put((String)key, JsonValObj);
			}
		}
		 return columnValMap; 
	 }
	
	public Object JsonToList(JSONArray jsonArr){
		List<Object> jsonObjList = new ArrayList<Object>();
		for(Object obj:jsonArr){
			if(obj instanceof JSONArray){
				jsonObjList.add(JsonToList((JSONArray)obj));
			}else if(obj instanceof JSONObject){
				jsonObjList.add(JsonToMap((JSONObject)obj));
			}else{
				jsonObjList.add(obj);
			}
		}
		return jsonObjList;
	}
		
	public String getJsonObjectString(){
		String json = "{\"lendperson\":\"李四\",\"lendcompany\":\"有限公司\",\"checkperson\":\"李四\",\"lenddate\":\"2010-07-19T00:00:00\"," +
				"\"lendcounts\":4,\"passports\":[{\"passportid\":\"d\",\"name\":\"李豫川\",\"passporttype\":\"K\"},{\"passportid\":\"K9051\"," +
				"\"name\":\"李平\",\"passporttype\":\"K\"},{\"passportid\":\"K90517\",\"name\":\"袁寒梅\",\"passporttype\":\"K\"}," +
				"{\"passportid\":\"K905199\",\"name\":\"贺明\",\"passporttype\":\"K\"}]}";
		return json;
	}
	
	public String getJsonArrayString(){
		
		return "["+this.getJsonObjectString()+","+this.getJsonObjectString()+","+this.getJsonObjectString()+"]";
	}
	
	
}
