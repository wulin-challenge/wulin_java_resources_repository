package com.bjhy.criminal.search.timer.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bjhy.criminal.search.timer.domain.DataSourceAndTemplate;
import com.bjhy.criminal.search.timer.domain.JcsjJdbcTemplate;
import com.bjhy.criminal.search.timer.tool.DBUtil;



@Component
//@PropertySource("classpath:db.properties")
public class PersistConfig{
	
	@Bean(name="yzJdbcTemplateList")
	public DataSourceAndTemplate yzJdbcTemplateList(){
		DataSourceAndTemplate template = new DataSourceAndTemplate();
		List<JcsjJdbcTemplate> oracleTemplateList = new DBUtil().getJdbcTemplateList("YZ", "JLYZ", "ORACLE");
		List<JcsjJdbcTemplate> dmTemplateList = new DBUtil().getJdbcTemplateList("YZ", "JLYZ", "DM");
		List<JcsjJdbcTemplate> jdbcTemplateList = new ArrayList<JcsjJdbcTemplate>();
		jdbcTemplateList.addAll(oracleTemplateList);
		jdbcTemplateList.addAll(dmTemplateList);
		template.setJcsjJdbcTemplateList(jdbcTemplateList);
		return template;
	}
	
	@Bean(name="jcsjJdbcTemplateList")
	public DataSourceAndTemplate jcsjJdbcTemplateList(){
		DataSourceAndTemplate template = new DataSourceAndTemplate();
		template.setJcsjJdbcTemplateList(new DBUtil().getJdbcTemplateList("JCSJ", "JLJCSJ", "ORACLE"));
		return template;
	}
	
	
	@Bean(name="yzJdbcTemplate")
	public JdbcTemplate yzJdbcTemplateList1(){
		return null;
	}
	
	@Bean(name="zfjcJdbcTemplate")
	public JdbcTemplate yzJdbcTemplateList2(){
		return null;
	}
	
	
	

}
