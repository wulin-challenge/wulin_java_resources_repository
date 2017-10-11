package com.bjhy.criminal.search.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bjhy.criminal.search.timer.command.Command;
import com.bjhy.criminal.search.timer.config.PersistConfig;
import com.bjhy.criminal.search.timer.service.RewardService;
import com.bjhy.criminal.search.timer.service.StoreDataService;
import com.bjhy.criminal.search.timer.tool.CriminalSearchSqlUtis;
@Service("rewardService")
public class RewardServiceImpl  implements RewardService,Command{
	@Autowired
	private PersistConfig persistConfig;
	
	@Autowired
	@Qualifier("yzJdbcTemplate")
	private JdbcTemplate yzJdbcTemplate;//各个监狱的集合
	
	@Autowired
	private StoreDataService storeDataService; 
	
	@Override
	public void analyze() {
		this.storeDataService.saveOrUpdateData("t_zfxzjl", getCriminalRewardInfo());
	}

	@Override
	public List<Map<String, Object>> getCriminalRewardInfo() {
		return yzJdbcTemplate.queryForList(CriminalSearchSqlUtis.criminalRewardSql);
	}

}
