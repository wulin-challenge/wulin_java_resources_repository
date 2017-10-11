package cn.lh.dao;

import cn.lh.domain.UserLogin;

public interface UserLoginDao {

	/**
	 * 特病
	 * @param suid
	 * @param sess
	 * @param spid
	 * @return
	 */
	public UserLogin findUserLogin1(String suid,String sess,String spid);
	
	/**
	 * 异地就医
	 * @param suid
	 * @param sess
	 * @param spid
	 * @return
	 */
	public UserLogin findUserLogin2(String suid,String sess,String spid);
	
	/**
	 * 单病
	 * @param suid
	 * @param sess
	 * @param spid
	 * @return
	 */
	public UserLogin findUserLogin3(String suid,String sess,String spid);
	
	/**
	 * 医保卡
	 * @param suid
	 * @param sess
	 * @param spid
	 * @return
	 */
	public UserLogin findUserLogin4(String suid,String sess,String spid);
}
