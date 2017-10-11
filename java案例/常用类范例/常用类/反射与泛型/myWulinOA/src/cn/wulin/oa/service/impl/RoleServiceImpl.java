package cn.wulin.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wulin.oa.base.BaseServiceImpl;
import cn.wulin.oa.dao.RoleDao;
import cn.wulin.oa.domain.Role;
import cn.wulin.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role,RoleDao> implements RoleService {

	/*@Resource
	private RoleDao roleDao;

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public void delete(Long id) {
		roleDao.delete(id);
	}

	public void save(Role role) {
		roleDao.save(role);
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.update(role);
	}
*/
}
