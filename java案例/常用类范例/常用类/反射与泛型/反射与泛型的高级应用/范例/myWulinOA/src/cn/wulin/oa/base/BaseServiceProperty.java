package cn.wulin.oa.base;

import javax.annotation.Resource;

import cn.wulin.oa.dao.DepartmentDao;
import cn.wulin.oa.dao.RoleDao;
import cn.wulin.oa.dao.UserDao;

public class BaseServiceProperty {

	@Resource	
	protected DepartmentDao departmentDao ;
	@Resource
	protected UserDao userDao;
	@Resource
	protected RoleDao roleDao;
	
}
