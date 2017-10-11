package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.AuthorDao;
import cn.wulin.domain.Author;
import cn.wulin.service.AuthorService;

public class AuthorServiceImpl extends BaseServiceImpl<Author,AuthorDao> implements AuthorService{

	public AuthorDao authorDao;
	
	//----set and get-------

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
}
