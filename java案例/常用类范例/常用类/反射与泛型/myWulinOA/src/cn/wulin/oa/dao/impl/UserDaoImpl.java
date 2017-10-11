package cn.wulin.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.wulin.oa.base.BaseDaoImpl;
import cn.wulin.oa.dao.UserDao;
import cn.wulin.oa.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	// public UserDaoImpl(){
	// clazz = User.class;
	// }
}
