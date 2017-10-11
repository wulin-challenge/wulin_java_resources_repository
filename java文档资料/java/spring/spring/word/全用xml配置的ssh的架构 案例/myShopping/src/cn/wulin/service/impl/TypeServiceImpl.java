package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.TypeDao;
import cn.wulin.domain.Type;
import cn.wulin.service.TypeService;

public class TypeServiceImpl extends BaseServiceImpl<Type,TypeDao> implements TypeService{

	public TypeDao typeDao;
	
	//----set and get--------
	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

}
