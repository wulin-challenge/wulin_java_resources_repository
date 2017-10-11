package cn.xh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xh.dao.intf.UserDao;
import cn.xh.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	public void editUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUser() {
		List<User> userList=this.getSessionFactory().getCurrentSession().createQuery("FROM User").list();
		return userList;
	}

	public void remove(Long id) {
		Object entity=this.getHibernateTemplate().get(User.class, id);
		this.getHibernateTemplate().delete(entity);
	}

	public User getById(Long id) {
		User user=(User) this.getHibernateTemplate().get(User.class, id);
		return user;
	}

}
