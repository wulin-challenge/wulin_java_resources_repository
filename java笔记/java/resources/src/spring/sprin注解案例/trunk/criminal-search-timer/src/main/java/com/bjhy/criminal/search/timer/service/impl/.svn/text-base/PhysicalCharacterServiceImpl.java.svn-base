package com.bjhy.criminal.search.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bjhy.criminal.search.timer.command.Command;
import com.bjhy.criminal.search.timer.config.PersistConfig;
import com.bjhy.criminal.search.timer.service.PhysicalCharacterService;
import com.bjhy.criminal.search.timer.service.StoreDataService;
import com.bjhy.criminal.search.timer.tool.CriminalSearchSqlUtis;
@Service("physicalCharacterService")
public class PhysicalCharacterServiceImpl implements PhysicalCharacterService,Command {
	@Autowired
	private PersistConfig persistConfig;
	
	@Autowired
	@Qualifier("yzJdbcTemplate")
	private JdbcTemplate yzJdbcTemplate;//各个监狱的集合
	
	@Autowired
	private StoreDataService storeDataService; 
	
	@Override
	public void analyze() {
		this.storeDataService.saveOrUpdateData("bs_tmtz", getPhysicalCharacterInfo());
	}
	@Override
	public List<Map<String, Object>> getPhysicalCharacterInfo() {
		return yzJdbcTemplate.queryForList(CriminalSearchSqlUtis.criminalPhysicalSql);
	}

}
