package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.User;

public interface UserDao {
	//添加用户
	public void addUser(User user)throws SQLException;
	//根据id删除用户
	public void deleteUserById(User user)throws SQLException;
	//根据id更改用户
	public void updateuserById(User user)throws SQLException;
	//根据id查找用户
	public List<User> queryUserById(User user)throws SQLException;
	//查找所有的用户
	public List<User> queryUsers(User user)throws SQLException;
	//多条件查询
	public List<User> variousConditionQueryUsers(User user) throws SQLException;
}
