package cn.wulin.service.impl;

import java.util.List;

import cn.wulin.dao.UserDao;
import cn.wulin.domain.User;
import cn.wulin.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public User findByUsernameAndPassword(User user) {
		return userDao.findByUsernameAndPassword(user);
	}
	

	public void deleteEntity(Long id) {
		userDao.deleteEntity(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findEntity(Long id) {
		return userDao.findEntity(id);
	}

	public void saveEntity(User entity) {
		 userDao.saveEntity(entity);
	}

	public void updateEntity(User entity) {
		userDao.updateEntity(entity);
	}
	//-------------set and get method--------
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
