package cn.scxh.service.intf;

import java.util.List;

import cn.scxh.model.User;

public interface UserService {

	public void register(User user);
	public List<User> getUsers(User user);
	public User getUser(String id);
}
