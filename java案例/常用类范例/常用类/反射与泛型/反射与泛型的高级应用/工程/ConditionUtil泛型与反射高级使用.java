package wulin.information.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import wulin.information.domain.User;

public final class ConditionUtil {

	private static List<Object> objectList=new ArrayList<Object>();
	/*public static String getSql(User user){
		String sql=null;
		sql="select * from t_user where 1=1 "+getCondition(user)+" limit ?,?";
		System.out.println(sql);
		
		return sql;
	}*/
	
	public static <T> String getSql(T entity,String tableName){
		String sql=null;
		sql="select * from "+tableName+" where 1=1 "+getCondition(entity)+" limit ?,?";
		System.out.println(sql);
		
		return sql;
	}
	
	public static <T> String getCondition(T entity){
		String condition="";
		
		Field[] field=entity.getClass().getDeclaredFields();
		for (Field f : field) {
			String name=f.getName();
			String firstString=name.substring(0,1).toUpperCase();
			name="get"+firstString+name.substring(1, name.length());
			try {
				if(!isEmpty(entity.getClass().getMethod(name).invoke(entity))){
					condition=condition+" and "+f.getName()+"=? ";
					objectList.add(entity.getClass().getMethod(name).invoke(entity));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return condition;
	}
	
	
	public static Object[] getObjectArray(Integer startRecord, Integer recordOfPer){
		Object[] object=new Object[objectList.size()+2];
		for (int i=0;i<objectList.size();i++) {
			object[i]=objectList.get(i);
		}
		object[objectList.size()]=startRecord;
		object[objectList.size()+1]=recordOfPer;
		objectList.clear();
		return object;
	}
	
	public static String getCountSql(User user,String tableName){
		String sql=null;
		sql="select count(*) from "+tableName+" where 1=1 "+getCondition(user);
		System.out.println(sql);
		return sql;
	}
	
	public static Object[] getCountObjectArray(){
		Object[] object=new Object[objectList.size()];
		for (int i=0;i<objectList.size();i++) {
			object[i]=objectList.get(i);
		}
		objectList.clear();
		return object;
	}
	
/*	public static String getCondition(User user){
		String condition="";
		if(!isEmpty(user.getId())){
			condition=condition+" and id=? ";
			objectList.add(user.getId());
		}
		if(!isEmpty(user.getUsername())){
			condition=condition+" and username=? ";
			objectList.add(user.getUsername());
		}
		if(!isEmpty(user.getGender())){
			condition=condition+" and gender=? ";
			objectList.add(user.getGender());
		}
		return condition;
	}*/
	
	public static boolean isEmpty(Object property){
		boolean flag=false;
		if(property==null){
			flag=true;
			return flag;
		}
		if(property instanceof String){
			if(property==null||property.equals("")){
				flag=true;
			}
		}
		
		if(property instanceof Integer){
			if(property==null){
				flag=true;
			}
		}
		return flag;
	}
}
