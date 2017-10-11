package cn.wulin.action;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.User;

public class UserAction extends ModelDrivenBaseAction<User>{
	private static final long serialVersionUID = -3256643986658014183L;

	/**用户登陆*/
	public String login() throws Exception {
		try {
			User user = new User();
			user.setUsername(model.getUsername());
			user.setPassword(model.getPassword());
			System.out.println(model.getUsername()+","+model.getPassword());
			user = userService.findByUsernameAndPassword(user);
			if(user == null){
				user = new User();
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			JSONObject userJson = JSONObject.fromObject(user);
			response.getWriter().print(userJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**添加用户*/
	public String add() throws Exception {
		User user = new User();
		user.setUsername(model.getUsername());
		user.setPassword(model.getPassword());
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
}
