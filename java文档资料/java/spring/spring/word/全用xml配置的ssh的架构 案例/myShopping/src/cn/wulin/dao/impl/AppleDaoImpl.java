package cn.wulin.dao.impl;

import java.util.List;

import cn.wulin.base.impl.BaseDaoImpl;
import cn.wulin.dao.AppleDao;
import cn.wulin.domain.Apple;

public class AppleDaoImpl extends BaseDaoImpl<Apple> implements AppleDao{

	public List<Apple> findChildrenByTree(Long TreeId){
		String hql = "FROM Apple apple WHERE (SELECT a.id FROM Apple a WHERE a.tree.id = ?) = apple.parent.id";
		return null;
	}
}
