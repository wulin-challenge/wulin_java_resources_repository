package cn.scxh.ittx.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.dao.impl.UserDaoImpl;
import cn.scxh.ittx.dao.intf.UserDao;
import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.intf.UserService;

public class UserServiceImpl implements UserService {

	public void addUser(User user) throws AddObjectException {
		UserDao userDao = new UserDaoImpl();
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddObjectException();
		}

	}

	public void deleteUserById(User user) throws DeleteObjectException {
		UserDao userDao = new UserDaoImpl();
		try {
			userDao.deleteUserById(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteObjectException();
		}
	}

	public List<User> queryUserById(User user) throws QueryObjectException {
		UserDao userDao = new UserDaoImpl();
		try {
			return userDao.queryUserById(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public List<User> queryUsers(User user) throws QueryObjectException {
		UserDao userDao = new UserDaoImpl();
		try {
			return userDao.queryUsers(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

	public void updateuserById(User user) throws UpdateObjectException {
		UserDao userDao = new UserDaoImpl();
		try {
			userDao.updateuserById(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateObjectException();
		}
	}

	public List<User> variousConditionQueryUsers(User user) throws QueryObjectException {
		UserDao userDao = new UserDaoImpl();
		try {
			return userDao.variousConditionQueryUsers(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
	}

}
