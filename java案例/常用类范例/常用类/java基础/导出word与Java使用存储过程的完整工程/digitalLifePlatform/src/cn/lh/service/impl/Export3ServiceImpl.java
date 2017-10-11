package cn.lh.service.impl;

import cn.lh.dao.Export3Dao;
import cn.lh.dao.impl.Export3DaoImpl;
import cn.lh.domain.Export3;
import cn.lh.service.Export3Service;



public class Export3ServiceImpl implements Export3Service{

	public Export3 findExpor3(String suid, String sess, String spid) {
		Export3Dao dao = new Export3DaoImpl();
		return dao.findExpor3(suid, sess, spid);
	}

	

}
