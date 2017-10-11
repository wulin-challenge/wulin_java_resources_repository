package cn.scxh.action;

import cn.scxh.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionParameter extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = -2181075254943519009L;
	
	User user=new User();
	
	public String getParameter() throws Exception {
		return "success";
	}
	
	public void getValue(){
		System.out.println(user.getId()+" "+user.getName()+" "+user.getPassword()+" "+user.getHappy()+" "+user.getStudent().getId()+" "+user.getCity());
	}

	public User getModel() {
		return user;
	}

	
}
