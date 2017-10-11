package cn.wulin.base.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import cn.wulin.base.BaseDao;
import cn.wulin.base.BaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T,K> implements BaseService<T>{
	
	private K commonDao;
	private Class<K> clazz;
	
	protected BaseServiceImpl(){
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz=(Class<K>) pt.getActualTypeArguments()[1];
	}
	
	public void getCommonDao(){
		Field[] field=this.getClass().getDeclaredFields();
		try {
			for (Field field2 : field) {
				if(field2.getType()==clazz){
					System.out.println(field2.get(this));
					this.commonDao=(K) field2.get(this);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	

	public void deleteEntity(Long id) {
		if(commonDao == null){
			this.getCommonDao();
		}
		try {
		Method[] methods = commonDao.getClass().getMethods();
		for (Method method : methods) {
			if(method.getName().equals("deleteEntity")){
				method.invoke(commonDao, id);
				break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public List<T> findAll() {
		List<T> entityList = null;
		if(commonDao == null){
			this.getCommonDao();
		}
		try {
		Method[] methods = commonDao.getClass().getMethods();
		int i=0;
		for (Method method : methods) {
			i++;
			System.out.println("--------");
			if(method.getName().equals("findAll")){
				System.out.println(i);
				entityList = (List<T>) method.invoke(commonDao);
				break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return entityList;
	}

	public T findEntity(Long id) {
		T entity = null;
		if(commonDao == null){
			this.getCommonDao();
		}
		try {
		Method[] methods = commonDao.getClass().getMethods();
		for (Method method : methods) {
			if(method.getName().equals("findEntity")){
				entity = (T) method.invoke(commonDao, id);
				break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return entity;
	}

	public void saveEntity(T entity) {
		if(commonDao == null){
			this.getCommonDao();
		}
		try {
			//Method method = commonDao.getClass().getSuperclass().getDeclaredMethod("saveEntity", entity.getClass());
			/*Method method = commonDao.getClass().getMethod("saveEntity");
			method.invoke(commonDao);*/
			//Method method = commonDao.getClass().
			
		Method[] methods = commonDao.getClass().getMethods();
		int i=0;
		for (Method method : methods) {
			i++;
			if(method.getName().equals("saveEntity")){
				System.out.println(i);
				method.invoke(commonDao, entity);
				break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateEntity(T entity) {
		if(commonDao == null){
			this.getCommonDao();
		}
		try {
		Method[] methods = commonDao.getClass().getMethods();
		for (Method method : methods) {
			if(method.getName().equals("updateEntity")){
				method.invoke(commonDao, entity);
				break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
