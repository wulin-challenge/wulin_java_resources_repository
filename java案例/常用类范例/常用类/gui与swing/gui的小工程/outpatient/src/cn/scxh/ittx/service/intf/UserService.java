package cn.scxh.ittx.service.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface UserService {
	//添加用户
	public void addUser(User user)throws AddObjectException;
	//根据id删除用户
	public void deleteUserById(User user) throws DeleteObjectException;
	//根据id更改用户
	public void updateuserById(User user)throws UpdateObjectException;
	//根据id查找用户
	public List<User> queryUserById(User user)throws QueryObjectException;
	//查找所有的用户
	public List<User> queryUsers(User user)throws QueryObjectException;

	//多条件查询
	public List<User> variousConditionQueryUsers(User user) throws QueryObjectException;
}
