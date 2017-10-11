package cn.lh.service.impl;

import cn.lh.dao.Export2Dao;
import cn.lh.dao.impl.Export2DaoImpl;
import cn.lh.domain.Export2;
import cn.lh.service.Export2Service;

public class Export2ServiceImpl implements Export2Service{

	public Export2 findExpor2(String suid, String sess, String spid) {
		Export2Dao dao = new Export2DaoImpl();
		return dao.findExpor2(suid, sess, spid);
	}

}
