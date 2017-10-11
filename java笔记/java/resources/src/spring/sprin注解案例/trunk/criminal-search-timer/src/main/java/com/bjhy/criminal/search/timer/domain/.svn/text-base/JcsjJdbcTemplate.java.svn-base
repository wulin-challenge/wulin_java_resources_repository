package com.bjhy.criminal.search.timer.domain;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 在拿到JdbcTemplate的同时可以拿到 对应的配置信息及数据源
 * @author 吴波
 *
 */
public class JcsjJdbcTemplate extends JdbcTemplate{
	
	/**
	 * 配置的连接信息
	 */
	private ConnectConfig connectConfig;
	
	/**
	 * 数据源连接信息
	 */
	private DataSource dataSource;
	
	
	public JcsjJdbcTemplate() {
		super();
	}
	public JcsjJdbcTemplate(DataSource dataSource, boolean lazyInit) {
		super(dataSource, lazyInit);
	}
	public JcsjJdbcTemplate(DataSource dataSource) {
		super(dataSource);
	}
	public ConnectConfig getConnectConfig() {
		return connectConfig;
	}
	public void setConnectConfig(ConnectConfig connectConfig) {
		this.connectConfig = connectConfig;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
