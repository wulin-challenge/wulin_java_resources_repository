package wulin.base.impl;


import java.lang.reflect.Method;

import wulin.base.BaseDao;
import wulin.domain.User;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class<?> clazz;
	public BaseDaoImpl(T entity) {
		clazz=entity.getClass();
		System.out.println(clazz);
	}

	public T findAll() {
		
		return null;
	}

	public void save(T entity) {
		Method m=null;
		try {
			//System.out.println(entity.);
		System.out.println("----------"+entity.getClass().getMethod("getUsername")
				.invoke(entity));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(m);
	}
	public static void main(String[] args) {
		User user=new User();
		user.setId(1L);
		user.setUsername("haha");
		BaseDao<User> bdi=new BaseDaoImpl(user);
		bdi.save(user);
	}

}
