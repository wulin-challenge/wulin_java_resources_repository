package cn.wulin.dao;

import cn.wulin.base.BaseDao;
import cn.wulin.domain.Tree;


public interface TreeDao extends BaseDao<Tree>{

	public Tree findEntity(Long treeId);
}
