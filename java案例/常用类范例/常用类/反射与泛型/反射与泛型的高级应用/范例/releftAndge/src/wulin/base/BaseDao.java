package wulin.base;

public interface BaseDao<T> {
	
	public void save(T entity);
	public T findAll();

}
