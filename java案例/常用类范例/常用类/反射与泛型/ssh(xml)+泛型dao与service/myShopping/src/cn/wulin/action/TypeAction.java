package cn.wulin.action;

import cn.wulin.service.TypeService;

import com.opensymphony.xwork2.ActionSupport;

public class TypeAction extends ActionSupport {

	private static final long serialVersionUID = 3691747684499355866L;
	private TypeService typeService;
	
	public String execute() throws Exception {
		return super.execute();
	}	
	
	//-------set and get------
	
	public TypeService getTypeService() {
		return typeService;
	}
	
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
}
