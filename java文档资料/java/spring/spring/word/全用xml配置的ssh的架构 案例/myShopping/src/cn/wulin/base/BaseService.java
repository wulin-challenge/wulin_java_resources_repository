package cn.wulin.base;

import java.util.List;

public interface BaseService<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	public void saveEntity(T entity);
	/**
	 * 更新实体
	 * @param entity
	 */
	public void updateEntity(T entity);
	/**
	 * 根据id删除实体
	 * @param id
	 */
	public void deleteEntity(Long id);
	/**
	 * 查找所有实体
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 根据id查找实体
	 * @param id
	 * @return
	 */
	public T findEntity(Long id);
	
	/**
	 * 根据ids查找实体
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Long[] ids);
}
