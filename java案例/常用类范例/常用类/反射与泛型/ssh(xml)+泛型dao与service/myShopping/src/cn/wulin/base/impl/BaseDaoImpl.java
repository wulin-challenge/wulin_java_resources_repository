package cn.wulin.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.wulin.base.BaseDao;
import cn.wulin.domain.Test;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateTemplate implements BaseDao<T>{
	private Class clazz;
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz  = (Class) type.getActualTypeArguments()[0];
	}

	public void deleteEntity(Long id) {
		this.get(clazz, id);
	}

	public List<T> findAll() {
		return this.getSessionFactory().getCurrentSession().createQuery("FROM "+clazz.getSimpleName())
		.list();
	}

	public T findEntity(Long id) {
		return (T) this.getSessionFactory().getCurrentSession().createQuery("FROM "+clazz.getSimpleName()+" WHERE id=:id")
		.setParameter("id", id)
		.uniqueResult();
		
	}

	public void saveEntity(T entity) {
		this.save(entity);
		Test test = new Test();
		test.setName("xixi");
		int i= 1/0;
		test.setAge(24);
		this.save(test);
	}
	

	public void updateEntity(T entity) {
		this.update(entity);
	}

	/**
	*得到session
	*/
	public Session getMySession(){
		return this.getSessionFactory().getCurrentSession();
	}

}
