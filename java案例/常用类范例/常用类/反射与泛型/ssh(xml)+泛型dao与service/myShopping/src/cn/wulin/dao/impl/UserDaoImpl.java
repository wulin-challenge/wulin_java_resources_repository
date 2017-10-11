package cn.wulin.dao.impl;

import cn.wulin.base.impl.BaseDaoImpl;
import cn.wulin.dao.UserDao;
import cn.wulin.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User findByUsernameAndPassword(User user) {
		return (User) this.getMySession().createQuery("FROM User WHERE username=:username AND password=:password")
		.setParameter("username",user.getUsername())
		.setParameter("password",user.getPassword())
		.uniqueResult();
	}
	
	public void saveEntity(User entity) {
		this.save(entity);
	}
	
}
