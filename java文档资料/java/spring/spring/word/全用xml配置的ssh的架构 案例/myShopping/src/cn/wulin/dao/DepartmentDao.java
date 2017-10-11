package cn.wulin.dao;

import java.util.List;

import cn.wulin.base.BaseDao;
import cn.wulin.domain.Department;

public interface DepartmentDao extends BaseDao<Department>{
	
	/**
	 * 查找所有顶级部门
	 * @return
	 */
	public List<Department> findAllTop();
	
	/**
	 * 查找所有下一级部门
	 * @return
	 */
	public List<Department> findChildren(Long id);
	
	/**
	 * 分页查询下一级部门
	 * @param id
	 * @param first
	 * @param max
	 * @return
	 */
	public List<Department> findPage(Long id,int first,int max,Long query);
	
	/**
	 * 得到所有记录数
	 * @param id
	 * @return
	 */
	public int getAllRecords(Long id,Long query);
}
