package cn.xh.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.xh.dao.intf.UserDao;
import cn.xh.domain.User;
import cn.xh.service.intf.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	public void addUser(User user) {
		logger.error("-------------------添加任务是出错了----------------");
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

	
	public User getById(Long id) {
		return this.userDao.getById(id);
	}
	
	//---------
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
