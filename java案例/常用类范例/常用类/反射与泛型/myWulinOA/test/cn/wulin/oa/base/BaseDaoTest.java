package cn.wulin.oa.base;

import org.junit.Test;

import cn.wulin.oa.dao.RoleDao;
import cn.wulin.oa.dao.UserDao;
import cn.wulin.oa.dao.impl.RoleDaoImpl;
import cn.wulin.oa.dao.impl.UserDaoImpl;
import cn.wulin.oa.domain.Role;
import cn.wulin.oa.domain.User;

public class BaseDaoTest {


	@Test
	public void testGetById() {
		UserDao userDao = new UserDaoImpl();
		RoleDao roleDao = new RoleDaoImpl();

		User user = userDao.getById(1L);
		Role role = roleDao.getById(1L);
	}

}
