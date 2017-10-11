package com.bjhy.criminal.search.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bjhy.criminal.search.timer.command.Command;
import com.bjhy.criminal.search.timer.config.PersistConfig;
import com.bjhy.criminal.search.timer.service.CriminalArrestService;
import com.bjhy.criminal.search.timer.service.StoreDataService;
import com.bjhy.criminal.search.timer.tool.CriminalSearchSqlUtis;
/**
 * 罪犯收押逮捕情况
 * @author wangbowen
 * @date 2015-12-11
 * @version 1.0
 *
 */
@Service("criminalArrestService")
public class CriminalArrestServiceImpl  implements CriminalArrestService,Command{
	@Autowired
	private PersistConfig persistConfig;
	@Autowired
	@Qualifier("yzJdbcTemplate")
	private JdbcTemplate yzJdbcTemplate;
	
	@Autowired
	private StoreDataService storeDataService; 
	@Override
	public void analyze() {
		this.storeDataService.saveOrUpdateData("bs_zfsyqk", getCriminalArrestInfo());		
	}

	@Override
	public List<Map<String, Object>> getCriminalArrestInfo() {
		return yzJdbcTemplate.queryForList(CriminalSearchSqlUtis.criminalArrestDetainSql);
	}

}
