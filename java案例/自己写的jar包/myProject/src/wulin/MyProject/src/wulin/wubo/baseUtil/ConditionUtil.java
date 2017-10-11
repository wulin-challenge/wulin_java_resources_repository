package wulin.wubo.baseUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import wulin.wubo.baseDomain.Person;


@SuppressWarnings("unchecked")
public final class ConditionUtil<T> {
	
	private T entity;
	private List<String> stringList=null;
	private  static ConditionUtil conditionUtil;
	
	
	private ConditionUtil(T entity){
		this.entity=entity;
		this.stringList=ParseXmlUtil.getClassProperty(entity);
	}
	
	public synchronized static <T> ConditionUtil<T> getInstance(T entity){
		
			conditionUtil=new ConditionUtil<T>(entity);
		return conditionUtil;
	}
	
	public String getAddDataSql(){
		String name=null;
		String values=null;
		for(int i=1;i<stringList.size();i++){
			if(name==null){
				name=stringList.get(i);
			}else{
				name=name+","+stringList.get(i);
			}
			if(values==null){
				values="?";
			}else{
				values=values+","+"?";
			}
		}
		String sql="insert into "+stringList.get(0)+
				"("+name+") values("+values+")";
		return sql;
	}
	
	public Object[] getAddParameter(){
		
		Object[] parameter=new Object[stringList.size()-1];
		for(int i=1;i<stringList.size();i++){
			try {
				Field field=entity.getClass().getDeclaredField(stringList.get(i));
				String name=field.getName();
				String firstString=name.substring(0,1).toUpperCase();
				name="get"+firstString+name.substring(1, name.length());
				Object value=entity.getClass().getMethod(name).invoke(entity);
				parameter[i-1]=value;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return parameter;
	}
	
	public String getDeleteDataSql(){
		String name=null;
		name=stringList.get(0);
		String sql="delete from "+name+" where id=?";
		return sql;
	}
	
	public String getEditDataSql(){
		String tableField=null;
		for (int i=1;i<stringList.size();i++) {
			if(tableField==null){
				if(!stringList.get(i).equals("id")){
					tableField=stringList.get(i)+"=?";
				}
			}else{
				if(!stringList.get(i).equals("id")){
					tableField=tableField+","+stringList.get(i)+"=?";
				}
			}
		}
		if(tableField==null){
			tableField="";
		}
		String sql="update "+stringList.get(0)+" set "+tableField+" where id=?";
		return sql;
	}
	
	public Object[] getEditParameter(){
		Object[] parameter=new Object[stringList.size()-1];
		List<String> stringList2=new ArrayList<String>();
		String id=null;
		for(int i=1;i<stringList.size();i++){
			if(stringList.get(i).equals("id")){
				id=stringList.get(i);
			}else{
				stringList2.add(stringList.get(i));
			}
		}
		stringList2.add(id);
		int i=0;
		for (String name : stringList2) {
			try {
				String firstString=name.substring(0,1).toUpperCase();
				name="get"+firstString+name.substring(1, name.length());
				Object value=entity.getClass().getMethod(name).invoke(entity);
				parameter[i]=value;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			i++;
		}
		return parameter;
	}
	
	public String getFindAllSql(){
		String sql="select * from "+stringList.get(0);
		return sql;
	}
	public String getFindAllDataByConditonSql(){
		String name=null;
		String tableField=null;
		
		for(int i=1;i<stringList.size();i++){
			try {
				Field field=entity.getClass().getDeclaredField(stringList.get(i));
				name=field.getName();
				String firstString=name.substring(0,1).toUpperCase();
				name="get"+firstString+name.substring(1, name.length());
				Object value=entity.getClass().getMethod(name).invoke(entity);
				if(value!=null){
					if(value instanceof String){
						if(value!=""){
							if(tableField==null){
								tableField=" and "+stringList.get(i)+"=?";
							}else{
								tableField=tableField+" and "+stringList.get(i)+"=?";
							}
						}
					}else{
						if(tableField==null){
							tableField=" and "+stringList.get(i)+"=?";
						}else{
							tableField=tableField+" and "+stringList.get(i)+"=?";
						}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		name=stringList.get(0);
		if(tableField==null){
			tableField="";
		}
		String sql="select * from "+name+" where 1=1"+tableField+" limit ?,?";
		return sql;
	}
	
	public Object[] getFindAllDataByConditonParameter(Integer startPage,Integer recordOfPer){
		List<Object> stringList2=new ArrayList<Object>();
		String name=null;
		for(int i=1;i<stringList.size();i++){
			try {
				Field field=entity.getClass().getDeclaredField(stringList.get(i));
				name=field.getName();
				String firstString=name.substring(0,1).toUpperCase();
				name="get"+firstString+name.substring(1, name.length());
				Object value=entity.getClass().getMethod(name).invoke(entity);
				if(value!=null){
					if(value instanceof String){
						if(value!=""){
							stringList2.add(value);
						}
					}else{
						stringList2.add(value);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		Object[] parameter=new Object[stringList2.size()+2];
		int j=0;
		for (Object object : stringList2) {
			parameter[j]=object;
			j++;
		}
		parameter[stringList2.size()]=startPage;
		parameter[stringList2.size()+1]=recordOfPer;
		return parameter;
	}
	
	public String getFindDataByIdSql(){
		String name=stringList.get(0);
		String sql="select * from "+name+" where id=?";
		return sql;
	}
	
	public String getRecordCountByConditionSql(){
		String name=null;
		String tableField=null;
		for(int i=1;i<stringList.size();i++){
			try {
				Field field=entity.getClass().getDeclaredField(stringList.get(i));
				name=field.getName();
				String firstString=name.substring(0,1).toUpperCase();
				name="get"+firstString+name.substring(1, name.length());
				Object value=entity.getClass().getMethod(name).invoke(entity);
				if(value!=null){
					if(value instanceof String){
						if(value!=""){
							if(tableField==null){
								tableField=" and "+stringList.get(i)+"=?";
							}else{
								tableField=tableField+" and "+stringList.get(i)+"=?";
							}
						}
					}else{
						if(tableField==null){
							tableField=" and "+stringList.get(i)+"=?";
						}else{
							tableField=tableField+" and "+stringList.get(i)+"=?";
						}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		if(tableField==null){
			tableField="";
		}
		String sql="select count(*) from "+stringList.get(0)+" where 1=1"+tableField;
		return sql;
	}
	
	public Object[] getRecordCountByConditionParameter(){
		List<Object> stringList2=new ArrayList<Object>();
		String name=null;
		for(int i=1;i<stringList.size();i++){
			try {
				Field field=entity.getClass().getDeclaredField(stringList.get(i));
				name=field.getName();
				String firstString=name.substring(0,1).toUpperCase();
				name="get"+firstString+name.substring(1, name.length());
				Object value=entity.getClass().getMethod(name).invoke(entity);
				if(value!=null){
					if(value instanceof String){
						if(value!=""){
							stringList2.add(value);
						}
					}else{
						stringList2.add(value);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		Object[] parameter=new Object[stringList2.size()];
		int j=0;
		for (Object object : stringList2) {
			parameter[j]=object;
			j++;
		}
		return parameter;
	}
	
	public static void main(String[] args) {
		Person person=new Person();
		person.setGender("ÄÐ");
		person.setId(1);
		person.setName("haha");
		ConditionUtil condition=ConditionUtil.getInstance(person);
		System.out.println(condition.getRecordCountByConditionSql());
		Object[] object=(Object[]) condition.getRecordCountByConditionParameter();
		for (Object object2 : object) {
			System.out.println(object2);
			
		}
		
	}
}