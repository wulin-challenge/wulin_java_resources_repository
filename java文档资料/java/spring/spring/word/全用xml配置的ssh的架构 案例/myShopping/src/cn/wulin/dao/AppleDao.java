package cn.wulin.dao;

import java.util.List;

import cn.wulin.base.BaseDao;
import cn.wulin.domain.Apple;

public interface AppleDao extends BaseDao<Apple>{
	
	public List<Apple> findChildrenByTree(Long TreeId);

}
