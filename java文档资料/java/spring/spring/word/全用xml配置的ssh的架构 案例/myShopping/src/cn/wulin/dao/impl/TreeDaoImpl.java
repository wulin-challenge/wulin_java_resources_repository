package cn.wulin.dao.impl;

import cn.wulin.base.impl.BaseDaoImpl;
import cn.wulin.dao.TreeDao;
import cn.wulin.domain.Tree;

public class TreeDaoImpl extends BaseDaoImpl<Tree> implements TreeDao{

	public Tree findEntity(Long treeId) {
		return (Tree) this.getSessionFactory().getCurrentSession().createQuery("FROM Tree WHERE treeId=:treeId")
		.setParameter("treeId", treeId)
		.uniqueResult();
	}
}
