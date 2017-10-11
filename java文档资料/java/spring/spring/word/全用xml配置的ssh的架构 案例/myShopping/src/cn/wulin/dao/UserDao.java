package cn.wulin.dao;

import cn.wulin.base.BaseDao;
import cn.wulin.domain.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 通过用户名与密码查找用户
	 * @return
	 */
	public User findByUsernameAndPassword(User user);
}
