package cn.scxh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport {
	
	private String username;
	private User user;
	private List<User> userList = new ArrayList<User>();
	private Map<String,String> map = new HashMap<String,String>();

	@Override
	public String execute() throws Exception {
		
		
		username = "张安";
		user = new User();
		user.setUsername("李四");
		
		//向list添加对象
		User user1 = new User();
		user1.setUsername("user1");
		user1.setPassword("u1");
		user1.setAge(5);
		
		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword("222");
		user2.setAge(18);
		
		User user3 = new User();
		user3.setUsername("user3");
		user3.setPassword("222");
		user3.setAge(25);
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		map.put("cc", "CC");
		map.put("dd", "DD");
		
		
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void m(){
		System.out.println("jmmmmmmmmmmmmmmmmmmmm");
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
	
	
}
