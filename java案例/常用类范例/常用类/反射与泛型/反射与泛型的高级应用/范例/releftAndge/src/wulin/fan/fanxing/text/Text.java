package wulin.fan.fanxing.text;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import wulin.domain.User;

@SuppressWarnings("unchecked")
public class Text {
	
	private static List<Object> objectList=new ArrayList<Object>();
	public static <T> String getSql(T entity) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		String condition="";
	//	System.out.println(entity.getClass().getDeclaredFields()[0].getName());
		Field[] field=entity.getClass().getDeclaredFields();
		Method[] method=entity.getClass().getDeclaredMethods();
		int i=0;
		for (Field f : field) {
			String name=f.getName();
			String firstString=name.substring(0,1).toUpperCase();
			name="get"+firstString+name.substring(1, name.length());
			//System.out.println(name);
			
			
			if(!isEmpty(entity.getClass().getMethod(name).invoke(entity))){
				//System.out.println(entity.getClass().getMethod(name).invoke(entity));
				condition=condition+" and "+f.getName()+"=? ";
				System.out.println(condition);
				objectList.add(entity.getClass().getMethod(name).invoke(entity));
			}
		} 
		
			
		return null;
	}

	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Text text=new Text();
		User user=new User();
		user.setId(1l);
		//user.setDate(new Date());
		//user.setUsername("xixi");
		Text.getSql(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean isEmpty(String property){
		boolean flag=false;
		if(property==null||property.equals("")){
			flag=true;
		}
		return flag;
	}
	
	public static boolean isEmpty(Integer property){
		boolean flag=false;
		if(property==null){
			flag=true;
		}
		return flag;
	}
	public static boolean isEmpty(Object property){
		boolean flag=false;
		if(property==null){
			flag=true;
		}
		return flag;
	}
}
