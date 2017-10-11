package cn.xh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xh.dao.intf.UploadDao;
import cn.xh.domain.Upload;
import cn.xh.domain.User;

public class UploadDaoImpl extends HibernateDaoSupport implements UploadDao{

	public void addUpload(Upload upload) {
		this.getHibernateTemplate().save(upload);
	}

	@SuppressWarnings("unchecked")
	public List<Upload> findByUserUpload(User user) {
		List<Upload> uploadList=this.getSessionFactory().getCurrentSession()//
		.createQuery("FROM Upload u WHERE u.user=?")//
		.setParameter(0,user)
		.list();
		return uploadList;
	}

	public Upload getById(Long id) {
		return (Upload) this.getSessionFactory().getCurrentSession().get(Upload.class, id);
	}

	public void remove(Long id) {
		this.getSessionFactory().getCurrentSession().delete(this.getById(id));
	}

}
