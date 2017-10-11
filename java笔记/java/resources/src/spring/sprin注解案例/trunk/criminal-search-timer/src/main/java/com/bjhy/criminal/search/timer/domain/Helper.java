package com.bjhy.criminal.search.timer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 同步帮助实体
 * @author 吴波
 *
 */
public class Helper {
	
	/**
	 * 采用update的方式进行更新
	 */
	public static final String TO_UPDATE = "update"; 
	
	/**
	 * 采用delete的方式进行更新
	 */
	public static final String TO_DELETE = "delete";
	
	/**
	 * 数据来源的JdbcTemplate
	 */
	private JcsjJdbcTemplate fromTemplate;
	
	/**
	 * 将数据同步到那个数据源的JdbcTemplate,目标数据源
	 */
	private JcsjJdbcTemplate toTemplate;
	
	/**
	 * 将数据同步到那张表,目标表
	 */
	private String toTableName;
	
	/**
	 * 数据来源的sql
	 */
	private String fromSql;
	
	/**
	 * 更新方式,默认采用delete的方式进行更新
	 */
	private String updateMode = Helper.TO_DELETE;
	
	/**
	 * 将数据源同步到目标表的主键
	 */
	private String toPrimaryKeyId;
	
	/**
	 * 如何一张表中有唯一列,或者我们需要用某一列或几列进行数据删除时,我们就可以使用该字段,如何 toPrimaryKeyId 这个属性不为null,
	 * 那么该属性将联合 toPrimaryKeyId 一起作为条件使用
	 */
	private List<String> toColumnList = new ArrayList<String>();
	
	/**
	 * 将数据同步到目标表,额外增加的列与值,
	 */
	private Map<String,Object> toColumnMap = new HashMap<String,Object>();
	
	public Helper(){}
	
	public Helper(JcsjJdbcTemplate fromTemplate, JcsjJdbcTemplate toTemplate,
			String toTableName, String fromSql, String toPrimaryKeyId,
			List<String> toColumnList, Map<String, Object> toColumnMap) {
		super();
		this.fromTemplate = fromTemplate;
		this.toTemplate = toTemplate;
		this.toTableName = toTableName;
		this.fromSql = fromSql;
		this.toPrimaryKeyId = toPrimaryKeyId;
		this.toColumnList = toColumnList;
		this.toColumnMap = toColumnMap;
	}

	public JcsjJdbcTemplate getFromTemplate() {
		return fromTemplate;
	}

	public void setFromTemplate(JcsjJdbcTemplate fromTemplate) {
		this.fromTemplate = fromTemplate;
	}

	public JcsjJdbcTemplate getToTemplate() {
		return toTemplate;
	}

	public void setToTemplate(JcsjJdbcTemplate toTemplate) {
		this.toTemplate = toTemplate;
	}

	public String getToTableName() {
		return toTableName;
	}

	public void setToTableName(String toTableName) {
		this.toTableName = toTableName;
	}

	public String getFromSql() {
		return fromSql;
	}

	public void setFromSql(String fromSql) {
		this.fromSql = fromSql;
	}

	public String getToPrimaryKeyId() {
		return toPrimaryKeyId;
	}

	public String getUpdateMode() {
		return updateMode;
	}

	public void setUpdateMode(String updateMode) {
		this.updateMode = updateMode;
	}

	public void setToPrimaryKeyId(String toPrimaryKeyId) {
		this.toPrimaryKeyId = toPrimaryKeyId;
	}

	public List<String> getToColumnList() {
		return toColumnList;
	}

	public void setToColumnList(List<String> toColumnList) {
		this.toColumnList = toColumnList;
	}

	public Map<String, Object> getToColumnMap() {
		return toColumnMap;
	}

	public void setToColumnMap(Map<String, Object> toColumnMap) {
		this.toColumnMap = toColumnMap;
	}
}
