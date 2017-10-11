package cn.wulin.action;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.wulin.domain.User;
import cn.wulin.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = -3256643986658014183L;

	private UserService userService;
	private String username;
	private String password;
	
	/**用户登陆*/
	public String login() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user = userService.findByUsernameAndPassword(user);
		if(user == null){
			user = new User();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject userJson = JSONObject.fromObject(user);
		response.getWriter().print(userJson);
		return null;
	}
	
	/**添加用户*/
	public String add() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.saveEntity(user);
		System.out.println("ok");
		return null;
	}
	
	/**得到用户Tree*/
	public String getTree() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String userTree = "[{\"id\":\"user1\",\"text\":\"用户1\",\"leaf\":\"false\",\"children\":[{\"id\":\"user2\",\"text\":\"用户2\",\"leaf\":\"true\"}]}]";
		response.getWriter().write(userTree);
		return null;
	}
	//-----set and get method-----
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
