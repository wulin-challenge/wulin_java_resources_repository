package cn.xh.dao.intf;

import java.util.List;

import cn.xh.domain.User;

public interface UserDao {
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 编辑用户
	 * @param user
	 */
	public void editUser(User user);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	public List<User> findAllUser();
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void remove(Long id);

	public User getById(Long id);

}
