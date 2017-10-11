package cn.wulin.action;


import cn.wulin.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = -9185170319586583475L;
	private User user=new User();
	public String login() throws Exception {
		if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
			ActionContext.getContext().getSession().put("user",user);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String list() throws Exception {
		
		return "intercept";
	}
		
	
	
	
	
	public User getModel() {
		return user;
	}
	

}
