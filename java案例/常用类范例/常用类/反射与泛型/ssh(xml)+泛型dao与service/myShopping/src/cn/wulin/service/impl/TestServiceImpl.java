package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.TestDao;
import cn.wulin.domain.Test;
import cn.wulin.service.TestService;

public class TestServiceImpl extends BaseServiceImpl<Test,TestDao> implements TestService{

	public TestDao testDao;
	
	
	
	//------------

	public void saveEntity(Test entity) {
		testDao.saveEntity(entity);
	}

	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
}
