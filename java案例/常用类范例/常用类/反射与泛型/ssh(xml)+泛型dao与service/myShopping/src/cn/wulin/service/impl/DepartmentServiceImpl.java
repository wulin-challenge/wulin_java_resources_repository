package cn.wulin.service.impl;

import java.util.List;

import cn.wulin.dao.DepartmentDao;
import cn.wulin.domain.Department;
import cn.wulin.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;

	public void deleteEntity(Long id) {
		departmentDao.deleteEntity(id);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public Department findEntity(Long id) {
		return departmentDao.findEntity(id);
	}

	public void saveEntity(Department entity) {
		departmentDao.saveEntity(entity);
	}

	public void updateEntity(Department entity) {
		departmentDao.updateEntity(entity);
	}
	
	public List<Department> findAllTop() {
		return departmentDao.findAllTop();
	}

	public List<Department> findChildren(Long id) {
		return departmentDao.findChildren(id);
	}

	public List<Department> findPage(Long id, int first, int max,Long query) {
		return departmentDao.findPage(id, first, max,query);
	}

	public int getAllRecords(Long id) {
		return departmentDao.getAllRecords(id);
	}

	//----set and get--------------

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
}
