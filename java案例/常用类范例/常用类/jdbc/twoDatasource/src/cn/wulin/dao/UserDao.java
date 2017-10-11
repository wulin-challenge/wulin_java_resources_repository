package cn.wulin.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.wulin.domain.User;

public interface UserDao {

	public List<User> findUser()throws SQLException;
	public int getMaxIdOracle() throws SQLException;
	public int getMaxIdMysql() throws SQLException;
	public List<User> findUser1(Date previously) throws SQLException;
	public Date getNewTimeOracle() throws SQLException;
	public Date getNewTimeMysql() throws SQLException;
	public List<User> findUserJdbc();
	
}
