package cn.wulin.action;

import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Article;

public class ArticleAction extends ModelDrivenBaseAction<Article>{

	private static final long serialVersionUID = -1109153038279994439L;

	public String list() throws Exception {
		response.getWriter().write("{\"totalCount\":5,\"rows\":[{\"id\":101,\"title\":\"图书\",\"author\":\"部门管理\",\"clickNumber\":\"121212\",\"publishTime\":\"2014-10-13\",\"auditing\":true,\"publishPlace\":\"中国\"}]}");
		return null;
	}
	

}

