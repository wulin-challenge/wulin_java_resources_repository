package cn.wulin.service;

import cn.wulin.base.BaseService;
import cn.wulin.domain.User;

public interface UserService extends BaseService<User>{

	/**
	 * 通过用户名与密码查找用户
	 * @return
	 */
	public User findByUsernameAndPassword(User user);
}
