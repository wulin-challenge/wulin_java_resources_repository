package cn.xh.service.impl;

import cn.xh.dao.intf.UserDao;
import cn.xh.domain.User;
import cn.xh.service.intf.UserService;

public class UserServiceImpl implements UserService{

	private UserDao UserDao;
	
	public void addUser(User user) {
		this.UserDao.addUser(user);
	}

	public UserDao getUserDao() {
		return UserDao;
	}

	public void setUserDao(UserDao userDao) {
		UserDao = userDao;
	}
	
	//---------
	
	

}
