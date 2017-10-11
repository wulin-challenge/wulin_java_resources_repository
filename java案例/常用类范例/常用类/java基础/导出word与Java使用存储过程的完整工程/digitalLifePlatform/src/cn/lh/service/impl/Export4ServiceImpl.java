package cn.lh.service.impl;

import cn.lh.dao.Export4Dao;
import cn.lh.dao.impl.Export4DaoImpl;
import cn.lh.domain.Export4;
import cn.lh.service.Export4Service;

public class Export4ServiceImpl implements Export4Service{

	public Export4 findExpor4(String suid, String sess, String spid) {
		Export4Dao dao = new Export4DaoImpl();
		return dao.findExpor4(suid, sess, spid);
	}

}
