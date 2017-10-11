package cn.xh.view.action;

import java.util.List;
import cn.xh.domain.User;
import cn.xh.service.intf.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = 9127778948368648816L;
	
	private UserService userService;
	private User model=new User();
	
	public String addUI() throws Exception {
		return "addUI";
	}
	
	public String add() throws Exception {
		userService.addUser(model);
		return "toList";
	}
	public String editUI() throws Exception {
		User user=userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "editUI";
	}
	public String edit() throws Exception {
		User user=userService.getById(model.getId());
		if(model.getPassword()!=null&&!model.getPassword().equals("")){
			user.setPassword(model.getPassword());
		}
		user.setName(model.getName());
		userService.editUser(user);
		return "toList";
	}
	public String remove() throws Exception {
		userService.remove(model.getId());
		return "toList";
	}
	
	public String list() throws Exception {
		List<User> userList=userService.findAllUser();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	///--------------
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		return model;
	}



	
	
}
