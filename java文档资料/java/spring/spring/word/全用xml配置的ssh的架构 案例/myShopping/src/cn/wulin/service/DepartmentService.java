package cn.wulin.service;

import java.util.List;

import cn.wulin.base.BaseService;
import cn.wulin.domain.Department;

public interface DepartmentService extends BaseService<Department>{

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
	
	/**
	 * 根据ids删除
	 * @param ids
	 */
	public void deletes(Long[] ids);
}
