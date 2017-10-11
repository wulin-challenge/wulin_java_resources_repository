package cn.lh.service.impl;

import cn.lh.dao.Export1Dao;
import cn.lh.dao.impl.Export1DaoImpl;
import cn.lh.domain.Export1;
import cn.lh.service.Export1Service;

public class Export1ServiceImpl implements Export1Service{

	public Export1 findExport1(String suid, String sess, String sspid) {
		Export1Dao export1Dao = new Export1DaoImpl();
		return export1Dao.findExport1(suid, sess, sspid);
	}
	
}
