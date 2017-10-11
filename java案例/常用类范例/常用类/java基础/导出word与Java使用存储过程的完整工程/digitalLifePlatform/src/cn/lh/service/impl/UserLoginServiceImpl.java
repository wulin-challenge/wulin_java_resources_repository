package cn.lh.service.impl;

import cn.lh.dao.UserLoginDao;
import cn.lh.dao.impl.UserLoginDaoImpl;
import cn.lh.domain.UserLogin;
import cn.lh.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService{

	public UserLogin findUserLogin1(String suid, String sess, String spid) {
		UserLoginDao dao = new UserLoginDaoImpl();
		return dao.findUserLogin1(suid, sess, spid);
	}

	public UserLogin findUserLogin2(String suid, String sess, String spid) {
		UserLoginDao dao = new UserLoginDaoImpl();
		return dao.findUserLogin2(suid, sess, spid);
	}

	public UserLogin findUserLogin3(String suid, String sess, String spid) {
		UserLoginDao dao = new UserLoginDaoImpl();
		return dao.findUserLogin3(suid, sess, spid);
	}

	public UserLogin findUserLogin4(String suid, String sess, String spid) {
		UserLoginDao dao = new UserLoginDaoImpl();
		return dao.findUserLogin4(suid, sess, spid);
	}

}
