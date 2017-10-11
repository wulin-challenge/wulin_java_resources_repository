package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.UserDao;
import cn.wulin.domain.User;
import cn.wulin.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService{

	public UserDao userDao;
	public User findByUsernameAndPassword(User user) {
		return userDao.findByUsernameAndPassword(user);
	}
	
	//-------------set and get method--------
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
