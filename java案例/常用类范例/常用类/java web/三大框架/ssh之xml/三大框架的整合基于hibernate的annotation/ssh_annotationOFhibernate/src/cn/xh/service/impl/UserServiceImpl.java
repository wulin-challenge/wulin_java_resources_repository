package cn.xh.service.impl;

import java.util.List;

import cn.xh.dao.intf.UserDao;
import cn.xh.domain.User;
import cn.xh.service.intf.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public void addUser(User user) {
		this.userDao.addUser(user);
	}

	public void editUser(User user) {
		this.userDao.editUser(user);
	}

	public List<User> findAllUser() {
		return this.userDao.findAllUser();
	}

	public void remove(Long id) {
		this.userDao.remove(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getById(Long id) {
		return this.userDao.getById(id);
	}
	
	//---------
	
	

}
