package cn.wulin.service.impl;

import java.util.List;

import cn.wulin.dao.TypeDao;
import cn.wulin.domain.Type;
import cn.wulin.service.TypeService;

public class TypeServiceImpl implements TypeService{

	private TypeDao typeDao;
	
	public void deleteEntity(Long id) {
		typeDao.deleteEntity(id);
	}

	public List<Type> findAll() {
		return typeDao.findAll();
	}

	public Type findEntity(Long id) {
		return typeDao.findEntity(id);
	}

	public void saveEntity(Type entity) {
		typeDao.saveEntity(entity);
	}

	public void updateEntity(Type entity) {
		typeDao.updateEntity(entity);
	}
	
	//----set and get--------
	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

}
