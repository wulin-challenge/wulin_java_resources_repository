package com.bjhy.criminal.search.timer.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 吴波
 *
 */
public class DataSourceAndTemplate {
	private List<JcsjJdbcTemplate> JcsjJdbcTemplateList = new ArrayList<JcsjJdbcTemplate>();

	public List<JcsjJdbcTemplate> getJcsjJdbcTemplateList() {
		return JcsjJdbcTemplateList;
	}

	public void setJcsjJdbcTemplateList(List<JcsjJdbcTemplate> jcsjJdbcTemplateList) {
		JcsjJdbcTemplateList = jcsjJdbcTemplateList;
	}

}
