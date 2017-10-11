package com.bjhy.criminal.search.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bjhy.criminal.search.timer.command.Command;
import com.bjhy.criminal.search.timer.config.PersistConfig;
import com.bjhy.criminal.search.timer.service.CriminalBaseInfoService;
import com.bjhy.criminal.search.timer.service.StoreDataService;
import com.bjhy.criminal.search.timer.tool.CriminalSearchSqlUtis;

@Service("criminalBaseInfo")
public class CriminalBaseInfoServiceImpl implements CriminalBaseInfoService, Command{
 
	@Autowired
	private PersistConfig persistConfig;
	@Autowired
	@Qualifier("yzJdbcTemplate")
	private JdbcTemplate yzJdbcTemplate;
	@Autowired
	private StoreDataService storeDataService; 

//	@Autowired
//	private PersistConfig persistConfig;
//	@Autowired
//	@Qualifier("yzJdbcTemplate")
//	private JdbcTemplate yzJdbcTemplate;
//	@Autowired
//	@Qualifier("zfjcJdbcTemplate")
//	private JdbcTemplate zfjcJdbcTemplate;
	

	@Override
	public void analyze() {
		this.storeDataService.saveOrUpdateData("BS_BSINFO", getCriminalCurrentInfo());
	}
	
	@Override
	public List<Map<String, Object>> getCriminalCurrentInfo() {

		return yzJdbcTemplate.queryForList(CriminalSearchSqlUtis.criminalBaseInfoSql);
		//return basicYzJdbcTemplate.queryForList(CriminalSearchSqlUtis.criminalBaseInfoSql);

		//return yzJdbcTemplate.queryForList(CriminalSearchSqlUtis.getCriminalCurrentSql());

	}
	
	

}
