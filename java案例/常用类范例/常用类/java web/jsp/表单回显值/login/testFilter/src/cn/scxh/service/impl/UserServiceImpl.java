package cn.scxh.service.impl;

import java.util.List;

import cn.scxh.dao.impl.UserDaoImpl;
import cn.scxh.dao.intf.UserDao;
import cn.scxh.model.User;
import cn.scxh.service.intf.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void register(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.insert(user);
	}

	@Override
	public List<User> getUsers(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUserList(user);
	}

	@Override
	public User getUser(String id) {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUserById(id);
	}

}
