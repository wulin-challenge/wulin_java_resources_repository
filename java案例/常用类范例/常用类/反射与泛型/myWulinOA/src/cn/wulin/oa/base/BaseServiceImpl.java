package cn.wulin.oa.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public class BaseServiceImpl<T,K> extends BaseServiceProperty  implements BaseService<T> {
	
	private K commonDao;
	private Class<K> clazz;
	
	protected BaseServiceImpl(){
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz=(Class<K>) pt.getActualTypeArguments()[1];
	}
	
	public void getCommonDao(){
		Field[] field=BaseServiceProperty.class.getDeclaredFields();
		try {
			for (Field field2 : field) {
				if(field2.getType()==clazz){
					System.out.println(field2.get(this));
					commonDao=(K) field2.get(this);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void delete(Long id) {
		if(commonDao==null){
			getCommonDao();
		}
		BaseDao<T> baseDao=(BaseDao<T>) commonDao;
		baseDao.delete(id);
	}

	public List<T> findAll() {
		if(commonDao==null){
			getCommonDao();
		}
		BaseDao<T> baseDao=(BaseDao<T>) commonDao;
		return baseDao.findAll();
	}

	public T getById(Long id) {
		if(commonDao==null){
			getCommonDao();
		}
		BaseDao<T> baseDao=(BaseDao<T>) commonDao;
		return baseDao.getById(id);
	}

	public List<T> getByIds(Long[] ids) {
		if(commonDao==null){
			getCommonDao();
		}
		BaseDao<T> baseDao=(BaseDao<T>) commonDao;
		return baseDao.getByIds(ids);
	}

	public void save(T entity) {
		if(commonDao==null){
			getCommonDao();
		}
		BaseDao<T> baseDao=(BaseDao<T>) commonDao;
		baseDao.save(entity);
	}

	public void update(T entity) {
		if(commonDao==null){
			getCommonDao();
		}
		BaseDao<T> baseDao=(BaseDao<T>) commonDao;
		baseDao.update(entity);
	}
	
	

}
