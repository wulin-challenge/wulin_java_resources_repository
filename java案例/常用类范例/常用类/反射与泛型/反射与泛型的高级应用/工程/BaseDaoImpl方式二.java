package wulin.online.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import wulin.online.base.BaseDao;

@SuppressWarnings("unchecked")
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	public BaseDaoImpl(){
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();//得到带有泛型参数的字节码对象
		this.clazz=(Class<T>) pt.getActualTypeArguments()[0];//得到第一个泛型参数的真实字节码对象
		
		System.out.println("clazz = "+clazz.getName());
	}
	
	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity); 
	}

	public void delete(Long id) {
		Object obj=getSession().get(clazz, id);
		getSession().delete(obj);
	}

	public List<T> findAll() {
		return getSession().createQuery("FROM "+clazz.getSimpleName()).list();
	}

	public T getById(Long id) {
		return (T) getSession().get(clazz,id);
	}

	public List<T> getByIds(Long[] ids) {
		if(ids==null || ids.length==0){
			//return new ArrayList<T>(); 或
			return Collections.EMPTY_LIST; //返回一个空集合
		}
		return getSession().createQuery("FROM "+clazz.getSimpleName()+" WHERE id IN(:ids) ").setParameterList("ids", ids).list();
	}
	
	/**获取当前可以的session*/
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}
