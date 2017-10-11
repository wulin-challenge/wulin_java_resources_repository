package cn.scxh.dao.intf;

import java.util.List;

import cn.scxh.model.User;

public interface UserDao {

	public void insert(User user);
	public List<User> getUserList(User user);
	public User getUserById(String id);
}
