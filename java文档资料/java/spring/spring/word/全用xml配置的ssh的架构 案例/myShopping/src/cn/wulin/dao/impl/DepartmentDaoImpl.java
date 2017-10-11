package cn.wulin.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;

import cn.wulin.base.impl.BaseDaoImpl;
import cn.wulin.dao.DepartmentDao;
import cn.wulin.domain.Department;

@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	
	public List<Department> findAllTop() {
		return this.getMySession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
	}

	public List<Department> findChildren(Long id) {
		List<Department> departmentList = null;
		if(id == null){
			departmentList = this.getMySession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
		}else{
			departmentList = this.getMySession().createQuery("FROM Department d WHERE d.parent.id=:id").setParameter("id", id).list();
		}
		return departmentList;
	}

	public List<Department> findPage(Long id,int first,int max,Long query) {
		List<Department> departmentList = null;
		String hql = "FROM Department d WHERE d.parent.id=:id";
		try {
			if(query != null){
				hql = hql + " AND d.id="+query;
			}
			departmentList = this.getSession().createQuery(hql)
			.setParameter("id",id)
			.setFirstResult(first)
			.setMaxResults(max)
			.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return departmentList;
	}

	public int getAllRecords(Long id,Long query) {
		Long count = null;
		String hql = "SELECT count(id) FROM Department d WHERE d.parent.id=:id";
		try {
			if(query != null){
				hql = hql + " AND d.id="+query;
			}
			count = (Long) this.getSession().createQuery(hql)
			.setParameter("id", id)
			.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}
}
