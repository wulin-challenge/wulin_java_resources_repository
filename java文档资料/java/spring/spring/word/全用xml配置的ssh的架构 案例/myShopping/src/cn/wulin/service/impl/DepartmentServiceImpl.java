package cn.wulin.service.impl;

import java.util.List;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.DepartmentDao;
import cn.wulin.domain.Department;
import cn.wulin.service.DepartmentService;

public class DepartmentServiceImpl extends BaseServiceImpl<Department,DepartmentDao> implements DepartmentService {
	
	public DepartmentDao departmentDao;

	public List<Department> findAllTop() {
		return departmentDao.findAllTop();
	}

	public List<Department> findChildren(Long id) {
		return departmentDao.findChildren(id);
	}

	public List<Department> findPage(Long id, int first, int max,Long query) {
		return departmentDao.findPage(id, first, max,query);
	}

	public int getAllRecords(Long id,Long query) {
		return departmentDao.getAllRecords(id,query);
	}
	
	public void deletes(Long[] ids) {
		for (Long id : ids) {
			departmentDao.deleteEntity(id);
		}
	}

	//----set and get--------------

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
}
