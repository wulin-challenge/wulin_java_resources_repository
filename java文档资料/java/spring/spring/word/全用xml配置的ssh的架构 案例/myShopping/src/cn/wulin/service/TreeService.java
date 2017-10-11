package cn.wulin.service;

import cn.wulin.base.BaseService;
import cn.wulin.domain.Tree;

public interface TreeService extends BaseService<Tree>{

	public Tree findEntity(Long treeId);
}
