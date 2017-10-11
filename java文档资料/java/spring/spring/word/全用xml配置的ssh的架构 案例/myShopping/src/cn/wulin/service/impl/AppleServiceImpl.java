package cn.wulin.service.impl;

import java.util.List;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.AppleDao;
import cn.wulin.domain.Apple;
import cn.wulin.service.AppleService;

public class AppleServiceImpl extends BaseServiceImpl<Apple,AppleDao> implements AppleService{

	public AppleDao appleDao;
	
	public List<Apple> findChildrenByTree(Long TreeId) {
		return appleDao.findChildrenByTree(TreeId);
	}
	
	//-------set and get -----
	
	public AppleDao getAppleDao() {
		return appleDao;
	}
	public void setAppleDao(AppleDao appleDao) {
		this.appleDao = appleDao;
	}
}
