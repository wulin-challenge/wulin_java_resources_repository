package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.TreeDao;
import cn.wulin.domain.Tree;
import cn.wulin.service.TreeService;

public class TreeServiceImpl extends BaseServiceImpl<Tree,TreeDao> implements TreeService{
	public TreeDao treeDao;

	public Tree findEntity(Long id) {
		return treeDao.findEntity(id);
	}

	//---------set and get ----
	public TreeDao getTreeDao() {
		return treeDao;
	}

	public void setTreeDao(TreeDao treeDao) {
		this.treeDao = treeDao;
	}
}
