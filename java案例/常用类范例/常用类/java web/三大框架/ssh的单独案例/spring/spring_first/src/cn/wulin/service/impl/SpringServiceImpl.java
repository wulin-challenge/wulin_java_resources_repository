package cn.wulin.service.impl;

import cn.wulin.dao.intf.DatabaseDao;
import cn.wulin.service.intf.SpringService;

public class SpringServiceImpl implements SpringService{
	private DatabaseDao databaseDao;

	public DatabaseDao getDatabaseDao() {
		return databaseDao;
	}

	public void setDatabaseDao(DatabaseDao databaseDao) {
		this.databaseDao = databaseDao;
	}

	@Override
	public void save() {
		databaseDao.save();
		
	}
	
	
}
