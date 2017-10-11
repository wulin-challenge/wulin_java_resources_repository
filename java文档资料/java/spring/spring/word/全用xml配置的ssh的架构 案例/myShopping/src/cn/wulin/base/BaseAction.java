package cn.wulin.base;

import cn.wulin.service.AddressService;
import cn.wulin.service.AppleService;
import cn.wulin.service.ArticleService;
import cn.wulin.service.AuthorService;
import cn.wulin.service.DepartmentService;
import cn.wulin.service.TestService;
import cn.wulin.service.TreeService;
import cn.wulin.service.TypeService;
import cn.wulin.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction<T> extends ActionSupport{

	private static final long serialVersionUID = 9112904191505268491L;
	protected TestService testService;
	protected DepartmentService departmentService;
	protected TypeService typeService;
	protected UserService userService;
	protected AddressService addressService;
	protected ArticleService articleService;
	protected AuthorService authorService;
	protected TreeService treeService;
	protected AppleService appleService;
	
	//-------set and get-----------
	
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public TypeService getTypeService() {
		return typeService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public AuthorService getAuthorService() {
		return authorService;
	}
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	public TreeService getTreeService() {
		return treeService;
	}
	public void setTreeService(TreeService treeService) {
		this.treeService = treeService;
	}
	public AppleService getAppleService() {
		return appleService;
	}
	public void setAppleService(AppleService appleService) {
		this.appleService = appleService;
	}
}
