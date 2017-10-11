package cn.xh.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xh.dao.intf.UserDao;
import cn.xh.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

}
