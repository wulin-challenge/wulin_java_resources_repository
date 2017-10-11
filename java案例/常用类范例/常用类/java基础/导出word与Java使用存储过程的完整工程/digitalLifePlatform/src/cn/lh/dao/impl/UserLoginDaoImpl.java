package cn.lh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import cn.lh.dao.UserLoginDao;
import cn.lh.domain.UserLogin;
import cn.lh.util.DBUtil;

public class UserLoginDaoImpl implements UserLoginDao{

	/**
	 * 特病
	 */
	public UserLogin findUserLogin1(String suid,String sess,String spid) {
		Connection connection = null;
		ResultSet rs = null;
		CallableStatement call = null;
		UserLogin userLogin = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_spec_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				String msgno = rs.getString("msgno");
				String msg = rs.getString("msg");
				userLogin = new UserLogin();
				userLogin.setMsgno(msgno);
				userLogin.setMsg(msg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return userLogin;
	}

	/**
	 * 异地就医
	 */
	public UserLogin findUserLogin2(String suid, String sess, String spid) {
		Connection connection = null;
		ResultSet rs = null;
		CallableStatement call = null;
		UserLogin userLogin = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_remote_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				String msgno = rs.getString("msgno");
				String msg = rs.getString("msg");
				userLogin = new UserLogin();
				userLogin.setMsgno(msgno);
				userLogin.setMsg(msg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return userLogin;
	}

	/**
	 * 单病
	 */
	public UserLogin findUserLogin3(String suid, String sess, String spid) {
		Connection connection = null;
		ResultSet rs = null;
		CallableStatement call = null;
		UserLogin userLogin = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_single_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				String msgno = rs.getString("msgno");
				String msg = rs.getString("msg");
				userLogin = new UserLogin();
				userLogin.setMsgno(msgno);
				userLogin.setMsg(msg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return userLogin;
	}

	/**
	 * 医保卡
	 */
	public UserLogin findUserLogin4(String suid, String sess, String spid) {
		Connection connection = null;
		ResultSet rs = null;
		CallableStatement call = null;
		UserLogin userLogin = null;
		try{
			connection = DBUtil.getContection();
			call = connection.prepareCall("{call a1_gj_insure_doc_query(?,?,?)}");
			call.setString(1,suid);
			call.setString(2,sess);
			call.setString(3,spid);
			call.execute();
			rs = call.getResultSet();
			while(rs.next()){
				String msgno = rs.getString("msgno");
				String msg = rs.getString("msg");
				userLogin = new UserLogin();
				userLogin.setMsgno(msgno);
				userLogin.setMsg(msg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, call, connection);
		}
		return userLogin;
	}

}
