package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.ArticleDao;
import cn.wulin.domain.Article;
import cn.wulin.service.ArticleService;

public class ArticleServiceImpl extends BaseServiceImpl<Article,ArticleDao> implements ArticleService{

	public ArticleDao articleDao;
	
	//----set and get-------

	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	
}
