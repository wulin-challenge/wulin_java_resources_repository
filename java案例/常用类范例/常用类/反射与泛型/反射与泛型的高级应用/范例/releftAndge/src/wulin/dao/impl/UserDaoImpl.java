package wulin.dao.impl;

import wulin.base.impl.BaseDaoImpl;
import wulin.domain.Role;
import wulin.domain.User;

public class UserDaoImpl extends BaseDaoImpl {
	public <E> UserDaoImpl(E entity) {
		super(entity);
	}

	public static void main(String[] args) {
		User user=new User();
		Role role=new Role();
		role.setId(2L);
		user.setId(1L);
		user.setUsername("hhahah");
		UserDaoImpl bdi=new UserDaoImpl(user);
		//bdi.save(user);
		bdi.findAll();
	}
}
