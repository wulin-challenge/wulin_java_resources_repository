package cn.wulin.oa.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wulin.oa.base.BaseServiceImpl;
import cn.wulin.oa.dao.DepartmentDao;
import cn.wulin.oa.domain.Department;
import cn.wulin.oa.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl extends BaseServiceImpl<Department,DepartmentDao> implements DepartmentService {

	/*@Resource
	private DepartmentDao departmentDao;

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	public void save(Department department) {
		departmentDao.save(department);
	}

	public void update(Department department) {
		departmentDao.update(department);
	}*/

}
