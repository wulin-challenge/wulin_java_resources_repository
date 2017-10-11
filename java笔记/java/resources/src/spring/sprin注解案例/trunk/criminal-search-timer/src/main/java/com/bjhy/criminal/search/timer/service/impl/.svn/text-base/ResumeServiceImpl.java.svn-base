package com.bjhy.criminal.search.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bjhy.criminal.search.timer.command.Command;
import com.bjhy.criminal.search.timer.config.PersistConfig;
import com.bjhy.criminal.search.timer.service.ResumeService;
import com.bjhy.criminal.search.timer.service.StoreDataService;
import com.bjhy.criminal.search.timer.tool.CriminalSearchSqlUtis;

@Service("resumeService")
public class ResumeServiceImpl  implements ResumeService,Command{
	@Autowired
	private PersistConfig persistConfig;
	@Autowired
	@Qualifier("yzJdbcTemplate")
	private JdbcTemplate yzJdbcTemplate;
	
	@Autowired
	private StoreDataService storeDataService; 
	
	@Override
	public void analyze() {
		this.storeDataService.saveOrUpdateData("bs_zfjl", getResumeInfo());
	}

	@Override
	public List<Map<String, Object>> getResumeInfo() {
		return yzJdbcTemplate.queryForList(CriminalSearchSqlUtis.criminalResumeSql);
	}

}
