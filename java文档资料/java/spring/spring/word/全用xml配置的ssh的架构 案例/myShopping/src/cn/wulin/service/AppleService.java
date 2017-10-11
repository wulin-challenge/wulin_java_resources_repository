package cn.wulin.service;

import java.util.List;

import cn.wulin.base.BaseService;
import cn.wulin.domain.Apple;

public interface AppleService extends BaseService<Apple>{
	public List<Apple> findChildrenByTree(Long TreeId);
}
